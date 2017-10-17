/**
 * 
 */
package treeNode;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

import window.PhotoComponent;

/**
 * @author Tlos
 *
 */
public class TreeReference extends JComponent{
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	
	private RootNode rootNode;
	private Point upperLeftCorner;
	
	/**
	 * Constructor
	 * @param upperLeftTemp the absolute position of the upper left corner of the component
	 */
	public TreeReference(Point upperLeftTemp)
	{
		rootNode = new RootNode();
		this.upperLeftCorner = upperLeftTemp;
	}
	
	/**
	 * 
	 * @param lastCursorPosition
	 * @param g The graphics context
	 * @param panel The photocomponent in which is this
	 * @param imageWidth The width of the image, use not to go over the border while drawing annotation
	 * @param imageHeight The height of the image, use not to go over the border while drawing annotation
	 */
	public void drawAllNode(Point lastCursorPosition, Graphics g, PhotoComponent panel, int imageWidth, int imageHeight)
	{
		rootNode.draw(lastCursorPosition, g, panel, imageWidth, imageHeight);
		
	}

	/**
	 * @return the rootNode
	 */
	public RootNode getRootNode() {
		return rootNode;
	}

	/**
	 * @param rootNode the rootNode to set
	 */
	public void setRootNode(RootNode rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * @return the upperLeftCorner
	 */
	public Point getUpperLeftCorner() {
		return upperLeftCorner;
	}

	/**
	 * @param upperLeftCorner the upperLeftCorner to set
	 */
	public void setUpperLeftCorner(Point upperLeftCorner) {
		this.upperLeftCorner = upperLeftCorner;
	}
	
}
