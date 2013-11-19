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
  private LoginPage _loginPage;




  /**
   * @param testContext
   */
  public AgilefantUIModel(final TestContext testContext) {
    _testContext = testContext;
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
   * @return the context
   */
  public final TestContext context() {
    return _testContext;
  }

} // end of class AgilefantUIModel
