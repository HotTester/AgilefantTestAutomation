package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel;

import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;

public class NewProductDialog {
	
	/**  */
	  private final TestContext _testContext;
	  private final Logger log = Util.setupLogger(NewProductDialog.class);

	  private static final String CREATE_NEW_PRODUCT = "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//span[@class='ui-dialog-title' and text()='Create a new product']";
	  private static final String CANCEL_BUTTON = "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//button[@type='button'][1]";


	  /**
	   * @param testContext
	   */
	  public NewProductDialog(final TestContext testContext) {
	    _testContext = testContext;
	  }



	  /**
	   * @return
	   */
	  private TestContext context() {
	    return _testContext;
	  }
	  
	  /**
	   * Verify that the driver is effectively in this page.
	   * @return 
	   */
	  public boolean VerifyNewProductDialogPresent() {
		  WebDriver driver = context().driver();
		  
		  try {
		      driver
		          .findElement(By.xpath(CREATE_NEW_PRODUCT));
		    }
		    catch (final Exception e) {
		      log.error("Dialog title for the Create a new product dialog was not found.");
		      return false;
		    }	
		  return true;
	  }
	  
	  public WebElement CancelButton() {
		  return context().driver()
			        .findElement(
				            By.xpath(CANCEL_BUTTON));
	  }

}
