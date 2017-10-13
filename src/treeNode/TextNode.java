/**
 * 
 */
package treeNode;

/**
 * @author Tlos
 *
 */
public class TextNode extends Node{

	private String toWrite;
	
	public TextNode(Node parentTemp) {
		super(parentTemp);
		toWrite = new String("");
	}

	@Override
	public void draw() {
		super.drawChildren();
		
		
	}

}
