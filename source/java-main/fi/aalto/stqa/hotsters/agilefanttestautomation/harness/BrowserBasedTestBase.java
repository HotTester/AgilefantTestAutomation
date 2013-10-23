/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


import org.graphwalker.multipleModels.ModelHandler;
import org.openqa.selenium.WebDriver;

import org.junit.After;
import org.junit.Before;




/**
 * @author Aleksi
 */
public class BrowserBasedTestBase {

  /**  */
  private final BrowserDriverFactory _bdFactory = new BrowserDriverFactory();

  /**  */
  private WebDriver _driver;

  /**  */
  private ModelHandler _modelHandler;



  /**
   * 
   */
  @Before
  public final void initializeTestBase() {
    setDriver(_bdFactory.createFirefoxDriverInstance());
    setModelHandler(new ModelHandler());
  }



  /**
   * 
   */
  @After
  public final void tearDownTestBase() {
    driver().quit();
  }



  /**
   * @return the driver
   */
  public WebDriver driver() {
    return _driver;
  }



  /**
   * @param driver
   *          the driver to set
   */
  public void setDriver(final WebDriver driver) {
    _driver = driver;
  }



  /**
   * @return the modelHandler
   */
  public ModelHandler modelHandler() {
    return _modelHandler;
  }



  /**
   * @param modelHandler
   *          the modelHandler to set
   */
  public void setModelHandler(final ModelHandler modelHandler) {
    _modelHandler = modelHandler;
  }

} // end of class BrowserBasedTestBase
