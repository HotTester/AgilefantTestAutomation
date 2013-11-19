
package fi.aalto.stqa.hotsters.agilefanttestautomation;


/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 *
 * Group Exercise of Team Hotsters
 */


import java.io.File;

import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelAPI;
import org.openqa.selenium.WebDriver;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.datamodel.AgilefantDataModel;
import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;



/**
 * Remember to start the selenium server, before running the test:
 * java -jar lib/selenium-server.jar -singleWindow
 */
public class IterationCreationModelHandler extends ModelAPI {

  /**  */
  private final TestContext _testContext;
  /**  */

  private final AgilefantDataModel _dataModel = AgilefantDataModel.instance();

  /**  */
  private final Logger log = Util.setupLogger(IterationCreationModelHandler.class);



  /**
   * @param model
   * @param efsm
   * @param generator
   * @param weight
   * @param testContext
   */
  public IterationCreationModelHandler(
      final File model,
      final boolean efsm,
      final PathGenerator generator,
      final boolean weight,
      final TestContext testContext) {
    super(model, efsm, generator, weight);

    if (testContext == null) {
      throw CreateException.forNullArgument("testContext"); // \$NON-NLS-1\$
    }
    _testContext = testContext;
    log.info("Model handler created."); // \$NON-NLS-1\$
  }



  /**
   * This method implements the Vertex 'MainPage_Opened'
   */
  public void MainPage_Opened() {
  }



  /**
   * This method implements the Edge 'e_CreateNewIterationDialog_CancelButton_Click'
   */
  public void e_CreateNewIterationDialog_CancelButton_Click() {
	  log.info("Edge: e_CreateNewIterationDialog_CancelButton_Click");
	  context().uiModel().newIterationDialog().CancelButton().click();
	  
  }



  /**
   * This method implements the Edge 'e_CreateNewIterationDialog_EnterInvalidProjectBasedDetailsAndSave'
   */
  public void e_CreateNewIterationDialog_EnterInvalidProjectBasedDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewIterationDialog_EnterInvalidStandaloneDetailsAndSave'
   */
  public void e_CreateNewIterationDialog_EnterInvalidStandaloneDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewIterationDialog_EnterProjectBasedDetailsAndSave'
   */
  public void e_CreateNewIterationDialog_EnterProjectBasedDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewIterationDialog_EnterStandaloneDetailsAndSave'
   */
  public void e_CreateNewIterationDialog_EnterStandaloneDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_Header_NewIterationLink_Click'
   */
  public void e_Header_NewIterationLink_Click() {
	  log.info("Edge: e_Header_NewIterationLink_Click");

	  // Click Create new --> Product
	  context().uiModel().mainPage().menuLink().click();
	  context().uiModel().mainPage().newIterationLink().click();
  }



  /**
   * This method implements the Edge 'noOp'
   */
  public void noOp() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewIterationDialog_Opened'
   */
  public void v_CreateNewIterationDialog_Opened() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewIterationDialog_VerifyInvalidInputErrorMessage'
   */
  public void v_CreateNewIterationDialog_VerifyInvalidInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProjectBasedIterationCreation'
   */
  public void v_MainPage_VerifyProjectBasedIterationCreation() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyStandaloneIterationCreation'
   */
  public void v_MainPage_VerifyStandaloneIterationCreation() {
  }



  /**
   * @return
   */
  public WebDriver driver() {
    return context().driver();
  }



  /**
   * @return
   */
  public TestContext context() {
    return _testContext;
  }



  /**
   * @return the dataModel
   */
  public final AgilefantDataModel dataModel() {
    return _dataModel;
  }
} // end of class IterationCreationModelHandler
