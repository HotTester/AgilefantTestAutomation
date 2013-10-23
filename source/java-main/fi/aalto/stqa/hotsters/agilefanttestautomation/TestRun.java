
package fi.aalto.stqa.hotsters.agilefanttestautomation;


import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.graphwalker.conditions.TimeDuration;
import org.graphwalker.generators.AllPathPermutationsGenerator;
import org.graphwalker.multipleModels.ModelHandler;
import org.openqa.selenium.WebDriver;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.BrowserDriverFactory;



/**
 * @author Aleksi
 */
public class TestRun {


  /**
   * @param args
   */
  public static void main(final String[] args) {
    final BrowserDriverFactory bdFactory = new BrowserDriverFactory();
    final WebDriver driver = bdFactory.createFirefoxInstance();

    final URL url = TestRun.class.getResource("/test-models/agilefantdemo-create-products.graphml");
    File file = null;
    try {
      file = new File(url.toURI());
    }
    catch (final URISyntaxException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }



    final ModelHandler modelHandler = new ModelHandler();

    try {
      modelHandler.add(
          "CreateProducts",
          new CreateProducts(
              file,
              true,
              new AllPathPermutationsGenerator(new TimeDuration(1500)),
              false,
              driver));
    }
    catch (final Exception exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }

    try {
      modelHandler.execute("CreateProducts");
    }
    catch (final InterruptedException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }

    driver.quit();

    String actualResult = null;
    try {
      actualResult = modelHandler.getStatistics();
    }
    catch (final InterruptedException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }

    if (actualResult != null) {
      System.out.println(actualResult);
    }
  }
} // end of class TestRun
