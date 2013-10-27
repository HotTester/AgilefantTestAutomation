/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;
import org.graphwalker.multipleModels.ModelHandler;
import org.openqa.selenium.WebDriver;

import org.junit.After;
import org.junit.Before;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;




/**
 * @author Aleksi
 */
public class BrowserBasedTestBase {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_EXCEPTION_THROWN_BY_MODELHANDLER_CONSTRUCTOR =
      "The constructor of the provided model handler class, \"%s\", throw an exception."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_ILLEGAL_ARGUMENTS_FOR_MODELHANDLER_CONSTRUCTOR =
      "The constructor of the provided model handler class, \"%s\", got illegal arguments."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_MISSING_MODELHANDLER_CONSTRUCTOR = 
      "The provided model handler class, \"%s\", does not contain the required " +  //$NON-NLS-1$
          "ctor(File, Boolean, PathGenerator, Boolean, WebDriver)."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_MODELHANDLER_CONSTRUCTOR_NOT_ACCESSIBLE =
      "The required ctor(File, Boolean, PathGenerator, Boolean, WebDriver) of the provided " +  //$NON-NLS-1$
      "model handler class, \"%s\", is not accessible."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_MODELHANDLER_IS_ABSTRACT =
      "The provided model handler class, \"%s\", is abstract and thus cannot be instantiated."; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private static final Boolean EXTENDED_STATE_MACHINE = Boolean.TRUE;

  /**  */
  private static final Boolean WEIGHTED_EDGES = Boolean.TRUE;

  /**  */
  private BrowserDriverFactory _bdFactory;

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
    setBrowserDriverFactory(new BrowserDriverFactory());
    setContext(new TestContext());

    context().setOutputStream(System.out);
    context().setDriver(bdFactory().createFirefoxDriverInstance());
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
   * @param modelName
   * @param modelHandlerClass
   * @param modelResourcePath
   * @param pathGenerator
   */
  public final void initializeAndExecuteSingleModel(
      final String modelName,
      final Class<? extends ModelAPI> modelHandlerClass,
      final String modelResourcePath,
      final PathGenerator pathGenerator) {

    initializeModel(
        modelName,
        modelHandlerClass,
        modelResourcePath,
        pathGenerator);

    executeModel(modelName);
  }



  /**
   * @param modelName
   * @param modelHandlerClass
   * @param modelResourcePath
   * @param pathGenerator
   */
  public final void initializeModel(
      final String modelName,
      final Class<? extends ModelAPI> modelHandlerClass,
      final String modelResourcePath,
      final PathGenerator pathGenerator) {

    final String paramModelName = "modelName"; //$NON-NLS-1$

    if (modelName == null) {
      throw CreateException.forNullArgument(paramModelName);
    }
    if (modelName.trim().length() < 1) {
      throw CreateException.forNullOrEmptyStringArgument(paramModelName);
    }

    final ModelAPI modelHandler =
        createModelHandler(
            modelHandlerClass,
            modelResourcePath,
            pathGenerator);

    modelHandler().add(modelName, modelHandler);
  }



  /**
   * @param modelHandlerClass
   * @return
   */
  private final ModelAPI createModelHandler(
      final Class<? extends ModelAPI> modelHandlerClass,
      final String modelResourcePath,
      final PathGenerator pathGenerator) {

    if (modelHandlerClass == null) {
      throw CreateException.forNullArgument("modelHandlerClass"); //$NON-NLS-1$
    }

    if (pathGenerator == null) {
      throw CreateException.forNullArgument("pathGenerator"); //$NON-NLS-1$
    }

    final File modelFile = ResourceResolver.resolveBasedOn(modelResourcePath);

    final Constructor<? extends ModelAPI> modelHandlerConstructor =
        resolveModelHandlerConstructor(modelHandlerClass);

    final ModelAPI modelHandler =
        instantiateModelHandler(
            pathGenerator,
            modelHandlerConstructor,
            modelFile);

    return modelHandler;
  }



  /**
   * @param modelHandlerClass
   * @return
   */
  private static Constructor<? extends ModelAPI> resolveModelHandlerConstructor(
      final Class<? extends ModelAPI> modelHandlerClass) {

    Constructor<? extends ModelAPI> modelHandlerConstructor = null;

    try {
      modelHandlerConstructor = modelHandlerClass.getConstructor(new Class<?>[] {
            File.class,
            Boolean.TYPE,
            PathGenerator.class,
            Boolean.TYPE,
            WebDriver.class
      });
    }
    catch (final NoSuchMethodException exMissingConstructor) {
      throw CreateException.forIllegalArgument(
          exMissingConstructor,
          ERR_MSG_MISSING_MODELHANDLER_CONSTRUCTOR,
          modelHandlerClass.getName());
    }
    catch (final SecurityException exConstuctorIsNotAccessible) {
      throw CreateException.forIllegalArgument(
          exConstuctorIsNotAccessible,
          ERR_MSG_MODELHANDLER_CONSTRUCTOR_NOT_ACCESSIBLE,
          modelHandlerClass.getName());
    }

    return modelHandlerConstructor;
  }



  /**
   * @param pathGenerator
   * @param modelHandlerConstructor
   * @param modelFile
   */
  private ModelAPI instantiateModelHandler(
      final PathGenerator pathGenerator,
      final Constructor<? extends ModelAPI> modelHandlerConstructor,
      final File modelFile) {

    ModelAPI modelHandler = null;

    try {
      modelHandler = modelHandlerConstructor.newInstance(
          modelFile,
          EXTENDED_STATE_MACHINE,
          pathGenerator,
          WEIGHTED_EDGES,
          driver());
    }
    catch (final InstantiationException exAbstractClass) {
      throw CreateException.forIllegalArgument(
          exAbstractClass,
          ERR_MSG_MODELHANDLER_IS_ABSTRACT,
          modelHandlerConstructor.getDeclaringClass());
    }
    catch (final IllegalAccessException exConstuctorIsNotAccessible) {
      throw CreateException.forIllegalArgument(
          exConstuctorIsNotAccessible,
          ERR_MSG_MODELHANDLER_CONSTRUCTOR_NOT_ACCESSIBLE,
          modelHandlerConstructor.getDeclaringClass());
    }
    catch (final IllegalArgumentException exInvalidConstructorArguments) {
      throw CreateException.forInternalException(
          CreateException.forIllegalArgument(
              exInvalidConstructorArguments,
              ERR_MSG_ILLEGAL_ARGUMENTS_FOR_MODELHANDLER_CONSTRUCTOR,
              modelHandlerConstructor.getDeclaringClass()));
    }
    catch (final InvocationTargetException exInvocationTargetEException) {
      throw CreateException.forExceptionThrownByInvocationTarget(
          exInvocationTargetEException.getCause(),
          ERR_MSG_EXCEPTION_THROWN_BY_MODELHANDLER_CONSTRUCTOR,
          modelHandlerConstructor.getDeclaringClass());
    }

    return modelHandler;
  }



  /**
   * @param modelName
   */
  public final void executeModel(final String modelName) {
    final String paramModelName = "modelName"; //$NON-NLS-1$

    if (modelName == null) {
      throw CreateException.forNullArgument(paramModelName);
    }
    if (modelName.trim().length() < 1) {
      throw CreateException.forNullOrEmptyStringArgument(paramModelName);
    }

    try {
      modelHandler().execute(modelName);
    }
    catch (final InterruptedException ex) {
      context().printException(ex);
    }
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
      throw CreateException.forInternalException(ex);
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



  /**
   * @return
   */
  private final BrowserDriverFactory bdFactory() {
    return _bdFactory;
  }



  /**
   * @param bdFactory
   *          the bdFactory to set
   */
  public final void setBrowserDriverFactory(final BrowserDriverFactory bdFactory) {
    _bdFactory = bdFactory;
  }

} // end of class BrowserBasedTestBase
