/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


/**
 * @author Aleksi
 */
public final class InternalException extends RuntimeException {

  /** Serialization identifier. */
  private static final long serialVersionUID = 9052451534655356031L;



  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public InternalException(
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
  public InternalException(final String message, final Throwable cause) {
    super(message, cause);
  }



  /**
   * @param message
   */
  public InternalException(final String message) {
    super(message);
  }



  /**
   * @param cause
   */
  public InternalException(final Throwable cause) {
    super(cause);
  }

} // end of class InternalException
