/**
 * 
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.uimodel;


import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.TestContext;




/**
 * @author Aleksi
 */
public class AgilefantUIModel {

  // @formatter:off
  /**  */
  public static final String XPATH_MOST_RECENT_DIALOG = 
      "(//div[contains(@class, 'ui-dialog') and not(contains(@class, 'ui-dialog-'))])[last()]"; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private final TestContext _testContext;

  /**  */
  private MainPage _mainPage;

  /**  */
  private LoginPage _loginPage;

  /**  */
  private CreateProductDialog _newProductDialog;

  /**  */
  private CreateProjectDialog _newProjectDialog;

  /**  */
  private CreateIterationDialog _newIterationDialog;

  /**  */
  private CreateStoryDialog _newStoryDialog;




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
  public final CreateProductDialog createProductDialog() {
    if (_newProductDialog == null) {
      _newProductDialog = new CreateProductDialog(context());
    }

    return _newProductDialog;
  }



  /**
   * @return the newProjectDialog
   */
  public final CreateProjectDialog newProjectDialog() {
    if (_newProjectDialog == null) {
      _newProjectDialog = new CreateProjectDialog(context());
    }

    return _newProjectDialog;
  }



  /**
   * @return the newIterationDialog
   */
  public final CreateIterationDialog newIterationDialog() {
    if (_newIterationDialog == null) {
      _newIterationDialog = new CreateIterationDialog(context());
    }

    return _newIterationDialog;
  }



  /**
   * @return the newStoryDialog
   */
  public final CreateStoryDialog newStoryDialog() {
    if (_newStoryDialog == null) {
      _newStoryDialog = new CreateStoryDialog(context());
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
