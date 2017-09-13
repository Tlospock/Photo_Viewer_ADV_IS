package window;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MainWindow 
{
	// Constant
	public static String FILE_LABEL = "File";
	public static String IMPORT_LABEL = "Import";
	public static String DELETE_LABEL = "Delete";
	public static String QUIT_LABEL = "Quit";

	public static String VIEW_LABEL = "View";
	public static String PHOTO_VIEWER_LABEL = "Photo viewer (default)";
	public static String BROWSER_LABEL = "Browser";
	public static String SPLIT_MODE_LABEL = "Split mode";
	
	// Main window
	private JFrame window;
	
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
	private JRadioButtonMenuItem photoViewerMode;
	private JRadioButtonMenuItem browserViewerMode;
	private JRadioButtonMenuItem splitModeViewerMode;
	
	public static void main(String args[])
	{
		new MainWindow("Say hi");
	}
	
	public MainWindow(String title) 
	{
		// Repl
		window = new JFrame(title);
		// BorderLayout, getToolBar? getContentBar?
		window.getContentPane().setLayout(new FlowLayout());

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
		
		ButtonGroup viewMenuRadioButtonGroup = new ButtonGroup();
		
		photoViewerMode = new JRadioButtonMenuItem(PHOTO_VIEWER_LABEL);
		photoViewerMode.setSelected(true);
		
		browserViewerMode = new JRadioButtonMenuItem(BROWSER_LABEL);
		
		splitModeViewerMode = new JRadioButtonMenuItem(SPLIT_MODE_LABEL);
		
		viewMenu.add(viewMenu);
		
		window.add(menuBar);
		
		JButton sayHiButton = new JButton("Say hi button");
		JButton sayByeButton = new JButton("Say bye button");
		sayHiButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				sayHi();
			}
		});
		
		sayByeButton.addActionListener(
			event -> sayBye()
		);
		
		window.getContentPane().add(sayHiButton);
		window.getContentPane().add(sayByeButton);
		window.pack();
		window.setVisible(true);
	}
	
	public void updateStatusBar(String action)
	{
		
	}
	
	public void changeMode() {
		// TODO add arg + implements classes
	}
	
	public void importPicture()
	{
		updateStatusBar(IMPORT_LABEL);
	}
	
	public void deletePicture()
	{
		updateStatusBar(DELETE_LABEL);
	}
	
	public void quitSoftware() {
		updateStatusBar(QUIT_LABEL);
		// TODO quit software
	}
	
	public void sayHi() 
	{
		System.out.println("Hey");
	}
	
	public void sayBye() 
	{
		System.out.println("Baille");
	}
}