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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;




/**
 * @author Rubén
 */
public class CreateProjectDialog {

  /**  */
  private final TestContext _testContext;

  /**  */
  private final Logger log = Util.setupLogger(CreateProjectDialog.class);

  // @formatter:off
  /**  */
  private static final String CREATE_NEW_ITEARATION = "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//span[@class='ui-dialog-title' and text()='Create a new project']";

  /**  */
  private static final String CANCEL_BUTTON = 
      "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//button[@type='button'][1]";
  // @formatter:on



  /**
   * @param testContext
   */
  public CreateProjectDialog(final TestContext testContext) {
    _testContext = testContext;
  }



  /**
   * Verify that the driver is effectively in this page.
   * 
   * @return
   */
  public void verifyPresence() {
    final WebDriver driver = context().driver();

    try {
      driver.findElement(By.xpath(CREATE_NEW_ITEARATION));
    }
    catch (final Exception e) {
      log.error("Dialog title for the Create a new project dialog was not found.");
      Util.AbortIf(true, "Verification failed");
    }
  }



  /**
   * @return
   */
  public WebElement cancelButton() {
    return context().driver().findElement(By.xpath(CANCEL_BUTTON));
  }



  /**
   * @return
   */
  private TestContext context() {
    return _testContext;
  }

} // end of class CreateProjectDialog
