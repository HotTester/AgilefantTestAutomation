/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions;


/**
 * @author Aleksi
 */
public final class InvocationFailedException extends RuntimeException {

  /** Serialization identifier. */
  private static final long serialVersionUID = -1654188845467569840L;



  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public InvocationFailedException(
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
  public InvocationFailedException(final String message, final Throwable cause) {
    super(message, cause);
  }



  /**
   * @param message
   */
  public InvocationFailedException(final String message) {
    super(message);
  }



  /**
   * @param cause
   */
  public InvocationFailedException(final Throwable cause) {
    super(cause);
  }

} // end of class ResourceNotFoundException
