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
 * @author Ruben
 */
public class CreateProjectDialog {


  // @formatter:off
  /**  */
  private static final String CREATE_NEW_PROJECT_DIALOG = 
      "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//span[@class='ui-dialog-title' and text()='Create a new project']"; //$NON-NLS-1$

  /** */
  private static final String INPUT_NAME = 
	  "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[not(contains(@class, 'hasDatepicker')) and not(@role='textbox')][1]"; //$NON-NLS-1$
  
  /** */
  private static final String PRODUCT_NAME = 
	  "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[@role='textbox'][1]"; //$NON-NLS-1$
  
  /** */
  private static final String START_DATE =
	"(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[contains(@class, 'hasDatepicker') and not(@role='textbox')][1]";
  
  // need a way to differenciate start_date and end_date or just set them as default
  private static final String END_DATE =
			"(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[contains(@class, 'hasDatepicker') and not(@role='textbox')][1]"; 
  
  /**  */
  private static final String OK_BUTTON = 
	  "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//button[@type='button'][2]"; //$NON-NLS-1$
  
  /**  */
  private static final String CANCEL_BUTTON = 
      "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//button[@type='button'][1]";
  // @formatter:on

  /**  */
  private final TestContext _testContext;

  /**  */
  private final Logger log = Util.setupLogger(CreateProjectDialog.class);


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
      driver.findElement(By.xpath(CREATE_NEW_PROJECT_DIALOG));
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
