/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions;


import java.net.URL;
import java.util.Locale;

import org.apache.commons.lang.NullArgumentException;




/**
 * @author Aleksi
 */
public class CreateException {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_NULL_OR_EMPTY_STRING_ARGUMENT = 
      "Argument \"%s\" cannot be empty string or contain only whitespace."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_RESOURCE_PATH_CANNOT_BE_RESOLVED = 
      "Requested resource path \"%s\" cannot be resolved."; //$NON-NLS-1$

  /**  */
  private static final String ERR_MSG_UNSET_VARIABLE = 
      "Variable \"%s\" is not set."; //$NON-NLS-1$
// @formatter:on



  /**
   * @param messageFormat
   * @param args
   * @return
   */
  public static final IllegalArgumentException forIllegalArgument(
      final String messageFormat,
      final Object... args) {

    return new IllegalArgumentException(String.format(
        Locale.ROOT, messageFormat, args));
  }



  /**
   * @param reason
   * @param messageFormat
   * @param args
   * @return
   */
  public static final IllegalArgumentException forIllegalArgument(
      final Throwable reason,
      final String messageFormat,
      final Object... args) {

    return new IllegalArgumentException(
        String.format(Locale.ROOT, messageFormat, args),
        reason);
  }



  /**
   * @param messageFormat
   * @param args
   * @return
   */
  public static final IllegalStateException forIllegalState(
      final String messageFormat,
      final Object... args) {

    return new IllegalStateException(String.format(
        Locale.ROOT, messageFormat, args));
  }



  /**
   * @param reason
   * @param messageFormat
   * @param args
   * @return
   */
  public static final IllegalStateException forIllegalState(
      final Throwable reason,
      final String messageFormat,
      final Object... args) {

    return new IllegalStateException(
        String.format(Locale.ROOT, messageFormat, args),
        reason);
  }



  /**
   * @param messageFormat
   * @param args
   * @return
   */
  public static final InternalException forInternalException(
      final String messageFormat,
      final Object... args) {

    return new InternalException(String.format(
        Locale.ROOT, messageFormat, args));
  }



  /**
   * @param reason
   * @return
   */
  public static final InternalException forInternalException(
      final Throwable reason) {

    return new InternalException(reason);
  }



  /**
   * @param reason
   * @param messageFormat
   * @param args
   * @return
   */
  public static final InternalException forInternalException(
      final Throwable reason,
      final String messageFormat,
      final Object... args) {

    return new InternalException(
        String.format(Locale.ROOT, messageFormat, args),
        reason);
  }



  /**
   * @param target
   * @param messageFormat
   * @param args
   * @return
   */
  public static final InvocationFailedException forExceptionThrownByInvocationTarget(
      final Throwable target,
      final String messageFormat,
      final Object... args) {

    return new InvocationFailedException(
        String.format(Locale.ROOT, messageFormat, args),
        target);
  }



  /**
   * @param cause
   * @param messageFormat
   * @param args
   * @return
   */
  public static final RuntimeException forIoError(
      final Throwable cause,
      final String messageFormat,
      final Object... args) {

    return new RuntimeException(
        String.format(Locale.ROOT, messageFormat, args),
        cause);
  }



  /**
   * @param resourceLocation
   * @return
   */
  public static final ResourceNotFoundException forMissingResource(final URL resourceLocation) {
    return CreateException.forMissingResource(resourceLocation.toString());
  }



  /**
   * @param resourceLocation
   * @return
   */
  public static final ResourceNotFoundException forMissingResource(final String resourceLocation) {
    return new ResourceNotFoundException(String.format(
        Locale.ROOT,
        ERR_MSG_RESOURCE_PATH_CANNOT_BE_RESOLVED,
        resourceLocation));
  }



  /**
   * @param argumentName
   * @return
   */
  public static final IllegalArgumentException forNullArgument(final String argumentName) {
    return new NullArgumentException(argumentName);
  }



  /**
   * @param argumentName
   * @return
   */
  public static final IllegalArgumentException forNullOrEmptyStringArgument(
      final String argumentName) {

    return new IllegalArgumentException(String.format(
        Locale.ROOT,
        ERR_MSG_NULL_OR_EMPTY_STRING_ARGUMENT,
        argumentName));
  }



  /**
   * @param variableName
   * @return
   */
  public static final IllegalStateException forUnsetVariable(
      final String variableName) {

    return CreateException.forIllegalState(
        ERR_MSG_UNSET_VARIABLE, variableName);
  }

} // end of class CreateException
