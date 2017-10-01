package window;

import java.awt.Point;

import javax.swing.JComponent;

public interface Annotation {
	
	public JComponent drawAnnotation(Point position, JComponent parent);
	
}
