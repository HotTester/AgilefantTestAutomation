
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
public class StoryCreationModelHandler extends ModelAPI {

  /**  */
  private final TestContext _testContext;
  /**  */

  private final AgilefantDataModel _dataModel = AgilefantDataModel.instance();

  /**  */
  private final Logger log = Util.setupLogger(StoryCreationModelHandler.class);



  /**
   * @param model
   * @param efsm
   * @param generator
   * @param weight
   * @param testContext
   */
  public StoryCreationModelHandler(
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
   * This method implements the Edge 'e_CreateNewStoryDialog_CancelButton_Click'
   */
  public void e_CreateNewStoryDialog_CancelButton_Click() {
	  log.info("Edge: e_CreateNewStoryDialog_CancelButton_Click");
	  context().uiModel().newStoryDialog().CancelButton().click();
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterInvalidProductBasedDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterInvalidProductBasedDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterInvalidProjectBasedDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterInvalidProjectBasedDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterInvalidProjectBasedIterationDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterInvalidProjectBasedIterationDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterInvalidStandAloneIterationDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterInvalidStandAloneIterationDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterProductBasedDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterProductBasedDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterProjectBasedDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterProjectBasedDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterProjectBasedIterationDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterProjectBasedIterationDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewStoryDialog_EnterStandaloneIterationDetailsAndSave'
   */
  public void e_CreateNewStoryDialog_EnterStandaloneIterationDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_Header_NewStoryLink_Click'
   */
  public void e_Header_NewStoryLink_Click() {
	  log.info("Edge: e_Header_NewStoryLink_Click");

	  // Click Create new --> Product
	  context().uiModel().mainPage().menuLink().click();
	  context().uiModel().mainPage().newStoryLink().click();
  }



  /**
   * This method implements the Edge 'e_NoOp'
   */
  public void e_NoOp() {
  }



  /**
   * This method implements the Edge 'noOp'
   */
  public void noOp() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewStoryDialog_Opened'
   */
  public void v_CreateNewStoryDialog_Opened() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewStoryDialog_VerifyInvalidProductBasedInputErrorMessage'
   */
  public void v_CreateNewStoryDialog_VerifyInvalidProductBasedInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewStoryDialog_VerifyInvalidProjectBasedInputErrorMessage'
   */
  public void v_CreateNewStoryDialog_VerifyInvalidProjectBasedInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewStoryDialog_VerifyInvalidProjectBasedInterationInputErrorMessage'
   */
  public void v_CreateNewStoryDialog_VerifyInvalidProjectBasedInterationInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewStoryDialog_VerifyInvalidStandaloneIterationInputErrorMessage'
   */
  public void v_CreateNewStoryDialog_VerifyInvalidStandaloneIterationInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProductBasedStoryCreation'
   */
  public void v_MainPage_VerifyProductBasedStoryCreation() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProjectBasedIterationStoryCreation'
   */
  public void v_MainPage_VerifyProjectBasedIterationStoryCreation() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProjectBasedStoryCreation'
   */
  public void v_MainPage_VerifyProjectBasedStoryCreation() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyStandaloneIterationStoryCreation'
   */
  public void v_MainPage_VerifyStandaloneIterationStoryCreation() {

  }



  /**
   * This method implements the Vertex 'v_NoOp'
   */
  public void v_NoOp() {

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
} // end of class StoryCreationModelHandler
