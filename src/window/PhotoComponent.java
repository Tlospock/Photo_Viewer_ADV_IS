/**
 * 
 */
package window;

import java.awt.Dimension;
import java.awt.Graphics;

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
	
	@Override
	public void paintComponent(Graphics G)
	{
		// TODO Set size and preferred size
	}
}
