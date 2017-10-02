/**
 * 
 */
package window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author paul.meunier
 *
 */
public class TextAnnotation implements Annotation{
	private String userAnnotation;
	private Point startPosition;
	private Font font = new Font("Arial", Font.PLAIN, 12);
	private Color color = new Color(1, 1, 1);
	
	/**
	 * Default constructor
	 */
	public TextAnnotation()
	{
		userAnnotation = new String();
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
	
	/**
	 * Draw the userAnnotation field with
	 * @param position the position of the click
	 * @param parent the JComponent parent
	 * @param g the graphics environment of the parent
	 */
	@Override
	public void drawAnnotation(Point position, PhotoComponent parent, Graphics g, double imageWidth, double imageHeight) {
		g.setColor(color);
		g.setFont(font);
		if(userAnnotation.length() == 0)
		{
			parent.getStatusBar().updateStatusBar("Nothing to write");
			return;
		}
		
		Point currentPosition = new Point(startPosition);
		
		for(int i = 0; i < userAnnotation.length(); ++i)
		{
			if(currentPosition == null)
			{
				parent.getStatusBar().updateStatusBar("Impossible to add text, you\'re at the end of the document!");
				break;
			}
			drawChar(userAnnotation.charAt(i), currentPosition, startPosition, parent, g);
			currentPosition = this.getNextCharPosition(userAnnotation.charAt(i), startPosition, currentPosition, imageWidth, imageHeight, g);
		}

	}
	
	public void drawChar(char toDraw, Point currentPosition, Point position, PhotoComponent parent, Graphics g)
	{
		g.setColor(color);
		g.setFont(font);
		
		if(currentPosition != null)
			g.drawString(String.valueOf(toDraw), (int)currentPosition.getX(), (int)currentPosition.getY());
		
	}
	
	/**
	 * @param c the character to write
	 * @param stringStartPosition the start position of the current string annotation
	 * @param cursorCurrentPosition the current position of the cursor
	 * @param parent the direct JComponent ancestor to retrieve the dimensions
	 * @param g the graphic context
	 * @return
	 */
	public Point getNextCharPosition(char c, Point stringStartPosition, Point cursorCurrentPosition, double imageWidth, double imageHeight, Graphics g)
	{
		int charSize = g.getFontMetrics().charWidth(c);
		if(cursorCurrentPosition.getX() + charSize >= imageWidth - charSize)
		{
			System.out.println("end of line");
			if(cursorCurrentPosition.getY() + g.getFontMetrics().getHeight() < imageHeight)
			{
				cursorCurrentPosition.setLocation(startPosition.getX(), cursorCurrentPosition.getY() + g.getFontMetrics().getAscent());
			}
			else
				return null;
		}
		else
		{
			cursorCurrentPosition.setLocation(cursorCurrentPosition.getX() + charSize, cursorCurrentPosition.getY());
		}
		
		return cursorCurrentPosition;
	}

	/**
	 * @return the userAnnotation
	 */
	public String getUserAnnotation() {
		return userAnnotation;
	}

	/**
	 * @param userAnnotation the userAnnotation to set
	 */
	public void setUserAnnotation(String userAnnotation) {
		this.userAnnotation = userAnnotation;
	}

	/**
	 * @return the startPosition
	 */
	public Point getStartPosition() {
		return startPosition;
	}

	/**
	 * @param startPosition the startPosition to set
	 */
	public void setStartPosition(Point startPosition) {
		this.startPosition = startPosition;
	}

	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public Color getColor() {
		return color;
	}
	
}
