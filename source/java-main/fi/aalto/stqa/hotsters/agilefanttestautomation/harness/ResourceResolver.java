/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.harness;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import fi.aalto.stqa.hotsters.agilefanttestautomation.harness.exceptions.CreateException;




/**
 * @author Aleksi
 */
public final class ResourceResolver {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_UNKNOWN_CHARACTER_ENCODING_IDENTIFIER = 
      "Internal error: Unknown character encoding identifier."; //$NON-NLS-1$
  // @formatter:on

  /**  */
  private static final String CHARACTER_ENCODING_UTF8 = "UTF-8"; //$NON-NLS-1$



  /**
   * @param path
   * @return
   */
  public static final File resolveBasedOn(final String path) {
    final String rawPath = resolveAbsolutePath(path);
    final String decodedPath = decodeURLPath(rawPath);
    final File result = new File(decodedPath);

    return result;
  }



  /**
   * @param resourcePath
   * @return
   */
  private static final String resolveAbsolutePath(final String resourcePath) {
    final String paramPath = "path"; //$NON-NLS-1$

    if (resourcePath == null) {
      throw CreateException.forNullArgument(paramPath);
    }
    if (resourcePath.trim().length() < 1) {
      throw CreateException.forNullOrEmptyStringArgument(paramPath);
    }

    final URL resourceLocation = ResourceResolver.class.getResource(resourcePath);
    if (resourceLocation == null) {
      throw CreateException.forMissingResource(resourceLocation);
    }

    final String absoluteResourcePath = resourceLocation.getPath();
    if (absoluteResourcePath == null) {
      throw CreateException.forMissingResource(resourceLocation);
    }

    return absoluteResourcePath;
  }



  /**
   * @param resourcePath
   * @return
   */
  private static final String decodeURLPath(final String resourcePath) {
    String profilePath = null;

    try {
      profilePath = URLDecoder.decode(resourcePath, CHARACTER_ENCODING_UTF8);
    }
    catch (final UnsupportedEncodingException exception) {
      throw CreateException.forInternalException(
          exception, ERR_MSG_UNKNOWN_CHARACTER_ENCODING_IDENTIFIER);
    }

    return profilePath;
  }

} // end class ResourceResolver
