/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel;


import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;




/**
 * @author Aleksi
 */
public class LoginPage {

  // @formatter:off
  /**  */
  private static final String MSG_VERIFYING_PRESENCE_OF_THE_LOGIN_PAGE = 
      "Verifying presence of the login page..."; //$NON-NLS-1$

  /**  */
  private static final String MSG_PRESENCE_OF_THE_LOGIN_PAGE_WAS_VERIFIED = 
      "Presence of the login page was verified."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_LOGIN_PAGE_DIALOG_TITLE_WAS_NOT_FOUND = 
      "Presence of the login page could not be verified."; //$NON-NLS-1$

  /**  */
  private static final String XPATH_LOGINPAGE_DIALOG_TITLE = 
      "//div[@id='heading' and normalize-space(text())='Agilefant login']"; //$NON-NLS-1$

  /**  */
  private static final String XPATH_ERR_MSG_INVALID_UID_OR_PWD = 
      "//div[@id='loginWrapper']/div[@id='messageContainer']/p[" + //$NON-NLS-1$
      "normalize-space(text())='Invalid username or password, please try again.']"; //$NON-NLS-1$

  /**  */
  private static final String NAME_REMEMBER_ME_CHECKBOX = 
      "_spring_security_remember_me"; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private static final String ID_PASSWORD_FIELD = "j_password"; //$NON-NLS-1$

  /**  */
  private static final String ID_USERNAME_FIELD = "j_username"; //$NON-NLS-1$

  /**  */
  private static final String XPATH_LOGIN_BUTTON = "//input[@type='submit']"; //$NON-NLS-1$

  /**  */
  private final TestContext _testContext;

  /**  */
  private final Logger log = Util.setupLogger(LoginPage.class);



  /**
   * @param testContext
   */
  public LoginPage(final TestContext testContext) {
    _testContext = testContext;
  }



  /**
   * @return
   */
  public boolean verifyPresence() {
    log.info(MSG_VERIFYING_PRESENCE_OF_THE_LOGIN_PAGE);

    try {
      dialogTitle();
    }
    catch (final Exception e) {
      log.error(ERR_MSG_LOGIN_PAGE_DIALOG_TITLE_WAS_NOT_FOUND);
      return false;
    }

    log.info(MSG_PRESENCE_OF_THE_LOGIN_PAGE_WAS_VERIFIED);
    return true;
  }



  /**
   * @return
   */
  public WebElement dialogTitle() {
    return findElementByXPath(XPATH_LOGINPAGE_DIALOG_TITLE);
  }



  /**
   * @return
   */
  public WebElement errorMessageInvalidUsernameOrPassword() {
    return findElementByXPath(XPATH_ERR_MSG_INVALID_UID_OR_PWD);
  }



  /**
   * @return
   */
  public WebElement usernameField() {
    return findElementByName(ID_USERNAME_FIELD);
  }



  /**
   * @return
   */
  public WebElement passwordField() {
    return findElementByName(ID_PASSWORD_FIELD);
  }



  /**
   * @return
   */
  public WebElement rememberMeCheckbox() {
    return findElementByName(NAME_REMEMBER_ME_CHECKBOX);
  }



  /**
   * @return
   */
  public WebElement loginButton() {
    return findElementByXPath(XPATH_LOGIN_BUTTON);
  }



  /**
   * @param id
   * @return
   */
  private WebElement findElementById(final String id) {
    return context().driver().findElement(By.id(id));
  }



  /**
   * @param name
   * @return
   */
  private WebElement findElementByName(final String name) {
    return context().driver().findElement(By.name(name));
  }



  /**
   * @param xpath
   * @return
   */
  private WebElement findElementByXPath(final String xpath) {
    return context().driver().findElement(By.xpath(xpath));
  }



  /**
   * @return
   */
  private TestContext context() {
    return _testContext;
  }

} // end of class LoginPage
