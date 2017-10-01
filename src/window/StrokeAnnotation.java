/**
 * 
 */
package window;

import java.awt.Point;

import javax.swing.JComponent;

/**
 * @author Tlos
 *
 */
public class StrokeAnnotation extends JComponent implements Annotation{
	Point startPoint;
	
	public StrokeAnnotation()
	{
		startPoint = new Point(0, 0);
	}
	
	public StrokeAnnotation(Point startPointTemp)
	{
		startPoint = new Point(startPointTemp);
	}

	@Override
	public JComponent drawAnnotation(Point position, JComponent parent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
