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
public class CreateProductDialog {

  // @formatter:off
  /**  */
  private static final String XPATH_CREATE_NEW_PRODUCT_DIALOG_TITLE =
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG +
      "//span[@class='ui-dialog-title' and text()='Create a new product']"; //$NON-NLS-1$

  /** */
  private static final String XPATH_PRODUCT_NAME_FIELD = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG + "//input[@type='text'][1]"; //$NON-NLS-1$
  
  /**  */
  private static final String XPATH_OK_BUTTON = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG + "//button[@type='button'][2]"; //$NON-NLS-1$
  
  /**  */
  private static final String XPATH_CANCEL_BUTTON = 
      AgilefantUIModel.XPATH_MOST_RECENT_DIALOG + "//button[@type='button'][1]"; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private final TestContext _testContext;

  /**  */
  private final Logger log = Util.setupLogger(CreateProductDialog.class);



  /**
   * @param testContext
   */
  public CreateProductDialog(final TestContext testContext) {
    _testContext = testContext;
  }



  /**
   * @return
   */
  public boolean verifyPresence() {
    try {
      dialogTitle();
    }
    catch (final Exception e) {
      log.error("Dialog title for the Create a new product dialog was not found.");
      return false;
    }

    return true;
  }



  /**
   * @return
   */
  public WebElement dialogTitle() {
    return findElementByXPath(XPATH_CREATE_NEW_PRODUCT_DIALOG_TITLE);
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

} // end of class CreateProductDialog
