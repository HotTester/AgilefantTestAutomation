/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;



/**
 * @author Aleksi
 */
public final class BrowserDriverFactory {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_LENGTH_OF_THE_PROFILE_PATH_MUST_BE_A_POSITIVE_NUMBER =
      "Length of the profile path must be a positive number."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_TIMEOUT_CANNOT_BE_NEGATIVE = 
      "Timeout cannot be negative."; //$NON-NLS-1$
  // @formatter:on

  /**  */
  public static final int DEFAULT_IMPLICIT_WAITING_TIMEOUT_IN_SECONDS = 30;


  /** Default path for profile to be used during tests by Firefox browser. */
  public static final String DEFAULT_FIREFOX_PROFILE_TEMPLATE_PATH = "/firefox-profile/"; //$NON-NLS-1$

  /**  */
  private int _implicitWaitingTimeoutInSeconds = DEFAULT_IMPLICIT_WAITING_TIMEOUT_IN_SECONDS;

  /** Path for profile to be used during tests by Firefox browser. */
  private String _firefoxProfileTemplatePath = DEFAULT_FIREFOX_PROFILE_TEMPLATE_PATH;

  /** Path for profile to be used during tests by Firefox browser. */
  private String _temporaryBrowserProfilePath = null;



  /**
   * 
   */
  public BrowserDriverFactory() {

  }



  /**
   * @return
   */
  public final WebDriver createFirefoxDriverInstanceWithCleanProfile() {
    copyFirefoxProfileTemplateToTemporaryFolder();

    return createFirefoxDriverInstanceUsingExistingTemporaryProfile();
  }



  /**
   * @return
   */
  public final WebDriver createFirefoxDriverInstanceUsingExistingTemporaryProfile() {
    return instantiateFirefox();
  }



  /**
   * 
   */
  private void copyFirefoxProfileTemplateToTemporaryFolder() {
    final File sourceFolder = ResourceResolver.resolveBasedOn(firefoxProfileTemplatePath());
    final File targetFolder = new File(temporaryBrowserProfilePath());

    if (!sourceFolder.exists()) {
      throw CreateException.forMissingResource(sourceFolder.getPath());
    }

    if (targetFolder.exists()) {
      try {
        FileUtils.forceDelete(targetFolder);
      }
      catch (final IOException exception) {
        throw CreateException
            .forIoError(
                exception,
                "An exception occurred when trying to delete existing temporary folder assigned for Firefox profile template.\n  Folder: %s\n\n", //$NON-NLS-1$
                targetFolder.getPath());
      }
    }

    try {
      System.out.printf("Copying Firefox profile template...\n  Source: %s\n  Target: %s\n\n", //$NON-NLS-1$
          sourceFolder.getPath(), targetFolder.getPath());

      FileUtils.copyDirectory(sourceFolder, targetFolder);
    }
    catch (final IOException exception) {
      throw CreateException.forIoError(exception,
          "An exception occurred when trying to copy Firefox profile template from %s to %s.", //$NON-NLS-1$
          firefoxProfileTemplatePath(), temporaryBrowserProfilePath());
    }
  }



  /**
   * @return
   */
  private WebDriver instantiateFirefox() {
    final File profilePath = new File(temporaryBrowserProfilePath());
    final FirefoxProfile profile = new FirefoxProfile(profilePath);
    final WebDriver driver = new FirefoxDriver(profile);

    driver.manage().timeouts().implicitlyWait(
        implicitWaitingTimeoutInSeconds(),
        TimeUnit.SECONDS);

    return driver;
  }



  /**
   * @return
   */
  public String firefoxProfileTemplatePath() {
    return _firefoxProfileTemplatePath;
  }



  /**
   * @param path
   */
  public void setFirefoxProfileTemplatePath(final String path) {
    if (path == null) {
      throw CreateException.forNullArgument("path"); //$NON-NLS-1$
    }
    if (path.trim().length() < 1) {
      throw CreateException.forIllegalArgument(
          ERR_MSG_LENGTH_OF_THE_PROFILE_PATH_MUST_BE_A_POSITIVE_NUMBER);
    }

    _firefoxProfileTemplatePath = path;
  }



  /**
   * @return the _implicitWaitingTimeoutInSeconds
   */
  public int implicitWaitingTimeoutInSeconds() {
    return _implicitWaitingTimeoutInSeconds;
  }



  /**
   * @param timeout
   *          the _implicitWaitingTimeoutInSeconds to set
   */
  public void setImplicitWaitingTimeoutInSeconds(final int timeout) {
    if (timeout < 0) {
      throw CreateException.forIllegalArgument(
          ERR_MSG_TIMEOUT_CANNOT_BE_NEGATIVE);
    }

    _implicitWaitingTimeoutInSeconds = timeout;
  }




  /**
   * @return
   */
  public final String temporaryBrowserProfilePath() {
    return _temporaryBrowserProfilePath;
  }




  /**
   * @param path
   */
  public final void setTemporaryBrowserProfilePath(final String path) {
    _temporaryBrowserProfilePath = path;
  }

} // end of class BrowserDriverFactory
