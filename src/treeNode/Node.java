/**
 * 
 */
package treeNode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tlos
 *
 */
public abstract class Node {
	
	protected Node parent;
	protected List<Node> childrens;
	
	private Color colorNode = new Color(0, 0, 0);
	private Font font = new Font("Arial", Font.PLAIN, 12);
	
	/**
	 * The bounds of the Node: the upper left coin of the rectangle is the starting point
	 */
	protected Rectangle2D bounds;
	
	protected boolean displayed;
	
	public Node(Node parentTemp)
	{
		this.parent = parentTemp;
		childrens = new ArrayList<>();
		bounds = new Rectangle(0, 0, 0, 0);
	}
	
	/**
	 * Add a node to the list of children of the current node
	 * @param childrenToAdd the node to add to the list
	 */
	public void addChildren(Node childrenToAdd)
	{
		if(childrenToAdd != null && !childrenToAdd.equals(this))
			childrens.add(childrenToAdd);
	}
	
	/**
	 * Draw all the children of a node
	 */
	public void drawChildren()
	{
		this.draw();
		for(Node n: childrens)
			n.draw();
	}
	
	/**
	 * Draw the node, relative to each type of node
	 */
	public abstract void draw();
	
	/**
	 * To remove a specific Node from the list of children
	 * @param children the node to remove
	 * @return a boolean which indicate if it has been removed or not
	 */
	public boolean removeChildren(Node children)
	{
		for(int i = 0; i < childrens.size(); ++i)
		{
			if(children.equals(childrens.get(i)))
			{
				childrens.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isDisplayed() {
		return displayed;
	}

	public void setDisplayed(boolean displayed) {
		this.displayed = displayed;
	}

	public Rectangle2D getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle2D bounds) {
		this.bounds = bounds;
	}
	
}
