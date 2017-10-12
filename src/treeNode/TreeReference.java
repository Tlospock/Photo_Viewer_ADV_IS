/**
 * 
 */
package treeNode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

/**
 * @author Tlos
 *
 */
public class TreeReference extends JComponent{
	
	private RootNode rootNode;
	private List<Node> nodeList;
	
	public TreeReference()
	{
		rootNode = new RootNode();
		nodeList = new ArrayList<Node>();
	}
	
}
