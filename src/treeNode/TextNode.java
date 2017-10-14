/**
 * 
 */
package treeNode;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import window.PhotoComponent;

/**
 * @author Tlos
 *
 */
public class TextNode extends Node{

	private String toWrite;
	
	public TextNode(Point lastCursorPosition, Node parentTemp, String textTemp) {
		super(parentTemp);
		toWrite = new String(textTemp);
		this.setBounds(new Rectangle((int)lastCursorPosition.getX(), (int)lastCursorPosition.getY(), 1, 1));
	}

	@Override
	public void draw(Point lastCursorPosition, Graphics g, PhotoComponent panel, int imageWidth, int imageHeight) {
		super.drawChildren(lastCursorPosition, g, panel, imageWidth, imageHeight);
		
		this.drawAnnotation(lastCursorPosition, panel, g, (double)imageWidth, (double)imageHeight);
	}

	/**
	 * Draw the userAnnotation field with
	 * @param position the position of the click
	 * @param parent the JComponent parent
	 * @param g the graphics environment of the parent
	 */
	public void drawAnnotation(Point position, PhotoComponent parent, Graphics g, double imageWidth, double imageHeight) {
		g.setColor(colorNode);
		g.setFont(font);
		if(toWrite.length() == 0)
		{
			parent.getStatusBar().updateStatusBar("Nothing to write");
			return;
		}
		
		Point currentPosition = new Point();
		currentPosition.setLocation(this.getBounds().getX(), this.getBounds().getY());
		
		for(int i = 0; i < toWrite.length(); ++i)
		{
			if(currentPosition == null)
			{
				parent.getStatusBar().updateStatusBar("Impossible to add text, you\'re at the end of the document!");
				break;
			}
			drawChar(toWrite.charAt(i), currentPosition, new Point((int)this.getBounds().getX(), (int)this.getBounds().getY()), parent, g);
			currentPosition = this.getNextCharPosition(toWrite.charAt(i), new Point((int)this.getBounds().getX(), (int)this.getBounds().getY()), currentPosition, imageWidth, imageHeight, g);
		}

	}
	
	/**
	 * Draw the char at the good position
	 * @param toDraw
	 * @param currentPosition
	 * @param position
	 * @param parent
	 * @param g
	 */
	public void drawChar(char toDraw, Point currentPosition, Point position, PhotoComponent parent, Graphics g)
	{
		g.setColor(colorNode);
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
			if(cursorCurrentPosition.getY() + g.getFontMetrics().getHeight() < imageHeight)
			{
				cursorCurrentPosition.setLocation(this.getBounds().getX(), cursorCurrentPosition.getY() + g.getFontMetrics().getAscent());
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
	 * @return the toWrite
	 */
	public String getToWrite() {
		return toWrite;
	}

	/**
	 * @param toWrite the toWrite to set
	 */
	public void setToWrite(String toWrite) {
		this.toWrite = toWrite;
	}
	
}
