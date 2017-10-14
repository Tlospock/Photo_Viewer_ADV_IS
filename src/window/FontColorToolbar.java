/**
 * 
 */
package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author A_Tlos
 *
 */
public class FontColorToolbar extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5641079792513827671L;
	public static String DEFAULT_FONT = "Arial";
	public static int DEFAULT_FONT_SIZE = 12;
	
	private PhotoComponent associatePhotoComponent;
	private JButton choosePathColor;
	private JButton chooseTextColor;
	private JComboBox<String> chooseFontType;
	private JTextField chooseFontSize;
	
	private String[] fontTab;
	
	private Font userFont;
	private Color textColor;
	private Color pathColor;
	
	public FontColorToolbar(PhotoComponent associatePhotoComponent)
	{
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		fontTab = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		userFont = new Font(FontColorToolbar.DEFAULT_FONT, Font.PLAIN, FontColorToolbar.DEFAULT_FONT_SIZE);
		textColor = new Color(0, 0, 0);
		pathColor = new Color(255, 0, 0);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		choosePathColor = new JButton("Path Color");
		choosePathColor.addActionListener(event -> associatePhotoComponent.setUserPathColor(JColorChooser.showDialog(this, "Choose a color for the pen", pathColor)));
		
		chooseTextColor = new JButton("Text color");
		chooseTextColor.addActionListener(event -> associatePhotoComponent.setUserTextColor(JColorChooser.showDialog(this, "Choose a color for the text", pathColor)));
		
		
		chooseFontType = new JComboBox<String>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		
		int indexDefaultFont = 0;
		for(String fontTemp : fontTab)
		{
			if(new String(FontColorToolbar.DEFAULT_FONT).equals(fontTemp))
				break;
			
			++indexDefaultFont;
		}
		chooseFontType.setSelectedIndex(indexDefaultFont);
		chooseFontType.addActionListener(event -> updatePhotoComponent());
		
		chooseFontSize = new JTextField(String.valueOf(FontColorToolbar.DEFAULT_FONT_SIZE));
		chooseFontSize.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				updatePhotoComponent();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// Empty
				
			}
		});
		
		this.add(choosePathColor);
		this.add(Box.createRigidArea(new Dimension(60,0)));
		this.add(new JLabel("Font type"));
		this.add(chooseFontType);
		this.add(Box.createRigidArea(new Dimension(30,0)));
		this.add(new JLabel("Font size"));
		this.add(chooseFontSize);
		this.add(Box.createRigidArea(new Dimension(30,0)));
		this.add(chooseTextColor);
		
		this.associatePhotoComponent = associatePhotoComponent;
	}
	
	public void updatePhotoComponent()
	{	
		System.out.println("Resetting Font to default size");
		try{
			userFont = new Font(fontTab[chooseFontType.getSelectedIndex()], Font.PLAIN, Integer.valueOf(chooseFontSize.getText()));
		} catch (NumberFormatException e) {
			chooseFontSize.setText(String.valueOf(FontColorToolbar.DEFAULT_FONT_SIZE));
			userFont = new Font(fontTab[chooseFontType.getSelectedIndex()], Font.PLAIN, FontColorToolbar.DEFAULT_FONT_SIZE);
		}
		
		
		associatePhotoComponent.setUserFont(userFont);
	}
	
}
