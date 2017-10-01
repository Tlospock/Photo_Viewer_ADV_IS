/**
 * 
 */
package window;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		try {
			this.setPhoto(ImageIO.read(new File(pathTemp)));
			System.out.println(pathTemp);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
