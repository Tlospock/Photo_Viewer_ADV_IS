/**
 * 
 */
package window;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author paul.meunier
 *
 */
public class ImageFilter extends FileFilter {

	private final static String description = "Just images...";
	
	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) 
	{
		if (f.isDirectory())
		{
			// TODO add management of file opening
			return true;
		}
		
		String extension = ExtensionUtils.getExtension(f);
		if(extension != null)
		{
			if (extension.equals(ExtensionUtils.tiff) ||
	            extension.equals(ExtensionUtils.tif) ||
	            extension.equals(ExtensionUtils.gif) ||
	            extension.equals(ExtensionUtils.jpeg) ||
	            extension.equals(ExtensionUtils.jpg) ||
	            extension.equals(ExtensionUtils.png)) {
	                return true;
	        } else {
	            return false;
	        }
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription()
	{
		return description;
	}

}
