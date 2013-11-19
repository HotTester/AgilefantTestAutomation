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

import org.junit.Test;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.InitializedBrowserBasedTestBase;




/**
 * Some smoke tests for Agilefant.
 * 
 * @author Aleksi
 */
public class UpgradedAgilefantDemo extends InitializedBrowserBasedTestBase {

  /**
   * 
   */
  @Test
  public void upgradedAgilefantDemo() {
    final String modelName = "CreateProductsModelHandler"; //$NON-NLS-1$
    final Class<? extends ModelAPI> modelHandler = CreateProductsModelHandler.class;
    final String modelResourcePath = "/test-models/agilefantdemo-create-products.graphml"; //$NON-NLS-1$
    final PathGenerator pathGenerator = new AllPathPermutationsGenerator(new TimeDuration(1500));

    initializeAndExecuteSingleModel(modelName, modelHandler, modelResourcePath, pathGenerator);
  }

} // end of class UpgradedAgilefantDemo
