/**
 * 
 */
package window;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author A_Tlos
 *
 */
public class StatusBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Status bar
	private JPanel statusBar;
	private JLabel lastAction;
	
	/**
	 * Constructor
	 */
	public StatusBar()
	{
		statusBar = new JPanel();
		statusBar.setLayout(new FlowLayout());
		
		lastAction = new JLabel("Ready to begin");
		statusBar.add(lastAction);
	}
	
	/**
	 * Set the text of the status bar
	 * @param action the text to display in the action bar
	 */
	public void updateStatusBar(String action)
	{
		lastAction.setText(action);
	}

	/**
	 * @return a reference to the statusBar
	 */
	public JPanel getStatusBar() {
		return statusBar;
	}

	/**
	 * @param statusBar the statusBar to set
	 */
	public void setStatusBar(JPanel statusBar) {
		this.statusBar = statusBar;
	}

	/**
	 * @return the lastAction
	 */
	public JLabel getLastAction() {
		return lastAction;
	}

	/**
	 * @param lastAction the lastAction to set
	 */
	public void setLastAction(JLabel lastAction) {
		this.lastAction = lastAction;
	}
}
