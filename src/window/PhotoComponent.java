/**
 * 
 */
package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Inherited;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * @author paul.meunier
 *
 */
public class PhotoComponent extends JComponent {
	
	private static final long serialVersionUID = -4254579137288641770L;
	private ImagePhoto imageDisplayed;
	private boolean flipped;
	private Object annotation;
	private Dimension size;
	private Dimension preferedSize;
	
	public PhotoComponent() {
		this.setSize(640, 480);
		this.setPreferredSize(new Dimension(0, 0));
		
	}
	
	/**
	 * {@link Inherited}
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.drawBackGround();
		if(imageDisplayed != null)
		{
			try {
				imageDisplayed.setPhoto(ImageIO.read(new File(imageDisplayed.getPath())));
				g.drawImage(imageDisplayed.getPhoto(), 0, 0, this);
			} catch (IOException e) {
				System.out.println("Image non trouvée");
			}
		}
	}
	
	/**
	 * Draw the background of the photo component
	 */
	public void drawBackGround() 
	{
		
	}
	
	/**
	 * Used to redraw the annotation side
	 */
	public void redrawAnnotationSide()
	{
		
	}
	
	/**
	 * Used to redraw the photo side
	 */
	public void redrawPhotoSide()
	{
		
	}

	/**
	 * @return the imageDisplayed
	 */
	public ImagePhoto getImageDisplayed() {
		return imageDisplayed;
	}

	/**
	 * @param imageDisplayed the imageDisplayed to set
	 */
	public void setImageDisplayed(ImagePhoto imageDisplayed) {
		this.imageDisplayed = imageDisplayed;
		repaint();
	}

	/**
	 * @return the flipped
	 */
	public boolean isFlipped() {
		return flipped;
	}

	/**
	 * @param flipped the flipped to set
	 */
	public void setFlipped(boolean flipped) {
		this.flipped = flipped;
	}

	/**
	 * @return the annotation
	 */
	public Object getAnnotation() {
		return annotation;
	}

	/**
	 * @param annotation the annotation to set
	 */
	public void setAnnotation(Object annotation) {
		this.annotation = annotation;
	}

	/**
	 * @return the size
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Dimension size) {
		this.size = size;
	}

	/**
	 * @return the preferedSize
	 */
	public Dimension getPreferedSize() {
		return preferedSize;
	}

	/**
	 * @param preferedSize the preferedSize to set
	 */
	public void setPreferedSize(Dimension preferedSize) {
		this.preferedSize = preferedSize;
	}
	
}
