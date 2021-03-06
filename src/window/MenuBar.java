/**
 * 
 */
package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import treeNode.ImageNode;

/**
 * @author A_Tlos
 *
 */
public class MenuBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3190204605148399655L;

	// Fenetre principale
	private JFrame window;
	
	// Constant
	public static String FILE_LABEL = "File";
	public static String IMPORT_LABEL = "Import";
	public static String DELETE_LABEL = "Delete";
	public static String QUIT_LABEL = "Quit";

	public static String VIEW_LABEL = "View";
	public static String PHOTO_VIEWER_LABEL = "Photo viewer (default)";
	public static String BROWSER_LABEL = "Browser";
	public static String SPLIT_MODE_LABEL = "Split mode";
	
	// The menu bar
	private JMenuBar menuBar;
	
	// Items on the menubar
	private JMenu fileMenu;
	private JMenu viewMenu;
	
	// fileMenu's items
	private JMenuItem importMenuItem;
	private JMenuItem deleteMenuItem;
	private JMenuItem quitMenuItem;
	
	// viewMenu's items
	private ButtonGroup viewMenuRadioButtonGroup;
	private JRadioButtonMenuItem photoViewerMode;
	private JRadioButtonMenuItem browserViewerMode;
	private JRadioButtonMenuItem splitModeViewerMode;
	
	// Reference to the statusBar
	private StatusBar statusBar;
	
	// Reference to the component which displays the photos
	private PhotoComponent photoComponent;
	
	/**
	 * Constructor
	 */
	public MenuBar()
	{
		// Create the menu bar
		menuBar = new JMenuBar();
		
		//Build the file menu
		fileMenu = new JMenu(FILE_LABEL);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		importMenuItem = new JMenuItem(IMPORT_LABEL, KeyEvent.VK_I);
		importMenuItem.getAccessibleContext().setAccessibleDescription("Import a picture");
		importMenuItem.addActionListener(event -> importPicture());
		
		deleteMenuItem = new JMenuItem(DELETE_LABEL, KeyEvent.VK_D);
		deleteMenuItem.getAccessibleContext().setAccessibleDescription("Delete a picture");
		deleteMenuItem.addActionListener(event -> deletePicture());
		
		quitMenuItem = new JMenuItem(QUIT_LABEL, KeyEvent.VK_Q);
		quitMenuItem.getAccessibleContext().setAccessibleDescription("Quit the software");
		quitMenuItem.addActionListener(event -> quitSoftware());
		
		fileMenu.add(importMenuItem);
		fileMenu.add(deleteMenuItem);
		fileMenu.add(quitMenuItem);
		menuBar.add(fileMenu);
		
		// Build the view menu
		viewMenu = new JMenu(VIEW_LABEL);
		
		viewMenuRadioButtonGroup = new ButtonGroup();
		
		photoViewerMode = new JRadioButtonMenuItem(PHOTO_VIEWER_LABEL);
		photoViewerMode.setSelected(true);
		photoViewerMode.addActionListener(event -> changeViewMode(PHOTO_VIEWER_LABEL));
		viewMenuRadioButtonGroup.add(photoViewerMode);
		
		browserViewerMode = new JRadioButtonMenuItem(BROWSER_LABEL);
		browserViewerMode.addActionListener(event -> changeViewMode(BROWSER_LABEL));
		viewMenuRadioButtonGroup.add(browserViewerMode);
		
		splitModeViewerMode = new JRadioButtonMenuItem(SPLIT_MODE_LABEL);
		splitModeViewerMode.addActionListener(event -> changeViewMode(SPLIT_MODE_LABEL));
		viewMenuRadioButtonGroup.add(splitModeViewerMode);
		
		//Add all part to view menu
		viewMenu.add(photoViewerMode);
		viewMenu.add(browserViewerMode);
		viewMenu.add(splitModeViewerMode);
		
		menuBar.add(viewMenu);
	}
	
	/**
	 * Specialized constructor
	 * @param statusBarTemp A reference to the status bar
	 * @param windowTemp A reference to the main window
	 * @param photoComponentTemp A reference to the component which will display the photo
	 */
	public MenuBar(StatusBar statusBarTemp, JFrame windowTemp, PhotoComponent photoComponentTemp)
	{
		this();
		setStatusBar(statusBarTemp);
		setWindow(windowTemp);
		setPhotoComponent(photoComponentTemp);
		
	}
	
	/**
	 * To import the picture from a file chooser, whith a custom filter for image
	 */
	public void importPicture()
	{
		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new ImageFilter());
		fc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fc.getSelectedFile() != null)
					photoComponent.setImageDisplayed(new ImageNode(fc.getSelectedFile().getAbsolutePath()));
			}
		});
		
		int filePath = fc.showDialog(importMenuItem, "Open or import image");
		if(fc.getSelectedFile() != null)
		{
			statusBar.updateStatusBar(IMPORT_LABEL + " " + fc.getSelectedFile().getAbsolutePath());
			photoComponent = new PhotoComponent();
			photoComponent.setStatusBar(getStatusBar());
		}
		else
			statusBar.updateStatusBar("Import aborted");
	}
	
	/**
	 * Delete the picture from the photo component
	 */
	public void deletePicture()
	{
		window.dispose();
		new MainWindow("Photo viewer");
		statusBar.updateStatusBar(DELETE_LABEL);
	}
	
	/**
	 * Quit and close the window
	 */
	public void quitSoftware() {
		statusBar.updateStatusBar(QUIT_LABEL);
		window.dispose();
	}
	
	/**
	 * Todo Change the view mode (not yet implemented)
	 * @param viewMode the view mode
	 */
	public void changeViewMode(String viewMode) {
		statusBar.updateStatusBar("Mode changed: " + viewMode);
	}

	/**
	 * @return the window
	 */
	public JFrame getWindow() {
		return window;
	}

	/**
	 * @param window the window to set
	 */
	public void setWindow(JFrame window) {
		this.window = window;
	}

	/**
	 * @return the menuBar
	 */
	public JMenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * @return the fileMenu
	 */
	public JMenu getFileMenu() {
		return fileMenu;
	}

	/**
	 * @param fileMenu the fileMenu to set
	 */
	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}

	/**
	 * @return the viewMenu
	 */
	public JMenu getViewMenu() {
		return viewMenu;
	}

	/**
	 * @param viewMenu the viewMenu to set
	 */
	public void setViewMenu(JMenu viewMenu) {
		this.viewMenu = viewMenu;
	}

	/**
	 * @return the importMenuItem
	 */
	public JMenuItem getImportMenuItem() {
		return importMenuItem;
	}

	/**
	 * @param importMenuItem the importMenuItem to set
	 */
	public void setImportMenuItem(JMenuItem importMenuItem) {
		this.importMenuItem = importMenuItem;
	}

	/**
	 * @return the deleteMenuItem
	 */
	public JMenuItem getDeleteMenuItem() {
		return deleteMenuItem;
	}

	/**
	 * @param deleteMenuItem the deleteMenuItem to set
	 */
	public void setDeleteMenuItem(JMenuItem deleteMenuItem) {
		this.deleteMenuItem = deleteMenuItem;
	}

	/**
	 * @return the quitMenuItem
	 */
	public JMenuItem getQuitMenuItem() {
		return quitMenuItem;
	}

	/**
	 * @param quitMenuItem the quitMenuItem to set
	 */
	public void setQuitMenuItem(JMenuItem quitMenuItem) {
		this.quitMenuItem = quitMenuItem;
	}

	/**
	 * @return the viewMenuRadioButtonGroup
	 */
	public ButtonGroup getViewMenuRadioButtonGroup() {
		return viewMenuRadioButtonGroup;
	}

	/**
	 * @param viewMenuRadioButtonGroup the viewMenuRadioButtonGroup to set
	 */
	public void setViewMenuRadioButtonGroup(ButtonGroup viewMenuRadioButtonGroup) {
		this.viewMenuRadioButtonGroup = viewMenuRadioButtonGroup;
	}

	/**
	 * @return the photoViewerMode
	 */
	public JRadioButtonMenuItem getPhotoViewerMode() {
		return photoViewerMode;
	}

	/**
	 * @param photoViewerMode the photoViewerMode to set
	 */
	public void setPhotoViewerMode(JRadioButtonMenuItem photoViewerMode) {
		this.photoViewerMode = photoViewerMode;
	}

	/**
	 * @return the browserViewerMode
	 */
	public JRadioButtonMenuItem getBrowserViewerMode() {
		return browserViewerMode;
	}

	/**
	 * @param browserViewerMode the browserViewerMode to set
	 */
	public void setBrowserViewerMode(JRadioButtonMenuItem browserViewerMode) {
		this.browserViewerMode = browserViewerMode;
	}

	/**
	 * @return the splitModeViewerMode
	 */
	public JRadioButtonMenuItem getSplitModeViewerMode() {
		return splitModeViewerMode;
	}

	/**
	 * @param splitModeViewerMode the splitModeViewerMode to set
	 */
	public void setSplitModeViewerMode(JRadioButtonMenuItem splitModeViewerMode) {
		this.splitModeViewerMode = splitModeViewerMode;
	}

	/**
	 * @return the statusBar
	 */
	public StatusBar getStatusBar() {
		return statusBar;
	}

	/**
	 * @param statusBar the statusBar to set
	 */
	public void setStatusBar(StatusBar statusBar) {
		this.statusBar = statusBar;
	}

	/**
	 * @return the photoComponent
	 */
	public PhotoComponent getPhotoComponent() {
		return photoComponent;
	}

	/**
	 * @param photoComponent the photoComponent to set
	 */
	public void setPhotoComponent(PhotoComponent photoComponent) {
		this.photoComponent = photoComponent;
	}
	
}
