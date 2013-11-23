/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation;


import java.io.File;

import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.datamodel.AgilefantDataModel;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel.LoginPage;




/**
 * Remember to start the selenium server, before running the test:
 * java -jar lib/selenium-server.jar -singleWindow
 */
public class LoginLogoutModelHandler extends ModelAPI {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_PRESENCE_OF_THE_LOGIN_PAGE_COULD_NOT_BE_VERIFIED = 
      "Presence of the login page could not be verified."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_PRESENCE_OF_THE_MAIN_PAGE_COULD_NOT_BE_VERIFIED = 
      "Presence of the main page could not be verified."; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private final String URL_ALIEN_PAGE = "http://www.google.com/"; //$NON-NLS-1$

  /**  */
  private final TestContext _testContext;

  /**  */
  private final AgilefantDataModel _dataModel = AgilefantDataModel.instance();

  /**  */
  private final Logger log = Util.setupLogger(LoginLogoutModelHandler.class);

  /**  */
  private boolean _browserWasStartedBefore = false;




  /**
   * @param model
   * @param efsm
   * @param generator
   * @param weight
   * @param testContext
   */
  public LoginLogoutModelHandler(
      final File model,
      final boolean efsm,
      final PathGenerator generator,
      final boolean weight,
      final TestContext testContext) {

    super(model, efsm, generator, weight);

    if (testContext == null) {
      throw CreateException.forNullArgument("testContext"); //$NON-NLS-1$
    }
    _testContext = testContext;

    log.info("Model handler created."); //$NON-NLS-1$
  }



  /**
   * 
   */
  public void ModelHandler_Init() {

  }



  /**
   * 
   */
  public void Browser_NotStarted() {
    if (context().driver() != null) {
      throw CreateException.forIllegalState("WebDriver is supposed to be null, but it isn't."); //$NON-NLS-1$
    }
  }



  /**
   * 
   */
  public void Browser_Start() {
    final WebDriver firefoxDriver;
    if (browserWasStartedBefore()) {
      firefoxDriver = context().browserDriverFactory().createFirefoxDriverInstanceUsingExistingTemporaryProfile();
    }
    else {
      firefoxDriver = context().browserDriverFactory().createFirefoxDriverInstanceWithCleanProfile();
      setBrowserStartedStatus(true);
    }
    context().setDriver(firefoxDriver);
    waitTimeInSeconds(1);

    MiscellaneousAlienPage_Open();
    waitTimeInSeconds(5);
  }



  /**
   * 
   */
  public void Browser_Started() {
    if (context().driver() == null) {
      throw CreateException.forIllegalState("WebDriver instance equals null."); //$NON-NLS-1$
    }
  }



  /**
   * 
   */
  public void Browser_Stop() {
    try {
      Thread.sleep(5000);
    }
    catch (final InterruptedException exception) {
      /* EMPTY */
    }

    context().driver().quit();
    context().setDriver(null);
  }



  /**
   * 
   */
  public void LoginPage_Open() {
    context().driver().navigate().to(dataModel().agilefantBaseUrl());
  }



  /**
   * 
   */
  public void LoginPage_Opened() {
    final boolean loginPagePresent =
        context().uiModel().loginPage().verifyPresence();

    if (!loginPagePresent) {
      failRequirement();
      abortWithMessage(ERR_MSG_PRESENCE_OF_THE_LOGIN_PAGE_COULD_NOT_BE_VERIFIED);
    }

    passRequirement();
  }



  /**
   * 
   */
  public void LoginPage_ToggleRememberMe() {
    dataModel().toggleRememberMeState();
    log.info("Remember Me state switched to " + dataModel().shouldRememberMe()); //$NON-NLS-1$

    setRememberMeCheckboxAccordingToDatamodel();
  }



  /**
   * 
   */
  private void setRememberMeCheckboxAccordingToDatamodel() {
    final WebElement checkbox =
        context().uiModel().loginPage().rememberMeCheckbox();

    if ((dataModel().shouldRememberMe() && !checkbox.isSelected())
        || (!dataModel().shouldRememberMe() && checkbox.isSelected())) {

      checkbox.click();
      log.info("Remember Me checkbox clicked to synchronize state with datamodel.");
    }

    String logMessage;
    if (dataModel().shouldRememberMe()) {
      logMessage = "Agilefant should remember the next login.";
    }
    else {
      logMessage = "Agilefant should not remember the next login.";
    }
    log.info(logMessage);
  }



  /**
   * 
   */
  public void LoginPage_EnterValidUserCredentials() {
    final String username = dataModel().agilefantAdminUsername();
    final String password = dataModel().agilefantAdminPassword();

    enterUserCredentials(username, password);
  }



  /**
   * @param username
   * @param password
   */
  private void enterUserCredentials(final String username, final String password) {
    final LoginPage loginPage = context().uiModel().loginPage();

    loginPage.usernameField().sendKeys(username);
    log.info("Logging in using username: " + username);

    loginPage.passwordField().sendKeys(password);
    log.info("Logging in using password: " + password);

    loginPage.loginButton().click();
  }



  /**
   * 
   */
  public void LoginPage_EnterInvalidUserCredentials() {
    enterUserCredentials(
        "MattiMeikäläinen",
        "HattiWattiMehuKatti");
  }



  /**
   * 
   */
  public void LoginPage_VerifyPresenceOfInvalidLoginError() {
    if (!context().uiModel().loginPage().
        errorMessageInvalidUsernameOrPassword().isDisplayed()) {

      abortWithMessage(
      "The expected error message about invalid " +
          "username and/or password was not displayed.");
    }
  }



  /**
   * 
   */
  public void MiscellaneousAlienPage_Open() {
    context().driver().navigate().to(URL_ALIEN_PAGE);
  }



  /**
   * 
   */
  public void MainPage_Opened() {
    final boolean mainPagePresent =
        context().uiModel().mainPage().verifyPresence();

    if (!mainPagePresent) {
      failRequirement();
      abortWithMessage(ERR_MSG_PRESENCE_OF_THE_MAIN_PAGE_COULD_NOT_BE_VERIFIED);
    }

    passRequirement();
  }



  /**
   * 
   */
  public void Header_LogoutLink_Click() {
    context().uiModel().mainPage().logoutLinkInHeader().click();

    dataModel().setRememberMeState(false);
    log.info("Remember Me state switched to false."); //$NON-NLS-1$
    log.info("Agilefant should not remember the current login any more."); //$NON-NLS-1$
  }



  /**
   * @return
   */
  public WebDriver driver() {
    return context().driver();
  }



  /**
   * @return
   */
  public TestContext context() {
    return _testContext;
  }



  /**
   * @return the dataModel
   */
  public final AgilefantDataModel dataModel() {
    return _dataModel;
  }



  /**
   * @param message
   */
  private static void abortWithMessage(final String message) {
    Util.AbortIf(true, message);
  }



  /**
   * 
   */
  private void passRequirement() {
    getMbt().passRequirement(true);
  }



  /**
   * 
   */
  private void failRequirement() {
    getMbt().passRequirement(false);
  }




  /**
   * @param numberOfSeconds
   */
  private static void waitTimeInSeconds(final int numberOfSeconds) {
    if (numberOfSeconds < 1) {
      throw CreateException.forIllegalArgument("Wait time must be larger than zero.");
    }

    try {
      Thread.sleep(numberOfSeconds * 1000);
    }
    catch (final InterruptedException exception) {
      /* EMPTY */
    }
  }



  /**
   * @return
   */
  public final boolean browserWasStartedBefore() {
    return _browserWasStartedBefore;
  }




  /**
   * @param browserWasStartedBefore
   */
  public final void setBrowserStartedStatus(final boolean browserWasStartedBefore) {
    _browserWasStartedBefore = browserWasStartedBefore;
  }

} // end of class LoginLogoutModelHandler
