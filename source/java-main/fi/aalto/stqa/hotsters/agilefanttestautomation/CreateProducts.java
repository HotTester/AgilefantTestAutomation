
package fi.aalto.stqa.hotsters.agilefanttestautomation;


import java.io.File;

import org.apache.commons.lang.NullArgumentException;
import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




/**
 * Remember to start the selenium server, before running the test:
 * java -jar lib/selenium-server.jar -singleWindow
 */
public class CreateProducts extends ModelAPI {

  private final WebDriver driver;
  private final Logger log = Util.setupLogger(CreateProducts.class);
  private static String url = "http://localhost:8180/agilefant/";
  private final String username = "admin";
  private final String password = "secret";
  private final TestData productNames = new TestData(
      CreateProducts.class.getResourceAsStream("/test-data/agilefantdemo-test-data.xls"));
  private String sheetName;
  private int rowIndex;
  private int cellnum;



  /**
   * @param model
   * @param efsm
   * @param generator
   * @param weight
   * @param webDriver
   */
  public CreateProducts(
      final File model,
      final boolean efsm,
      final PathGenerator generator,
      final boolean weight,
      final WebDriver webDriver) {

    super(model, efsm, generator, weight);

    if (webDriver == null) {
      throw new NullArgumentException("webDriver");
    }
    driver = webDriver;
  }




  /**
   * VERTEXES
   */

  /**
   * This method implements the Vertex 'v_BaseURL'
   * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
   * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
   * the outcome of the verification of that requirement.
   * If no requirement exists, the call does nothing.
   * The user writing the test code, does not have to know whether a requirement exist in the model for
   * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
   * will take care of it, and present the result at the end of the test in the mbt.log file.
   */
  public void v_BaseURL() {
    log.info("Vertex: v_BaseURL");
    final String pageTitle = driver.getTitle();

    if (pageTitle.equals("Agilefant - The simplest solution that might work - Home") == false) {
      log.error("Verification failed: " + pageTitle);
      getMbt().passRequirement(false);
      Util.AbortIf(true, "Verification failed");
    }
    getMbt().passRequirement(true);
  }



  /**
   * This method implements the Vertex 'v_BrowserStarted'
   * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
   * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
   * the outcome of the verification of that requirement.
   * If no requirement exists, the call does nothing.
   * The user writing the test code, does not have to know whether a requirement exist in the model for
   * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
   * will take care of it, and present the result at the end of the test in the mbt.log file.
   */
  public void v_BrowserStarted() {
    log.info("Vertex: v_BrowserStarted");
    String title = null;
    try {
      title = driver.getTitle();
    }
    catch (final Exception e) {
      log.error("Found no open browser");
      getMbt().passRequirement(false);
      Util.AbortIf(true, "Verification failed");
    }
    getMbt().passRequirement(true);
    log.info("Found browser with title: " + title);
  }



  /**
   * This method implements the Vertex 'v_BrowserStopped'
   * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
   * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
   * the outcome of the verification of that requirement.
   * If no requirement exists, the call does nothing.
   * The user writing the test code, does not have to know whether a requirement exist in the model for
   * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
   * will take care of it, and present the result at the end of the test in the mbt.log file.
   */
  public void v_BrowserStopped() {
    log.info("Vertex: v_BrowserStopped");
  }



  /**
   * This method implements the Vertex 'v_Login'
   * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
   * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
   * the outcome of the verification of that requirement.
   * If no requirement exists, the call does nothing.
   * The user writing the test code, does not have to know whether a requirement exist in the model for
   * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
   * will take care of it, and present the result at the end of the test in the mbt.log file.
   */
  public void v_Login() {
    log.info("Vertex: v_Login");

    final String body = driver.getPageSource();

    try {
      driver.findElement(By.xpath("//div[@id='heading' and normalize-space(text())='Agilefant login']"));
    }
    catch (final Exception e) {
      log.error("Could not match: Agilefant login");
      getMbt().passRequirement(false);
      Util.AbortIf(true, "Verification failed");
    }

    getMbt().passRequirement(true);
  }



  /**
   * This method implements the Vertex 'v_AgilefantMainPage'
   * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
   * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
   * the outcome of the verification of that requirement.
   * If no requirement exists, the call does nothing.
   * The user writing the test code, does not have to know whether a requirement exist in the model for
   * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
   * will take care of it, and present the result at the end of the test in the mbt.log file.
   */
  public void v_AgilefantMainPage() {
    log.info("Vertex: v_AgilefantMainPage");

    try {
      driver.findElement(By.linkText("Create new"));
    }
    catch (final Exception e) {
      log.error("Create new link was not found");
      getMbt().passRequirement(false);
      Util.AbortIf(true, "Verification failed");
    }

    try {
      driver.findElement(By.linkText("Help"));
    }
    catch (final Exception e) {
      log.error("Help link was not found");
      getMbt().passRequirement(false);
      Util.AbortIf(true, "Verification failed");
    }

    try {
      driver.findElement(By.linkText("Logout"));
    }
    catch (final Exception e) {
      log.error("Logout link was not found");
      getMbt().passRequirement(false);
      Util.AbortIf(true, "Verification failed");
    }

    getMbt().passRequirement(true);
  }



  /**
   * This method implements the Vertex 'v_CreateNewProduct'
   * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
   * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
   * the outcome of the verification of that requirement.
   * If no requirement exists, the call does nothing.
   * The user writing the test code, does not have to know whether a requirement exist in the model for
   * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
   * will take care of it, and present the result at the end of the test in the mbt.log file.
   */
  public void v_CreateNewProduct() {
    log.info("Vertex: v_CreateNewProduct");

    try {
      driver
          .findElement(By
              .xpath(
              "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//span[@class='ui-dialog-title' and text()='Create a new product']"));
    }
    catch (final Exception e) {
      log.error("Dialog title for the Create a new product dialog was not found.");
      getMbt().passRequirement(false);
      Util.AbortIf(true, "Verification failed");
    }

    getMbt().passRequirement(true);
  }



  /**
   * This method implements the Vertex 'v_VerifyProductCreation'
   * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
   * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
   * the outcome of the verification of that requirement.
   * If no requirement exists, the call does nothing.
   * The user writing the test code, does not have to know whether a requirement exist in the model for
   * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
   * will take care of it, and present the result at the end of the test in the mbt.log file.
   */
  public void v_VerifyProductCreation() {
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
    getMbt().passRequirement(true);
  }



  /**
   * EDGES
   */

  /**
   * This method implements the Edge 'e_init'
   */
  public void e_init() throws Exception {
    log.info("Edge: e_init");

    sheetName = "Product";
    rowIndex = 1;
    cellnum = 0;
  }



  /**
   * This method implements the Edge 'e_EnterBaseURL'
   */
  public void e_EnterBaseURL() {
    log.info("Edge: e_EnterBaseURL");
    driver.navigate().to(url);
  }



  /**
   * This method implements the Edge 'e_StartBrowser'
   */
  public void e_StartBrowser() {
    log.info("Edge: e_StartBrowser");
    if (driver == null) {
      log.error("browser object should not be null. It should have been assigned at e_Init");
      Util.AbortIf(true, "browser object should not be null. It should have been assigned at e_Init");
    }
  }



  /**
   * This method implements the Edge 'e_InputUserCredentials'
   */
  public void e_InputUserCredentials() {
    log.info("Edge: e_InputUserCredentials");

    // Input username admin
    driver.findElement(By.name("j_username")).sendKeys(username);
    log.info("Username: " + username);

    // Input password password
    driver.findElement(By.name("j_password")).sendKeys(password);
    log.info("Password: " + password);

    // Click Log in
    driver.findElement(By.xpath("//input[@type='submit']")).click();
  }



  /**
   * This method implements the Edge 'e_ClickCreateNewProduct'
   */
  public void e_ClickCreateNewProduct() {
    log.info("Edge: e_ClickCreateNewProduct");

    // Click Create new --> Product
    driver.findElement(By.id("createNewMenuLink")).click();
    driver.findElement(By.id("createNewProduct")).click();
  }



  /**
   * This method implements the Edge 'e_InputProductData'
   */
  public void e_InputDetailsAndSave() {
    log.info("Edge: e_InputDetailsAndSave");

    // Click on Name text field
    driver
        .findElement(
            By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[@type='text'][1]"))
        .click();

    // Input Product name, which is fetched from testdata.xls
    driver
        .findElement(
            By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//input[@type='text'][1]"))
        .sendKeys(productNames.getValue(sheetName, rowIndex, cellnum));

    // Save
    driver
        .findElement(
            By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//button[@type='button'][2]"))
        .click();

    // Increase rowIndex by one
    rowIndex++;
    if (rowIndex > 5) {
      rowIndex = 1;
    }
  }



  /**
   * This method implements the Edge 'e_ClickLogout'
   */
  public void e_ClickLogout() {
    log.info("Edge: e_ClickLogout");
    driver.findElement(By.linkText("Logout")).click();
  }



  /**
   * This method implements the Edge 'e_ClickCancel'
   */
  public void e_ClickCancel() {
    log.info("Edge: e_ClickCancel");
    driver
        .findElement(
            By.xpath("(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]//button[@type='button'][1]"))
        .click();
  }
}
