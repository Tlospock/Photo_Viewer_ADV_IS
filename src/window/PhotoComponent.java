/**
 * 
 */
package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.annotation.Inherited;

import javax.swing.JComponent;

/**
 * @author paul.meunier
 *
 */
public class PhotoComponent extends JComponent {
	
	private ImagePhoto imageDisplayed;
	private boolean flipped;
	private Object annotation;
	private Dimension size;
	private Dimension preferedSize;
	
	public PhotoComponent() {
		this.setSize(640, 480);
		this.setPreferredSize(new Dimension(800, 600));
	}
	
	/**
	 * {@link Inherited}
	 */
	@Override
	public void paintComponent(Graphics G)
	{
		
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
}
