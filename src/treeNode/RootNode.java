/**
 * 
 */
package treeNode;

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
	public void draw() {
		super.drawChildren();
	}

	
}