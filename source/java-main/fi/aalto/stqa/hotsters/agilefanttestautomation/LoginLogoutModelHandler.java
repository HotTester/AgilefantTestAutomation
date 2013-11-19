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

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.datamodel.AgilefantDataModel;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;




/**
 * Remember to start the selenium server, before running the test:
 * java -jar lib/selenium-server.jar -singleWindow
 */
public class LoginLogoutModelHandler extends ModelAPI {

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
    /* EMPTY */
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
    context().setDriver(
        context().browserDriverFactory().createFirefoxDriverInstance());
    context().driver().navigate().to(URL_ALIEN_PAGE);
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
    context().driver().quit();
    context().setDriver(null);
  }



  /**
   * 
   */
  public void LoginPage_Open() {
    log.info("Opening login page..."); //$NON-NLS-1$
    context().driver().navigate().to(dataModel().agilefantBaseUrl());
  }



  /**
   * 
   */
  public void LoginPage_Opened() {
    log.info("Verifying presence of the login page."); //$NON-NLS-1$
    getMbt().passRequirement(true);
  }



  /**
   * 
   */
  public void LoginPage_ToggleRememberMe() {
    // rememberMeCheckbox()
  }



  /**
   * 
   */
  public void LoginPage_EnterValidUserCredentials() {

  }



  /**
   * 
   */
  public void LoginPage_EnterInvalidUserCredentials() {

  }



  /**
   * 
   */
  public void LoginPage_VerifyPresenceOfInvalidLoginError() {

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

  }



  /**
   * 
   */

  public void Header_LogoutLink_Click() {

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

} // end of class LoginLogoutModelHandler
