/**
 * 
 */
package treeNode;

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
public class PathNode extends Node{

	private List<Point> strokes;
	private Color color = new Color(255, 0, 0);
	
	public PathNode(Node parentTemp)
	{
		super(parentTemp);
		strokes = new ArrayList<>();
	}

	@Override
	public void draw(Graphics g, JComponent panel) {
		Point previousPoint = new Point(strokes.get(0));
		g.setColor(color);
		
		for(int i = 1; i < strokes.size(); ++i)
		{
			g.drawLine((int)previousPoint.getX(), (int)previousPoint.getY(), (int)strokes.get(i).getX(), (int)strokes.get(i).getY());
			previousPoint = new Point(strokes.get(i));
		}
	}

}
