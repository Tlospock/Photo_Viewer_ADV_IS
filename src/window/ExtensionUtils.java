/**
 * 
 */
package window;

import java.io.File;

/**
 * @author paul.meunier
 *
 */
public class ExtensionUtils {
	
	// The list of extension for images
	public final static String png = "png";
	public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    

    /*
     * Get the extension of a file.
     */  
    public static String getExtension(File file) {
        String extension = null;
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');

        if (i > 0 &&  i < fileName.length() - 1) {
            extension = fileName.substring(i+1).toLowerCase();
        }
        return extension;
    }
}
