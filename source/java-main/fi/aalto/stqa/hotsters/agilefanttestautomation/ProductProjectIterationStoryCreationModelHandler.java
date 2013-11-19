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

    log.info("Model handler initialized.");
  }



  public void e_LoginPage_Open() {
    log.info("Opening login page...");
    getMbt().passRequirement(true);
  }



  public void v_LoginPage_Opened() {
    log.info("Verifying presence of the login page.");
    getMbt().passRequirement(true);
  }



  /**
   * This method implements the Edge 'e_CreateNewIterationDialog_CancelButton_Click'
   */
  public void e_CreateNewIterationDialog_CancelButton_Click() {
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
   * This method implements the Edge 'e_CreateNewStoryDialog_CancelButton_Click'
   */
  public void e_CreateNewStoryDialog_CancelButton_Click() {
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
   * This method implements the Edge 'e_CreateProductDialog_CancelButton_Click'
   */
  public void e_CreateProductDialog_CancelButton_Click() {
  }



  /**
   * This method implements the Edge 'e_CreateProductDialog_EnterInvalidProductInformationAndSave'
   */
  public void e_CreateProductDialog_EnterInvalidProductInformationAndSave() {
  }



  /**
   * This method implements the Edge 'e_CreateProductDialog_EnterProductInformationAndSave'
   */
  public void e_CreateProductDialog_EnterProductInformationAndSave() {
  }



  /**
   * This method implements the Edge 'e_Header_CreateNewProductLink_Click'
   */
  public void e_Header_CreateNewProductLink_Click() {
  }



  /**
   * This method implements the Edge 'e_Header_LogoutLink_Click'
   */
  public void e_Header_LogoutLink_Click() {
  }



  /**
   * This method implements the Edge 'e_Header_NewIterationLink_Click'
   */
  public void e_Header_NewIterationLink_Click() {
  }



  /**
   * This method implements the Edge 'e_Header_NewProjectLink_Click'
   */
  public void e_Header_NewProjectLink_Click() {
  }



  /**
   * This method implements the Edge 'e_Header_NewStoryLink_Click'
   */
  public void e_Header_NewStoryLink_Click() {
  }



  /**
   * This method implements the Edge 'e_LoginPage_EnterUserCredentials'
   */
  public void e_LoginPage_EnterUserCredentials() {
  }



  /**
   * This method implements the Edge 'e_NoOp'
   */
  public void e_NoOp() {
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
   * This method implements the Vertex 'v_CreateNewIterationDialog_VerifyInvalidStandaloneIterationInputErrorMessage'
   */
  public void v_CreateNewIterationDialog_VerifyInvalidStandaloneIterationInputErrorMessage() {
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
   * This method implements the Vertex 'v_CreateProductDialog_Opened'
   */
  public void v_CreateProductDialog_Opened() {
  }



  /**
   * This method implements the Vertex 'v_CreateProductDialog_VerifyInvalidInputErrorMessage'
   */
  public void v_CreateProductDialog_VerifyInvalidInputErrorMessage() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_Opened'
   */
  public void v_MainPage_Opened() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProductBasedStoryCreation'
   */
  public void v_MainPage_VerifyProductBasedStoryCreation() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProductCreation'
   */
  public void v_MainPage_VerifyProductCreation() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyProjectBasedIterationCreation'
   */
  public void v_MainPage_VerifyProjectBasedIterationCreation() {
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
   * This method implements the Vertex 'v_MainPage_VerifyProjectCreation'
   */
  public void v_MainPage_VerifyProjectCreation() {
  }



  /**
   * This method implements the Vertex 'v_MainPage_VerifyStandaloneIterationCreation'
   */
  public void v_MainPage_VerifyStandaloneIterationCreation() {
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

} // end of class ProductProjectIterationStoryCreationModelHandler
