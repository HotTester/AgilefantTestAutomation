/**
 * 
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


import java.io.PrintStream;

import org.graphwalker.multipleModels.ModelHandler;
import org.openqa.selenium.WebDriver;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;




/**
 * @author Aleksi
 */
public final class TestContext {

  /**  */
  private PrintStream _outputStream;

  /**  */
  private WebDriver _driver;

  /**  */
  private ModelHandler _modelHandler;



  /**
   * @param s
   */
  public void println(final String s) {
    outputStream().println(s);
  }



  /**
   * @param exception
   */
  public void printException(final Exception exception) {
    if (exception == null) {
      throw CreateException.forNullArgument("exception"); //$NON-NLS-1$
    }

    exception.printStackTrace(outputStream());
  }



  /**
   * @return the _outputStream
   */
  public PrintStream outputStream() {
    if (_outputStream == null) {
      CreateException.forUnsetVariable("outputStream"); //$NON-NLS-1$
    }

    return _outputStream;
  }



  /**
   * @param outputStream
   *          the _outputStream to set
   */
  public void setOutputStream(final PrintStream outputStream) {
    _outputStream = outputStream;
  }




  /**
   * @return the driver
   */
  public final WebDriver driver() {
    if (_outputStream == null) {
      CreateException.forUnsetVariable("driver"); //$NON-NLS-1$
    }

    return _driver;
  }




  /**
   * @param driver
   *          the driver to set
   */
  public final void setDriver(final WebDriver driver) {
    _driver = driver;
  }




  /**
   * @return the modelHandler
   */
  public final ModelHandler modelHandler() {
    if (_outputStream == null) {
      CreateException.forUnsetVariable("modelHandler"); //$NON-NLS-1$
    }

    return _modelHandler;
  }




  /**
   * @param modelHandler
   *          the modelHandler to set
   */
  public final void setModelHandler(final ModelHandler modelHandler) {
    _modelHandler = modelHandler;
  }

} // end of class TestContext
