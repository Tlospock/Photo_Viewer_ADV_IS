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
	private Dimension preferedSize;
	
	public PhotoComponent() {
		flipped = true;
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
		if(imageDisplayed != null && flipped)
		{
			System.out.println("pouet");
			g.drawImage(imageDisplayed.getPhoto(), this.getX(), this.getY(), this);
		}
	}
	
	/**
	 * Draw the background of the photo component
	 */
	public void drawBackGround() 
	{
		// TODO
	}
	
	/**
	 * Used to redraw the annotation side
	 */
	public void redrawAnnotationSide()
	{
		// TODO
	}
	
	/**
	 * Used to redraw the photo side
	 */
	public void redrawPhotoSide()
	{
		// TODO
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
		if(imageDisplayed != null)
		{
			System.out.println(this.getX() + " | " + this.getY());
			System.out.println(imageDisplayed.getPhoto().getWidth(null) + " | " + imageDisplayed.getPhoto().getHeight(null));
			this.setPreferredSize(new Dimension(imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null)));
			this.revalidate();
			repaint();
		}
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
