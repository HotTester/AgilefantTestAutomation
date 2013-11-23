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
    try {
      createNewMenuLink();
      logoutLinkInHeader();
      helpLinkInHeader();
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
  public WebElement helpLinkInHeader() {
    return findElementByXPath("//div[@id='headerWrapper']/div[@id='logoutDiv']/a[text()='Help']");
  }



  /**
   * @return
   */
  public WebElement logoutLinkInHeader() {
    return findElementByXPath("//div[@id='headerWrapper']/div[@id='logoutDiv']/a[text()='Logout']");
  }



  /**
   * @return
   */
  public WebElement createNewMenuLink() {
    return findElementById("createNewMenuLink");
  }



  /**
   * @return
   */
  public WebElement createNewProductLink() {
    return findElementByXPath("//ul[@id='createNewMenu']//a[@id='createNewProduct'");
  }



  /**
   * @return
   */
  public WebElement createNewProjectLink() {
    return findElementByXPath("//ul[@id='createNewMenu']//a[@id='createNewProject'");
  }



  /**
   * @return
   */
  public WebElement createNewIterationLink() {
    return findElementByXPath("//ul[@id='createNewMenu']//a[@id='createNewIteration'");
  }



  /**
   * @return
   */
  public WebElement createNewStoryLink() {
    return findElementByXPath("//ul[@id='createNewMenu']//a[@id='createNewStory'");
  }



  /**
   * @param id
   * @return
   */
  private WebElement findElementById(final String id) {
    return context().driver().findElement(By.id(id));
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

} // end of class MainPage
