/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.datamodel;


import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;





/**
 * @author Aleksi
 */
public class Product {

  /**  */
  private final String _name;



  /**
   * Construct an instance of the <code>Product</code> class.
   */
  public Product(final String name) {
    if (name == null || name.trim().length() < 1) {
      throw CreateException.forNullOrEmptyStringArgument("name");
    }

    _name = name;
  }



  /**
   * @return name of this product
   */
  public final String name() {
    return _name;
  }



  @Override
  public String toString() {
    return name();
  }

} // end of class Product
