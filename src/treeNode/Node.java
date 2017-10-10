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
		//TODO manageBounds
		
		childrens.add(childrenToAdd);
	}
	
	public boolean isDisplayed() {
		return displayed;
	}

	public void setDisplayed(boolean displayed) {
		this.displayed = displayed;
	}
	
}
