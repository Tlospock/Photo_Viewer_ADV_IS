package window;

import java.awt.Graphics;
import java.awt.Point;

public interface Annotation {
	
	public void drawAnnotation(Point position, PhotoComponent parent, Graphics g, double height, double width);
	
}
