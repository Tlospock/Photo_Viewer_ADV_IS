/**
 * 
 */
package treeNode;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

/**
 * @author Tlos
 *
 */
public class TreeReference extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RootNode rootNode;
	private Point upperLeftCorner;
	
	public TreeReference(Point upperLeftTemp)
	{
		rootNode = new RootNode();
		this.upperLeftCorner = upperLeftTemp;
	}
	
	public void drawAllNode(Graphics g)
	{
		rootNode.draw(getGraphics(), this);
		
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
