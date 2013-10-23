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
import java.util.Locale;




/**
 * @author Aleksi
 */
public final class ResourceResolver {

  // @formatter:off
  /**  */
  private static final String ERR_MSG_RESOURCE_PATH_CANNOT_BE_RESOLVED = 
      "Requested resource path \"%s\" cannot be resolved."; //$NON-NLS-1$
 
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
  public static File resolveBasedOn(final String path) {
    final String rawPath = resolveAbsolutePath(path);
    final String decodedPath = decodeURLPath(rawPath);
    final File result = new File(decodedPath);

    return result;
  }



  /**
   * @param path
   * @return
   */
  private static String resolveAbsolutePath(final String path) {
    final URL resourceLocation = ResourceResolver.class.getResource(path);
    if (resourceLocation == null) {
      throw new ResourceNotFoundException(String.format(
          Locale.ROOT, ERR_MSG_RESOURCE_PATH_CANNOT_BE_RESOLVED, resourceLocation));
    }

    final String resourcePath = resourceLocation.getPath();
    if (resourcePath == null) {
      throw new ResourceNotFoundException(String.format(
          Locale.ROOT, ERR_MSG_RESOURCE_PATH_CANNOT_BE_RESOLVED, resourceLocation));
    }

    return resourcePath;
  }



  /**
   * @param resourcePath
   * @return
   */
  private static String decodeURLPath(final String resourcePath) {
    String profilePath = null;

    try {
      profilePath = URLDecoder.decode(resourcePath, CHARACTER_ENCODING_UTF8);
    }
    catch (final UnsupportedEncodingException ex) {
      throw new InternalException(ERR_MSG_UNKNOWN_CHARACTER_ENCODING_IDENTIFIER, ex);
    }

    return profilePath;
  }

} // end class ResourceResolver
