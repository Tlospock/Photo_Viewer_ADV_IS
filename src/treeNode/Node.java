/**
 * 
 */
package treeNode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import window.PhotoComponent;

/**
 * @author Tlos
 *
 */
public abstract class Node {
	
	protected Node parent;
	protected List<Node> childrens;
	
	protected Color colorNode = new Color(0, 0, 0);
	protected Font font = new Font("Arial", Font.PLAIN, 12);
	
	/**
	 * The bounds of the Node: the upper left coin of the rectangle is the starting point and 
	 * is the offset from the parent container
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
	public void drawChildren(Point lastCursorPosition, Graphics g, PhotoComponent panel, int imageWidth, int imageHeight)
	{
		for(Node n: childrens)
			n.draw(lastCursorPosition, g, panel, imageWidth, imageHeight);
	}
	
	/**
	 * Draw the node, relative to each type of node
	 */
	public abstract void draw(Point lastCursorPosition, Graphics g, PhotoComponent panel, int imageWidth, int imageHeight);

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
	
	public void translate(int xTranslation, int yTranslation)
	{
		this.setBounds(new Rectangle((int)this.getBounds().getX() + xTranslation, (int)this.getBounds().getY(), 
				(int)this.getBounds().getWidth(), (int)this.getBounds().getHeight() ));
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

	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * @return the childrens
	 */
	public List<Node> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens the childrens to set
	 */
	public void setChildrens(List<Node> childrens) {
		this.childrens = childrens;
	}

	/**
	 * @return the colorNode
	 */
	public Color getColorNode() {
		return colorNode;
	}

	/**
	 * @param colorNode the colorNode to set
	 */
	public void setColorNode(Color colorNode) {
		this.colorNode = colorNode;
	}

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}
	
}
