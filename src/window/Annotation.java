package window;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public interface Annotation {
	
	public void drawAnnotation(Point position, JComponent parent, Graphics g);
	
}
