/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.agilefantdemo;


import org.graphwalker.conditions.TimeDuration;
import org.graphwalker.generators.AllPathPermutationsGenerator;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.BrowserBasedTestBase;




/**
 * Some smoke tests for Agilefant.
 * 
 * @author Aleksi
 */
public class AgilefantSmokeTests extends BrowserBasedTestBase {

  /**
   * 
   */
  @Before
  public void setUp() {
    // EMPTY
  }



  /**
   * 
   */
  @After
  public void tearDown() {
    // EMPTY
  }



  /**
   * 
   */
  @Test
  public void upgradedAgilefantDemo() {
    final String modelName = "CreateProducts"; //$NON-NLS-1$
    final Class<? extends ModelAPI> modelHandler = CreateProducts.class;
    final String modelResourcePath = "/test-models/agilefantdemo-create-products.graphml"; //$NON-NLS-1$
    final PathGenerator pathGenerator = new AllPathPermutationsGenerator(new TimeDuration(1500));

    initializeAndExecuteSingleModel(modelName, modelHandler, modelResourcePath, pathGenerator);
  }

} // end of class BrowserBasedTestBase
