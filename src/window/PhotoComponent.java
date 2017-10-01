/**
 * 
 */
package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

/**
 * @author paul.meunier
 *
 */
public class PhotoComponent extends JComponent implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = -4254579137288641770L;
	
	public static double DOUBLE_CLICK_TIME_LIMIT = 300.0;
	
	private ImagePhoto imageDisplayed;
	private boolean flipped;
	private Object annotation;
	private Dimension preferedSize;
	private Point lastPressed;
	private double dateLastClick;
	private List<Annotation> annotationList;
	
	public PhotoComponent() {
		flipped = false;
		this.setSize(640, 480);
		this.setPreferredSize(new Dimension(0, 0));
		addMouseMotionListener(this);
		addMouseListener(this);
		lastPressed = new Point(0, 0);
		annotationList = new ArrayList<Annotation>();
	}
	
	/**
	 * {@link Inherited}
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if(imageDisplayed != null && !flipped)
		{
			g.drawImage(imageDisplayed.getPhoto(), this.getX(), this.getY(), this);
		} else if (imageDisplayed != null && flipped)
		{
			this.drawBackGround(g);
			this.drawAllAnnotation(g);
		}
	}
	
	/**
	 * Draw the background of the photo component
	 */
	public void drawBackGround(Graphics g) 
	{
		g.drawRect(this.getX(), this.getY(), imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null));
	}
	
	/**
	 * flip the photo component
	 * flipendo!
	 */
	public void flipPhotoComponent() {
		flipped = !flipped;
		this.revalidate();
		repaint();
	}

	/**
	 * @return the imageDisplayed
	 */
	public ImagePhoto getImageDisplayed() {
		return imageDisplayed;
	}

	/**
	 * @param imageDisplayed the imageDisplayed to set
	 */
	public void setImageDisplayed(ImagePhoto imageDisplayed) {
		this.imageDisplayed = imageDisplayed;
		if(imageDisplayed != null)
		{
			System.out.println(this.getX() + " | " + this.getY());
			System.out.println(imageDisplayed.getPhoto().getWidth(null) + " | " + imageDisplayed.getPhoto().getHeight(null));
			this.setPreferredSize(new Dimension(imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null)));
			this.revalidate();
			repaint();
		}
	}

	public void drawAllAnnotation(Graphics g)
	{
		// TODO
		for(Annotation a: annotationList)
		{
			a.drawAnnotation(lastPressed, this, g);
		}
	}
	
	/**
	 * @return the flipped
	 */
	public boolean isFlipped() {
		return flipped;
	}

	/**
	 * @param flipped the flipped to set
	 */
	public void setFlipped(boolean flipped) {
		this.flipped = flipped;
	}

	/**
	 * @return the annotation
	 */
	public Object getAnnotation() {
		return annotation;
	}

	/**
	 * @param annotation the annotation to set
	 */
	public void setAnnotation(Object annotation) {
		this.annotation = annotation;
	}

	/**
	 * @return the preferedSize
	 */
	public Dimension getPreferedSize() {
		return preferedSize;
	}

	/**
	 * @param preferedSize the preferedSize to set
	 */
	public void setPreferedSize(Dimension preferedSize) {
		this.preferedSize = preferedSize;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// EMPTY
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// EMPTY	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// EMPTY
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// EMPTY
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// EMPTY
	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastPressed.setLocation(e.getX(), e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(System.currentTimeMillis() - dateLastClick < DOUBLE_CLICK_TIME_LIMIT)
		{
			this.flipPhotoComponent();
		}
		else
		{
			
		}
		
		dateLastClick = System.currentTimeMillis();
	}
	
}
