/**
 * 
 */
package window;

import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JTextField;

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
	public JTextField drawAnnotation(Point position, JComponent parent) {
		JTextField inputField = new JTextField();
		
		return inputField;
	}
}
