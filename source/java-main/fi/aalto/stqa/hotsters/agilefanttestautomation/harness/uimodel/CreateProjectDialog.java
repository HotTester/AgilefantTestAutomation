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
 * @author Ruben
 */
public class CreateProjectDialog {

  // @formatter:off
  /**  */
  private static final String CREATE_NEW_PROJECT_DIALOG_TITLE = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
      "//span[@class='ui-dialog-title' and text()='Create a new project']"; //$NON-NLS-1$

  /** */
  private static final String XPATH_PROJECT_NAME_FIELD = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
      "//input[not(contains(@class, 'hasDatepicker')) and not(@role='textbox')][1]"; //$NON-NLS-1$

  /** */
  private static final String XPATH_PRODUCT_NAME_FIELD = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
      "//input[@role='textbox'][1]"; //$NON-NLS-1$
  
  /** */
  private static final String XPATH_START_DATE_FIELD = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
        "//input[contains(@class, 'hasDatepicker') and not(@role='textbox')][1]"; //$NON-NLS-1$
  
  // need a way to differenciate start_date and end_date or just set them as default
  /** */
  private static final String XPATH_END_DATE_FIELD = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
			"//input[contains(@class, 'hasDatepicker') and not(@role='textbox')][1]";  //$NON-NLS-1$
  
  /**  */
  private static final String XPATH_OK_BUTTON = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
      "//button[@type='button'][2]"; //$NON-NLS-1$
  
  /**  */
  private static final String XPATH_CANCEL_BUTTON = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
      "//button[@type='button'][1]"; //$NON-NLS-1$
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
   * @return
   */
  public void verifyPresence() {
    try {
      dialogTitle();
    }
    catch (final Exception e) {
      log.error("Dialog title for the Create a new project dialog was not found.");
      Util.AbortIf(true, "Verification failed");
    }
  }



  /**
   * @return
   */
  public WebElement dialogTitle() {
    return findElementByXPath(CREATE_NEW_PROJECT_DIALOG_TITLE);
  }



  /**
   * @return
   */
  public WebElement projectNameField() {
    return findElementByXPath(XPATH_PROJECT_NAME_FIELD);
  }



  /**
   * @return
   */
  public WebElement productNameField() {
    return findElementByXPath(XPATH_PRODUCT_NAME_FIELD);
  }



  /**
   * @return
   */
  public WebElement startDateField() {
    return findElementByXPath(XPATH_START_DATE_FIELD);
  }



  /**
   * @return
   */
  public WebElement endDateField() {
    return findElementByXPath(XPATH_END_DATE_FIELD);
  }



  /**
   * @return
   */
  public WebElement okButton() {
    return findElementByXPath(XPATH_OK_BUTTON);
  }



  /**
   * @return
   */
  public WebElement cancelButton() {
    return findElementByXPath(XPATH_CANCEL_BUTTON);
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

} // end of class CreateProjectDialog
