/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.smoketests;


import java.io.File;

import org.graphwalker.conditions.TimeDuration;
import org.graphwalker.generators.AllPathPermutationsGenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.BrowserBasedTestBase;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.ResourceResolver;




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
    final String modelResource = "/test-models/agilefantdemo-create-products.graphml"; //$NON-NLS-1$
    final File modelFile = ResourceResolver.resolveBasedOn(modelResource);

    try {
      modelHandler().add(
          "CreateProducts",
          new CreateProducts(
              modelFile,
              true,
              new AllPathPermutationsGenerator(new TimeDuration(1500)),
              false,
              driver()));
    }
    catch (final Exception exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }

    try {
      modelHandler().execute("CreateProducts");
    }
    catch (final InterruptedException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }



    String actualResult = null;
    try {
      actualResult = modelHandler().getStatistics();
    }
    catch (final InterruptedException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }

    if (actualResult != null) {
      System.out.println(actualResult);
    }
  }

} // end of class BrowserBasedTestBase
