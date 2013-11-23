/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation;


import org.graphwalker.conditions.TimeDuration;
import org.graphwalker.generators.AllPathPermutationsGenerator;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;
import org.graphwalker.multipleModels.ModelHandler;

import org.junit.Test;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.BrowserBasedTestBase;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.BrowserDriverFactory;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel.AgilefantUIModel;




/**
 * Some smoke tests for Agilefant.
 * 
 * @author Aleksi
 */
public class Tests extends BrowserBasedTestBase {

  /**  */
  private static final String TEMPORARY_BROWSER_PROFILE_PATH = "C:\\Temp\\browser-profile\\"; //$NON-NLS-1$



  /**
   * 
   */
  @Test
  public void ensureProductsProjectsIterationsAndStoriesCanBeCreated() {
    final String modelName = "LoginLogoutModelHandler"; //$NON-NLS-1$
    final Class<? extends ModelAPI> modelHandler = LoginLogoutModelHandler.class;
    final String modelResourcePath = "/test-models/login-logout.graphml"; //$NON-NLS-1$
    final PathGenerator pathGenerator = new AllPathPermutationsGenerator(new TimeDuration(1800));

    initTestContextWithoutCreatingBrowser();
    initializeModel(modelName, modelHandler, modelResourcePath, pathGenerator);
    executeModel(modelName);
  }



  /**
   * 
   */
  private void initTestContextWithoutCreatingBrowser() {
    setContext(new TestContext());

    context().setOutputStream(System.out);

    final BrowserDriverFactory bdf = new BrowserDriverFactory();
    bdf.setTemporaryBrowserProfilePath(TEMPORARY_BROWSER_PROFILE_PATH);
    context().setBrowserDriverFactory(bdf);

    context().setModelHandler(new ModelHandler());
    context().setUIModel(new AgilefantUIModel(context()));
  }

} // end of class Tests
