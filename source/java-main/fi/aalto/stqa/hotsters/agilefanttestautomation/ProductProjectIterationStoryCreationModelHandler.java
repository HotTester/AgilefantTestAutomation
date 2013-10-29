/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation;


import java.io.File;

import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;
import org.openqa.selenium.WebDriver;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;




/**
 * Remember to start the selenium server, before running the test:
 * java -jar lib/selenium-server.jar -singleWindow
 */
public class ProductProjectIterationStoryCreationModelHandler extends ModelAPI {

  private final WebDriver driver;
  private final Logger log = Util.setupLogger(ProductProjectIterationStoryCreationModelHandler.class);
  private static String url = "http://localhost:8180/agilefant/";
  private final String username = "admin";
  private final String password = "secret";



  /**
   * @param model
   * @param efsm
   * @param generator
   * @param weight
   * @param webDriver
   */
  public ProductProjectIterationStoryCreationModelHandler(
      final File model,
      final boolean efsm,
      final PathGenerator generator,
      final boolean weight,
      final WebDriver webDriver) {

    super(model, efsm, generator, weight);

    if (webDriver == null) {
      throw CreateException.forNullArgument("webDriver"); //$NON-NLS-1$
    }
    driver = webDriver;
  }

} // end of class ProductProjectIterationStoryCreationModelHandler
