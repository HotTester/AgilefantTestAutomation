/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.datamodel;


import java.util.Collection;
import java.util.Random;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.graphwalker.Util;




/**
 * @author Aleksi
 */
public class AgilefantDataModel {

  /**  */
  private static final int MAX_PRODUCTS = 5;

  /**  */
  private static final int MAX_PROJECTS_PER_PRODUCT = 10;

  /**  */
  private static final int MAX_ITERATIONS_PER_PROJECT = 10;

  /**  */
  private static final int MAX_STANDALONE_ITERATIONS = 30;

  /**  */
  private static final int MAX_STORIES_PER_PRODUCT = 10;

  /**  */
  private static final int MAX_STORIES_PER_PROJECT = 30;

  /**  */
  private static final int MAX_STORIES_PER_ITERATION = 100;

  // @formatter:off
  /**  */
  private static final String AGILEFANT_ADMIN_USERNAME =
      "admin"; //$NON-NLS-1$

  /**  */
  private static final String AGILEFANT_ADMIN_DEFAULT_PASSWORD = 
      "secret"; //$NON-NLS-1$

  /**  */
  private static final String AGILEFANT_BASE_URL =
      "http://localhost:8180/agilefant/"; //$NON-NLS-1$

  /**  */
  private static final String MSG_DATAMODEL_INITIALIZATION_COMPLETED = 
      "Agilefant Data Model has been initialized."; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private static AgilefantDataModel _instance;

  /**  */
  private final Logger _logger = Util.setupLogger(AgilefantDataModel.class);

  /**  */
  private final Random _randomizer = new java.util.Random();

  /**  */
  private final Collection<Product> _products = new Vector<>(MAX_PRODUCTS);



  // num_of_products=0; num_of_current_product=0; num_of_stories_in_product=new int [MAX_PRODUCTS];
  // num_of_projects_in_product=new int [MAX_PRODUCTS]; num_of_stories_in_project=new int
  // [MAX_PRODUCTS][MAX_PROJECTS_PER_PRODUCT]; num_of_projectbased_iterations=new int
  // [MAX_PRODUCTS][MAX_PROJECTS_PER_PRODUCT]; num_of_stories_in_projectbased_iteration=new int
  // [MAX_PRODUCTS][MAX_PROJECTS_PER_PRODUCT][MAX_ITERATIONS_PER_PROJECT]; num_of_stories_in_standalone_iteration=new
  // int [MAX_STANDALONE_ITERATIONS]; num_of_standalone_iterations=0; num_of_current_project=0;
  // num_of_current_iteration=0;



  /**
   * Returns the instance of this singleton class.
   * 
   * @return the <code>AgilefantDataModel</code> instance
   */
  public static AgilefantDataModel instance() {
    if (_instance == null) {
      _instance = new AgilefantDataModel();
    }

    return _instance;
  }



  /**
   * Construct an instance of the <code>AgilefantDataModel</code> class.
   * As a singleton, the instance of this class must be gotten via the
   * static <code>instance()</code> method.
   */
  private AgilefantDataModel() {


    logger().info(MSG_DATAMODEL_INITIALIZATION_COMPLETED);
  }



  /**
   * @return
   */
  @SuppressWarnings("static-method")
  public String agilefantBaseUrl() {
    return AGILEFANT_BASE_URL;
  }



  /**
   * @return
   */
  @SuppressWarnings("static-method")
  public String agilefantAdminUsername() {
    return AGILEFANT_ADMIN_USERNAME;
  }



  /**
   * @return
   */
  @SuppressWarnings("static-method")
  public String agilefantAdminPassword() {
    return AGILEFANT_ADMIN_DEFAULT_PASSWORD;
  }



  /**
   * @return
   */
  public boolean isProjectPresent() {
    return false;
  }



  /**
   * @return
   */
  public boolean isProjectBasedIterationPresent() {
    return false;
  }



  /**
   * @return
   */
  public boolean isStandaloneIterationPresent() {
    return false;
  }



  /**
   * @return the logger
   */
  public final Logger logger() {
    return _logger;
  }



  /**
   * @return the products
   */
  public final Collection<Product> products() {
    return _products;
  }



  /**
   * @return
   */
  public boolean productCanBeCreated() {
    return products().size() < MAX_PRODUCTS;
  }



  /**
   * @return
   */
  public Product createProduct() {
    final Product newProduct = new Product("Tuote X");

    products().add(newProduct);
    logger().info("A new product is created: " + newProduct.toString());

    return newProduct;
  }



  /**
   * @return
   */
  public boolean productIsPresent() {
    return products().size() > 0;
  }



  /**
   * @return the randomizer
   */
  public final Random randomizer() {
    return _randomizer;
  }

} // end of class AgilefantDataModel
