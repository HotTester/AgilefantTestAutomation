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
  private final LoginPage _loginPage;




  /**
   * @param testContext
   */
  public AgilefantUIModel(final TestContext testContext) {
    _testContext = testContext;

    _loginPage = new LoginPage(context());
  }



  /**
   * @return the loginPage
   */
  public final LoginPage loginPage() {
    return _loginPage;
  }



  /**
   * @return the context
   */
  public final TestContext context() {
    return _testContext;
  }

} // end of class AgilefantUIModel
