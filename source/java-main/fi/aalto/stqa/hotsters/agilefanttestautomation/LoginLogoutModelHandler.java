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
  private static final String MSG_OPENING_LOGIN_PAGE = 
      "Opening login page..."; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private final String URL_ALIEN_PAGE = "http://www.google.com/"; //$NON-NLS-1$

  /**  */
  private final TestContext _testContext;

  /**  */
  private final AgilefantDataModel _dataModel = AgilefantDataModel.instance();

  /**  */
  private final Logger log = Util.setupLogger(LoginLogoutModelHandler.class);




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
    log.info("ModelHandler_Init"); //$NON-NLS-1$
  }



  /**
   * 
   */
  public void Browser_NotStarted() {
    log.info("Browser_NotStarted"); //$NON-NLS-1$

    if (context().driver() != null) {
      throw CreateException.forIllegalState("WebDriver is supposed to be null, but it isn't."); //$NON-NLS-1$
    }
  }



  /**
   * 
   */
  public void Browser_Start() {
    log.info("Browser_Start"); //$NON-NLS-1$

    context().setDriver(
        context().browserDriverFactory().createFirefoxDriverInstance());
    MiscellaneousAlienPage_Open();
  }



  /**
   * 
   */
  public void Browser_Started() {
    log.info("Browser_Started"); //$NON-NLS-1$

    if (context().driver() == null) {
      throw CreateException.forIllegalState("WebDriver instance equals null."); //$NON-NLS-1$
    }
  }



  /**
   * 
   */
  public void Browser_Stop() {
    log.info("Browser_Stop"); //$NON-NLS-1$

    context().driver().quit();
    context().setDriver(null);
  }



  /**
   * 
   */
  public void LoginPage_Open() {
    log.info("LoginPage_Open"); //$NON-NLS-1$

    log.info(MSG_OPENING_LOGIN_PAGE);

    context().driver().navigate().to(dataModel().agilefantBaseUrl());
  }



  /**
   * 
   */
  public void LoginPage_Opened() {
    log.info("LoginPage_Opened"); //$NON-NLS-1$

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
    log.info("LoginPage_ToggleRememberMe"); //$NON-NLS-1$

    final WebElement checkbox = context().uiModel().loginPage().rememberMeCheckbox();

    checkbox.click();
    dataModel().setRememberMeState(checkbox.isSelected());

    String logMessage;
    if (checkbox.isSelected()) {
      logMessage = "Agilefant should remember the next login (remember-me state toggled).";
    }
    else {
      logMessage = "Agilefant should not remember the next login (remember-me state toggled).";
    }
    log.info(logMessage);
  }



  /**
   * 
   */
  public void LoginPage_EnterValidUserCredentials() {
    log.info("LoginPage_EnterValidUserCredentials"); //$NON-NLS-1$

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
    log.info("LoginPage_EnterInValidUserCredentials"); //$NON-NLS-1$

    enterUserCredentials(
        "MattiMeikäläinen",
        "HattiWattiMehuKatti");
  }



  /**
   * 
   */
  public void LoginPage_VerifyPresenceOfInvalidLoginError() {
    log.info("LoginPage_VerifyPresenceOfInvalidLoginError"); //$NON-NLS-1$

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
    log.info("MiscellaneousAlienPage_Open"); //$NON-NLS-1$

    context().driver().navigate().to(URL_ALIEN_PAGE);
  }



  /**
   * 
   */
  public void MainPage_Opened() {
    log.info("MainPage_Opened"); //$NON-NLS-1$

  }



  /**
   * 
   */
  public void Header_LogoutLink_Click() {
    log.info("Header_LogoutLink_Click"); //$NON-NLS-1$

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

} // end of class LoginLogoutModelHandler
