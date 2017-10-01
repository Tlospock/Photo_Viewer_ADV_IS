/**
 * 
 */
package window;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

/**
 * @author paul.meunier
 *
 */
public class TextAnnotation implements Annotation{
	private String userAnnotation;
	private Point startPosition;
	
	/**
	 * Default constructor
	 */
	public TextAnnotation()
	{
		userAnnotation = new String("");
		startPosition = new Point(0, 0);
	}
	
	/**
	 * Constructor with parameter
	 * @param annotationTemp the text to draw
	 * @param
	 */
	public TextAnnotation(String annotationTemp, Point startPositionTemp)
	{
		userAnnotation = new String(annotationTemp);
		startPosition = new Point(startPositionTemp);
	}

	@Override
	public void drawAnnotation(Point position, JComponent parent, Graphics g) {
		
		
	}
}
