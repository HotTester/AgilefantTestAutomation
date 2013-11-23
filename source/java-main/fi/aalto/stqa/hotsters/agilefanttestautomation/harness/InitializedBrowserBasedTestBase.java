/**
 * 
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


import org.graphwalker.multipleModels.ModelHandler;

import org.junit.Before;



/**
 * @author Aleksi
 */
public class InitializedBrowserBasedTestBase extends BrowserBasedTestBase {

  /**
   * 
   */
  @Before
  public final void initializeTest() {
    setContext(new TestContext());

    context().setOutputStream(System.out);
    context().setBrowserDriverFactory(new BrowserDriverFactory());
    context().setDriver(context().browserDriverFactory().createFirefoxDriverInstanceWithCleanProfile());
    context().setModelHandler(new ModelHandler());
  }

} // end of class InitializedBrowserBasedTestBase
