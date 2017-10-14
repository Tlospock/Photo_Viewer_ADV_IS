/**
 * 
 */
package treeNode;

import java.awt.Graphics;

import javax.swing.JComponent;

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
	public void draw(Graphics g, JComponent panel) {
		super.drawChildren(g, panel);
	}
	
}