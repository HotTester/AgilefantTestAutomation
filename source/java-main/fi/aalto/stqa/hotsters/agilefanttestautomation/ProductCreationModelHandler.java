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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.datamodel.AgilefantDataModel;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel.CreateProductDialog;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel.MainPage;




/**
 * Remember to start the selenium server, before running the test:
 * java -jar lib/selenium-server.jar -singleWindow
 */
public class ProductCreationModelHandler extends ModelAPI {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_PRESENCE_OF_THE_MAIN_PAGE_COULD_NOT_BE_VERIFIED = 
      "Presence of the main page could not be verified."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_PRESENCE_OF_THE_PRODUCT_DIALOG_COULD_NOT_BE_VERIFIED = 
      "Presence of the product dialog could not be verified."; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private final String URL_ALIEN_PAGE = "http://www.google.com/"; //$NON-NLS-1$

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
      throw CreateException.forNullArgument("testContext"); //$NON-NLS-1$
    }
    _testContext = testContext;
    log.info("Model handler created."); //$NON-NLS-1$
  }




  /**
   *
   */
  public void MainPage_Opened() {
    final boolean mainPagePresent =
        context().uiModel().mainPage().verifyPresence();

    if (!mainPagePresent) {
      failRequirement();
      abortWithMessage(ERR_MSG_PRESENCE_OF_THE_MAIN_PAGE_COULD_NOT_BE_VERIFIED);
    }

    passRequirement();
  }



  /**
   *
   */
  public void CreateProductDialog_CancelButton_Click() {
    context().uiModel().createProductDialog().cancelButton().click();
  }



  /**
   *
   */
  public void CreateProductDialog_EnterInvalidProductInformationAndSave() {
    final CreateProductDialog dialog = context().uiModel().createProductDialog();


    dialog.okButton().click();
  }



  /**
   *
   */
  public void CreateProductDialog_EnterProductInformationAndSave() {

    final WebDriver driver = context().driver();
    // Click on Name text field
    driver
        .findElement(
            By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[@type='text'][1]")) //$NON-NLS-1$
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
   *
   */
  public void Header_CreateNewProductLink_Click() {
    final MainPage mainPage = context().uiModel().mainPage();

    mainPage.createNewMenuLink().click();
    mainPage.createNewProductLink().click();
  }



  /**
   *
   */
  public void noOp() {
    /* EMPTY */
  }



  /**
   *
   */
  public void CreateProductDialog_Opened() {
    final boolean productDialogPresent =
        context().uiModel().createProductDialog().verifyPresence();

    if (!productDialogPresent) {
      failRequirement();
      abortWithMessage(ERR_MSG_PRESENCE_OF_THE_PRODUCT_DIALOG_COULD_NOT_BE_VERIFIED);
    }

    passRequirement();
  }



  /**
   *
   */
  public void CreateProductDialog_VerifyInvalidInputErrorMessage() {
  }



  /**
   *
   */
  public void MainPage_VerifyProductCreation() {
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
   * 
   */
  public void MiscellaneousAlienPage_Open() {
    context().driver().navigate().to(URL_ALIEN_PAGE);
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



  /**
   * @param message
   */
  private static void abortWithMessage(final String message) {
    Util.AbortIf(true, message);
  }



  /**
   * @return the dataModel
   */
  public final AgilefantDataModel dataModel() {
    return _dataModel;
  }

} // end of class ProductCreationModelHandler
