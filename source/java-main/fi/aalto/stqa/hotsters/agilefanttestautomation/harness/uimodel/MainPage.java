package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel;

import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;

public class MainPage {

	  /**  */
	  private final TestContext _testContext;
	  private final Logger log = Util.setupLogger(MainPage.class);



	  /**
	   * @param testContext
	   */
	  public MainPage(final TestContext testContext) {
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
	  public boolean VerifyMainPagePresent() {
		  WebDriver driver = context().driver();
		  
		  try {
			  driver.findElement(By.linkText("Create new"));
			  driver.findElement(By.linkText("Logout"));
			  driver.findElement(By.linkText("Help"));
			  
		  } catch (final Exception e) {
		      log.error("Main page was not present.");
		      return false;
		  }	
		  return true;
	  }
	  
	  
	  public WebElement menuLink() {
		  return context().driver().findElement(By.id("createNewMenuLink"));
	  }
	  
	  public WebElement newProductLink() {
		  return context().driver().findElement(By.id("createNewProduct"));
	  }
	  
	  public WebElement newProjectLink() {
		  return context().driver().findElement(By.id("createNewProject"));
	  }
	  
	  public WebElement newIterationLink() {
		  return context().driver().findElement(By.id("createNewIteration"));
	  }
	  
	  public WebElement newStoryLink() {
		  return context().driver().findElement(By.id("createNewStory"));
	  }
	  

	
}
