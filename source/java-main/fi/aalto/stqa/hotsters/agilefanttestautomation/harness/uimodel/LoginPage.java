/**
 * 
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;



/**
 * @author Aleksi
 */
public class LoginPage {

  /**  */
  private final TestContext _testContext;



  /**
   * @param testContext
   */
  public LoginPage(final TestContext testContext) {
    _testContext = testContext;
  }



  /**
   * @return
   */
  public WebElement rememberMeCheckbox() {
    return context().driver().findElement(By.id("_spring_security_remember_me"));
  }



  /**
   * @return
   */
  private TestContext context() {
    return _testContext;
  }

} // end of class LoginPage
