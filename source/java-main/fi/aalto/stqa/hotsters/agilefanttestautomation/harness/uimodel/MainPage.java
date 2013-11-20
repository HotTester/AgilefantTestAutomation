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
public class MainPage {

  /**  */
  private final TestContext _testContext;

  /**  */
  private final Logger log = Util.setupLogger(MainPage.class);



  /**
   * @param testContext
   */
  public MainPage(final TestContext testContext) {
    _testContext = testContext;
  }



  /**
   * Verify that the driver is effectively in this page.
   * 
   * @return
   */
  public boolean verifyPresence() {
    final WebDriver driver = context().driver();

    try {
      driver.findElement(By.linkText("Create new"));
      driver.findElement(By.linkText("Logout"));
      driver.findElement(By.linkText("Help"));

    }
    catch (final Exception e) {
      log.error("Main page was not present.");
      return false;
    }

    return true;
  }



  /**
   * @return
   */
  public WebElement menuLink() {
    return context().driver().findElement(By.id("createNewMenuLink"));
  }



  /**
   * @return
   */
  public WebElement newProductLink() {
    return context().driver().findElement(By.id("createNewProduct"));
  }



  /**
   * @return
   */
  public WebElement newProjectLink() {
    return context().driver().findElement(By.id("createNewProject"));
  }



  /**
   * @return
   */
  public WebElement newIterationLink() {
    return context().driver().findElement(By.id("createNewIteration"));
  }



  /**
   * @return
   */
  public WebElement newStoryLink() {
    return context().driver().findElement(By.id("createNewStory"));
  }



  /**
   * @return
   */
  private TestContext context() {
    return _testContext;
  }

} // end of class MainPage
