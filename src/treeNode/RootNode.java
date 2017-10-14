/**
 * 
 */
package treeNode;

import java.awt.Graphics;
import java.awt.Point;

import window.PhotoComponent;

/**
 * @author Tlos
 *
 */
public class RootNode extends Node{
	
	public RootNode()
	{
		super(null);
		this.setBounds(null);
	}

	@Override
	public void draw(Point lastCursorPosition, Graphics g, PhotoComponent panel, int imageWidth, int imageHeight) {
		super.drawChildren(lastCursorPosition, g, panel, imageWidth, imageHeight);
	}
	
}