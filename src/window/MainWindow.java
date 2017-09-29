package window;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class MainWindow 
{
	// Main window
	private JFrame window;
	
	// Menu bar
	private MenuBar menuBar;
	
	// Status bar
	private StatusBar statusBar;
	
	// Toolbar
	private JToolBar toolbar;
	
	// Toolbar buttons
	private JButton toolbarButton1;
	private JButton toolbarButton2;
	private JButton toolbarButton3;
	
	// Panel to display the photo
	private JScrollPane scrollPaneContainer;
	private PhotoComponent photoComponent;
	
	public static void main(String args[])
	{
		new MainWindow("Say hi");
	}
	
	public MainWindow(String title) 
	{
		// Repl
		window = new JFrame(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// BorderLayout, getToolBar? getContentBar?
		window.getContentPane().setLayout(new BorderLayout());
		window.setSize(200, 200);
		window.setMinimumSize(new Dimension(200, 150));
		
		photoComponent = new PhotoComponent();
		statusBar = new StatusBar();
		menuBar = new MenuBar(statusBar, window, photoComponent);
		toolbar = createToolbar();
		
		// Setup of the main panel
		
		scrollPaneContainer = new JScrollPane(photoComponent);
		
		window.add(menuBar.getMenuBar(), BorderLayout.PAGE_START);
		window.add(statusBar.getStatusBar(), BorderLayout.PAGE_END);
		window.add(toolbar, BorderLayout.LINE_START);
		
		window.add(scrollPaneContainer, BorderLayout.CENTER);
		
		/*
		JButton sayHiButton = new JButton("Say hi button");
		sayHiButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				sayHi();
			}
		});
		*/
		
		window.pack();
		window.setVisible(true);
	}
	
	public JToolBar createToolbar()
	{
		toolbar = new JToolBar();
		toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.Y_AXIS));
		toolbarButton1 = new JButton("Button 1");
		toolbarButton1.addActionListener(event -> statusBar.updateStatusBar("Toolbar button 1"));
		
		toolbarButton2 = new JButton("Button 2");
		toolbarButton2.addActionListener(event -> statusBar.updateStatusBar("Toolbar button 2"));
		
		toolbarButton3 = new JButton("Button 3");
		toolbarButton3.addActionListener(event -> statusBar.updateStatusBar("Toolbar button 3"));
		
		toolbar.add(toolbarButton1);
		toolbar.add(toolbarButton2);
		toolbar.add(toolbarButton3);
		
		return toolbar;
	}
	
	public void sayHi() 
	{
		System.out.println("Hey");
	}
	
	public void sayBye() 
	{
		System.out.println("Baille");
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