/**
 * 
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel;


import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;



/**
 * @author Aleksi
 */
public class AgilefantUIModel {

  /**  */
  private final TestContext _testContext;

  /**  */
  private MainPage _mainPage;
  private LoginPage _loginPage;
  private NewProductDialog _newProductDialog;
  private NewProjectDialog _newProjectDialog;
  private NewIterationDialog _newIterationDialog;
  private NewStoryDialog _newStoryDialog;




  /**
   * @param testContext
   */
  public AgilefantUIModel(final TestContext testContext) {
    _testContext = testContext;
  }

  /**
   * @return the mainPage
   */
  public final MainPage mainPage() {
    if (_mainPage == null) {
    	_mainPage = new MainPage(context()); 
    }

    return _mainPage;
  }

  /**
   * @return the loginPage
   */
  public final LoginPage loginPage() {
    if (_loginPage == null) {
      _loginPage = new LoginPage(context());
    }

    return _loginPage;
  }
  
  /**
   * @return the newProductDialog
   */
  public final NewProductDialog newProductDialog() {
    if (_newProductDialog == null) {
    	_newProductDialog = new NewProductDialog(context());
    }

    return _newProductDialog;
  }
  
  /**
   * @return the newProjectDialog
   */
  public final NewProjectDialog newProjectDialog() {
    if (_newProjectDialog == null) {
    	_newProjectDialog = new NewProjectDialog(context());
    }

    return _newProjectDialog;
  }
  
  /**
   * @return the newIterationDialog
   */
  public final NewIterationDialog newIterationDialog() {
    if (_newIterationDialog == null) {
    	_newIterationDialog = new NewIterationDialog(context());
    }

    return _newIterationDialog;
  }
  
  /**
   * @return the newStoryDialog
   */
  public final NewStoryDialog newStoryDialog() {
    if (_newStoryDialog == null) {
    	_newStoryDialog = new NewStoryDialog(context());
    }

    return _newStoryDialog;
  }



  /**
   * @return the context
   */
  public final TestContext context() {
    return _testContext;
  }

} // end of class AgilefantUIModel
