/**
 * 
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


/**
 * @author Aleksi
 */
public class ResourceNotFoundException extends RuntimeException {

  /** Serialization identifier. */
  private static final long serialVersionUID = 8898472913812888590L;



  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public ResourceNotFoundException(
      final String message,
      final Throwable cause,
      final boolean enableSuppression,
      final boolean writableStackTrace) {

    super(message, cause, enableSuppression, writableStackTrace);
  }



  /**
   * @param message
   * @param cause
   */
  public ResourceNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }



  /**
   * @param message
   */
  public ResourceNotFoundException(final String message) {
    super(message);
  }



  /**
   * @param cause
   */
  public ResourceNotFoundException(final Throwable cause) {
    super(cause);
  }

} // end of class ResourceNotFoundException
