
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
public class ProjectCreationModelHandler extends ModelAPI {

  /**  */
  private final TestContext _testContext;
  /**  */

  private final AgilefantDataModel _dataModel = AgilefantDataModel.instance();

  /**  */
  private final Logger log = Util.setupLogger(ProjectCreationModelHandler.class);



  /**
   * @param model
   * @param efsm
   * @param generator
   * @param weight
   * @param testContext
   */
  public ProjectCreationModelHandler(
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
   * This method implements the Edge 'e_CreateNewProjectDialog_CancelButton_Click'
   */
  public void e_CreateNewProjectDialog_CancelButton_Click() {
  }



  /**
   * This method implements the Edge 'e_CreateNewProjectDialog_EnterDetailsAndSave'
   */
  public void e_CreateNewProjectDialog_EnterDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateNewProjectDialog_EnterInvalidInputDetailsAndSave'
   */
  public void e_CreateNewProjectDialog_EnterInvalidInputDetailsAndSave() {
  }



  /**
   * This method implements the Edge 'e_Header_NewProjectLink_Click'
   */
  public void e_Header_NewProjectLink_Click() {
  }



  /**
   * This method implements the Edge 'noOp'
   */
  public void noOp() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewProjectDialog_Opened'
   */
  public void v_CreateNewProjectDialog_Opened() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewProjectDialog_VerifyInvalidInputErrorMessage'
   */
  public void v_CreateNewProjectDialog_VerifyInvalidInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_CreateNewProjectDialog_VerifyUnknownProductErrorMessage'
   */
  public void v_CreateNewProjectDialog_VerifyUnknownProductErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProjectCreation'
   */
  public void v_MainPage_VerifyProjectCreation() {
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
} // end of class ProjectCreationModelHandler
