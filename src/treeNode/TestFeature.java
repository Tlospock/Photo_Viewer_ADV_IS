/**
 * 
 */
package treeNode;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author A_Tlos
 *
 */
public class TestFeature {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// BorderLayout, getToolBar? getContentBar?
		window.getContentPane().setLayout(new FlowLayout());
		window.setMinimumSize(new Dimension(200, 150));
		window.setSize(800, 800);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		TreeReference tree = new TreeReference(new Point((int) panel2.getX(), (int)panel2.getY()));
		
		window.pack();
		window.setVisible(true);
	}

}
