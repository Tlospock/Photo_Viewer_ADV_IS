/**
 * 
 */
package window;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * @author A_Tlos
 *
 */
public class MainWindow {

    private JFrame window;
    
    public static void main(String args[])
    {
            new MainWindow("Say hi");
    }
    
    public MainWindow(String title) 
    {
            window = new JFrame(title);
            // BorderLayout, getToolBar? getContentBar?
            window.getContentPane().setLayout(new FlowLayout());

            JButton sayHiButton = new JButton("Say hi button");
            JButton sayByeButton = new JButton("Say bye button");
            sayHiButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
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
    
    public void constructMenuBar() {
    	JMenuBar menuBar = new JMenuBar();
    	JMenu menu = new JMenu("menu");
    	
    }
    
    public void refresh() {
    	
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
