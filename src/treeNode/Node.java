/**
 * 
 */
package treeNode;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tlos
 *
 */
public abstract class Node {
	
	private Node parent;
	private List<Node> childrens;
	private Rectangle2D bounds;
	
	private boolean displayed;
	
	public Node(Node parentTemp)
	{
		this.parent = parentTemp;
		childrens = new ArrayList<>();
		bounds = new Rectangle(0, 0, 0, 0);
	}
	
	public void addChildren(Node childrenToAdd)
	{
		// TODO calculate bounds
		
		childrens.add(childrenToAdd);
	}
	
	public void drawChildren()
	{
		this.draw();
		for(Node n: childrens)
			n.draw();
	}
	
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
