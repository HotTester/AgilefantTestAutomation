
package fi.aalto.stqa.hotsters.agilefanttestautomation;


/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 *
 * Group Exercise of Team Hotsters
 */
import java.io.File;

import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.datamodel.AgilefantDataModel;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;




/**
 * Remember to start the selenium server, before running the test:
 * java -jar lib/selenium-server.jar -singleWindow
 */
public class ProductCreationModelHandler extends ModelAPI {

  /**  */
  private final TestContext _testContext;
  /**  */

  private final AgilefantDataModel _dataModel = AgilefantDataModel.instance();

  /**  */
  private final Logger log = Util.setupLogger(ProductCreationModelHandler.class);



  /**
   * @param model
   * @param efsm
   * @param generator
   * @param weight
   * @param testContext
   */
  public ProductCreationModelHandler(
      final File model,
      final boolean efsm,
      final PathGenerator generator,
      final boolean weight,
      final TestContext testContext) {

    super(model, efsm, generator, weight);

    if (testContext == null) {
      throw CreateException.forNullArgument("testContext"); // \$NON-NLS-1\$
    }
    _testContext = testContext;
    log.info("Model handler created."); // \$NON-NLS-1\$
  }




  /**
   * This method implements the Vertex 'MainPage_Opened'
   */
  public void MainPage_Opened() {
	  final boolean mainPageOpen = context().uiModel().mainPage().verifyPresence();
	  
	  if(!mainPageOpen) {
		  getMbt().passRequirement(false);
	      Util.AbortIf(true, "Dialog title for the Create a new product dialog was not found.");
	  }
	  else {
		  getMbt().passRequirement(true);
	  }
	  
  }



  /**
   * This method implements the Edge 'e_CreateProductDialog_CancelButton_Click'
   */
  public void e_CreateProductDialog_CancelButton_Click() {
	  log.info("Edge: e_CreateProductDialog_CancelButton_ClickClickCancel");
	  context().uiModel().newProductDialog().cancelButton().click(); 
  }



  /**
   * This method implements the Edge 'e_CreateProductDialog_EnterInvalidProductInformationAndSave'
   */
  public void e_CreateProductDialog_EnterInvalidProductInformationAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateProductDialog_EnterProductInformationAndSave'
   */
  public void e_CreateProductDialog_EnterProductInformationAndSave() {
	  log.info("Edge: e_InputDetailsAndSave");
	  WebDriver driver = context().driver();
	  // Click on Name text field
	  driver
	      .findElement(
	          By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[@type='text'][1]"))
	      .click();

	    // Input Product name, which is fetched from testdata.xls
	  /* change to create a new product without the use of excel.
	    driver
	        .findElement(
	            By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[@type='text'][1]"))
	        .sendKeys(productNames.getValue(sheetName, rowIndex, cellnum));

	    // Save
	    driver
	        .findElement(
	            By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//button[@type='button'][2]"))
	        .click();

		// ADD THE NUMBER OF PRODUCTS CREATED, NOT CHANGE THE ROW OF EXCEL FILE
	    // Increase rowIndex by one
	    rowIndex++;
	    if (rowIndex > 5) {
	      rowIndex = 1;
	    }
	    */
  }



  /**
   * This method implements the Edge 'e_Header_CreateNewProductLink_Click'
   */
  public void e_Header_CreateNewProductLink_Click() {
	  log.info("Edge: e_Header_CreateNewProductLink_Click");

	  // Click Create new --> Product
	  context().uiModel().mainPage().menuLink().click();
	  context().uiModel().mainPage().newProductLink().click();
  }



  /**
   * This method implements the Edge 'noOp'
   */
  public void noOp() {
	  //NOTHING?
  }



  /**
   * This method implements the Vertex 'v_CreateProductDialog_Opened'
   */
  public void v_CreateProductDialog_Opened() {
	  
	  final boolean productDialog = context().uiModel().newProductDialog().
			  verifyPresence();
	  
	  if(!productDialog) {
		  getMbt().passRequirement(false);
	      Util.AbortIf(true, "Dialog title for the Create a new product dialog was not found.");
	  }
	  else {
		  getMbt().passRequirement(true);
	  }
  }



  /**
   * This method implements the Vertex 'v_CreateProductDialog_VerifyInvalidInputErrorMessage'
   */
  public void v_CreateProductDialog_VerifyInvalidInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProductCreation'
   */
  public void v_MainPage_VerifyProductCreation() {
	  /* IMPLEMENT WITHOUT EXCEL
	  log.info("Vertex: v_VerifyProductCreation");

	    try {
	      Thread.sleep(5000);
	    }
	    catch (final InterruptedException exception) {
	      // TODO Auto-generated catch block
	      exception.printStackTrace();
	    }

	    // Click All Backlogs menu to open it
	    driver.findElement(By.id("menuAccordion-products")).click();

	    // We need to verify creation of created product
	    final int previousRow = rowIndex - 1 < 1 ? 5 : rowIndex - 1;
	    try {
	      driver.findElement(By.xpath("//div[@id='backlogMenuTree']//a[@class='ui-dynatree-title' and text()='"
	          + productNames.getValue(sheetName, previousRow, cellnum) + "']")).click();
	    }
	    catch (final Exception e) {
	      System.out.println(e);
	      log.error("Could not match: " + productNames.getValue(sheetName, previousRow, cellnum));
	      getMbt().passRequirement(false);
	      Util.AbortIf(true, "Verification failed");
	    }
	    try {
	      driver.findElement(By.xpath("//h2[text()='Product: "
	          + productNames.getValue(sheetName, previousRow, cellnum) + "']"));
	    }
	    catch (final Exception e) {
	      System.out.println(e);
	      log.error("Could not match: Product: " + productNames.getValue(sheetName, previousRow, cellnum));
	      getMbt().passRequirement(false);
	      Util.AbortIf(true, "Verification failed");
	    }
	    getMbt().passRequirement(true);*/
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
} // end of class ProductCreationModelHandler


