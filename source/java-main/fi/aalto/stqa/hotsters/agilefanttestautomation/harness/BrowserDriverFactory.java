/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.NullArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;



/**
 * @author Aleksi
 */
public final class BrowserDriverFactory {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_UNKNOWN_CHARACTER_ENCODING_IDENTIFIER = 
      "Internal error: Unknown character encoding identifier."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_FIREFOX_PROFILE_CANNOT_BE_FOUND_FROM_PATH = 
      "Firefox profile cannot be found from path \"%s\"."; //$NON-NLS-1$

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
  public static final String DEFAULT_FIREFOX_PROFILE_PATH = "/firefox-profile/"; //$NON-NLS-1$

  /**  */
  private int _implicitWaitingTimeoutInSeconds = DEFAULT_IMPLICIT_WAITING_TIMEOUT_IN_SECONDS;

  /** Path for profile to be used during tests by Firefox browser. */
  private String _firefoxProfilePath = DEFAULT_FIREFOX_PROFILE_PATH;



  /**
   * 
   */
  public BrowserDriverFactory() {

  }



  /**
   * @return
   */
  public final WebDriver createFirefoxDriverInstance() {
    final File profilePath = ResourceResolver.resolveBasedOn(firefoxProfilePath());
    final FirefoxProfile profile = new FirefoxProfile(profilePath);
    final WebDriver driver = new FirefoxDriver(profile);

    driver.manage().timeouts().implicitlyWait(
        implicitWaitingTimeoutInSeconds(),
        TimeUnit.SECONDS);

    return driver;
  }



  /**
   * @return the _firefoxProfilePath
   */
  public String firefoxProfilePath() {
    return _firefoxProfilePath;
  }



  /**
   * @param path
   *          the _firefoxProfilePath to set
   */
  public void setFirefoxProfilePath(final String path) {
    if (path == null) {
      throw new NullArgumentException("path"); //$NON-NLS-1$
    }
    if (path.trim().length() < 1) {
      throw new IllegalArgumentException(
          ERR_MSG_LENGTH_OF_THE_PROFILE_PATH_MUST_BE_A_POSITIVE_NUMBER);
    }

    _firefoxProfilePath = path;
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
      throw new IllegalArgumentException(ERR_MSG_TIMEOUT_CANNOT_BE_NEGATIVE);
    }

    _implicitWaitingTimeoutInSeconds = timeout;
  }

} // end of class BrowserDriverFactory
