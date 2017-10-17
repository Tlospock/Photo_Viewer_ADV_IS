/**
 * 
 */
package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

/**
 * @author Tlos
 *
 */
public class StrokeAnnotation extends JComponent implements Annotation{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Point> strokes;
	private Color color = new Color(255, 0, 0);
	
	/**
	 * Default constructor
	 */
	public StrokeAnnotation()
	{
		strokes = new ArrayList<Point>();
	}
	
	/**
	 * Constructor
	 * @param startPointTemp First point of the annotation
	 */
	public StrokeAnnotation(Point startPointTemp)
	{
		strokes = new ArrayList<Point>();
		strokes.add(new Point(startPointTemp));
	}
	
	/**
	 * To add a point to a stroke
	 * @param pointToAdd the point to add
	 */
	public void addPointToStroke(Point pointToAdd)
	{
		strokes.add(pointToAdd);
	}

	/**
	 * @return the strokes
	 */
	public List<Point> getStrokes() {
		return strokes;
	}

	/**
	 * @param strokes the strokes to set
	 */
	public void setStrokes(List<Point> strokes) {
		this.strokes = strokes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void drawAnnotation(Point position, PhotoComponent parent, Graphics g, double height, double width) {
		Point previousPoint = new Point(strokes.get(0));
		g.setColor(color);
		
		for(int i = 1; i < strokes.size(); ++i)
		{
			g.drawLine((int)previousPoint.getX(), (int)previousPoint.getY(), (int)strokes.get(i).getX(), (int)strokes.get(i).getY());
			previousPoint = new Point(strokes.get(i));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return color;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setColor(Color colorTemp) {
		color = colorTemp;
		
	}
	
}
