/**
 * 
 */
package treeNode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import window.PhotoComponent;

/**
 * @author Tlos
 *
 */
public class PathNode extends Node{

	private List<Point> strokes;
	private Color color = new Color(255, 0, 0);
	
	public PathNode(Node parentTemp)
	{
		super(parentTemp);
		strokes = new ArrayList<>();
	}
	
	public void addPointToList(Point toAdd)
	{
		strokes.add(toAdd);
	}

	@Override
	public void draw(Point lastCursorPosition, Graphics g, PhotoComponent panel, int imageWidth, int imageHeight) {
		if(!displayed)
			return;
		
		Point previousPoint = new Point(strokes.get(0));
		g.setColor(colorNode);
		
		for(int i = 1; i < strokes.size(); ++i)
		{
			g.drawLine((int)previousPoint.getX(), (int)previousPoint.getY(), (int)strokes.get(i).getX(), (int)strokes.get(i).getY());
			previousPoint = new Point(strokes.get(i));
		}
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the strokes
	 */
	public List<Point> getStrokes() {
		return strokes;
	}
	
}
