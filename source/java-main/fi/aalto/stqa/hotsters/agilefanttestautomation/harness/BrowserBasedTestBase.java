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
  private TestContext _context;



  /**
   * 
   */
  @Before
  public final void initializeTest() {
    initializeTestContext();
  }



  /**
   * 
   */
  private final void initializeTestContext() {
    setContext(new TestContext());

    context().setOutputStream(System.out);
    context().setDriver(_bdFactory.createFirefoxDriverInstance());
    context().setModelHandler(new ModelHandler());
  }



  /**
   * 
   */
  @After
  public final void finalizeTest() {
    printStatistics();

    driver().quit();
  }



  /**
   * 
   */
  public final void printStatistics() {
    String statistics = null;

    try {
      statistics = modelHandler().getStatistics();
    }
    catch (final InterruptedException ex) {
      throw new InternalException(ex);
    }

    if (statistics == null) {
      return;
    }

    context().println(statistics);
  }



  /**
   * @return the driver
   */
  public final WebDriver driver() {
    return context().driver();
  }



  /**
   * @return the modelHandler
   */
  public final ModelHandler modelHandler() {
    return context().modelHandler();
  }




  /**
   * @return the context
   */
  public final TestContext context() {
    return _context;
  }




  /**
   * @param context
   *          the context to set
   */
  public final void setContext(final TestContext context) {
    _context = context;
  }

} // end of class BrowserBasedTestBase
