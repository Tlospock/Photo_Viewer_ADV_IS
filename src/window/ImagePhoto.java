/**
 * 
 */
package window;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * @author paul.meunier
 *
 */
public class ImagePhoto {
	
	private String path;
	private boolean hasFlipAnnotation;
	private BufferedImage photo;
	
	/**
	 * Empty constructor
	 */
	public ImagePhoto() {
		// VIDE
	}
	
	public ImagePhoto(String pathTemp) {
		path = pathTemp;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the hasFlipAnnotation
	 */
	public boolean isHasFlipAnnotation() {
		return hasFlipAnnotation;
	}

	/**
	 * @param hasFlipAnnotation the hasFlipAnnotation to set
	 */
	public void setHasFlipAnnotation(boolean hasFlipAnnotation) {
		this.hasFlipAnnotation = hasFlipAnnotation;
	}

	/**
	 * @return the photo
	 */
	public Image getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(BufferedImage photo) {
		this.photo = photo;
	}
	
	
}
