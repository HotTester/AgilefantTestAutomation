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

import org.junit.Test;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.BrowserBasedTestBase;




/**
 * Some smoke tests for Agilefant.
 * 
 * @author Aleksi
 */
public class Tests extends BrowserBasedTestBase {

  /**
   * 
   */
  @Test
  public void ensureProductsProjectsIterationsAndStoriesCanBeCreated() {
    final String modelName = "ProductProjectIterationStoryCreationModelHandler"; //$NON-NLS-1$
    final Class<? extends ModelAPI> modelHandler = ProductProjectIterationStoryCreationModelHandler.class;
    final String modelResourcePath = "/test-models/product-project-iteration-story-creation.graphml"; //$NON-NLS-1$
    final PathGenerator pathGenerator = new AllPathPermutationsGenerator(new TimeDuration(1800));

    initializeAndExecuteSingleModel(modelName, modelHandler, modelResourcePath, pathGenerator);
  }

} // end of class Tests
