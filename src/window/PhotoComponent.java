/**
 * 
 */
package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 * @author paul.meunier
 *
 */
public class PhotoComponent extends JComponent implements MouseListener, MouseMotionListener, KeyListener{
	
	private static final long serialVersionUID = -4254579137288641770L;
	
	public static double DOUBLE_CLICK_TIME_LIMIT = 300.0;
	/** MAX_DISTANCE_BETWEEN_PRESS_AND_RELEASE_FOR_SINGLE_CLICK */
	public static int MAX_DISTANCE_SINGLE_CLICK = 10;
	/** smallest distance from the right ledge where you can type */
	public static int SMALLEST_DISTANCE_LEDGE = 20;
	/** The maximum edge of the animation */
	public static int ANIMATION_MAXIMUM_EDGE = 100;
	
	
	private ImagePhoto imageDisplayed;
	private boolean flipped;
	private Object annotation;
	private Dimension preferedSize;
	private Point lastCursorPosition;
	private double dateLastClick;
	private List<Annotation> annotationList;
	private StatusBar statusBar;
	private TextAnnotation currentTextAnnotation = null;
	private StrokeAnnotation currentStrokeAnnotation = null;
	private Timer timer;
	private int currentAngle;
	private Image animationImage;
	private boolean middleAnimationEdgeReached = false;
	
	/** Indicate the status of the current text annotation, 0 for no entry point, 
	 * 1 for entry point and no key typed, 2 for entry point and at least 1 key typed
	 */
	private int typingState = 0;
	
	public PhotoComponent() {
		flipped = false;
		this.setPreferredSize(new Dimension(800, 600));
		this.setSize(new Dimension(0, 0));
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		lastCursorPosition = new Point(0, 0);
		dateLastClick = System.currentTimeMillis();
		annotationList = new ArrayList<Annotation>();
		timer = new Timer(5, event -> this.flipPhotoComponent());
		currentAngle = PhotoComponent.ANIMATION_MAXIMUM_EDGE;
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
			double w = getImageDisplayed().getPhoto().getWidth(null);
			double h = getImageDisplayed().getPhoto().getHeight(null)*((double)currentAngle/(double)PhotoComponent.ANIMATION_MAXIMUM_EDGE);
			animationImage = new BufferedImage((int)w, (int)h, BufferedImage.TYPE_INT_ARGB);
			
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.scale(1, (double)currentAngle/(double)PhotoComponent.ANIMATION_MAXIMUM_EDGE);
			AffineTransformOp scaleOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
			animationImage = scaleOp.filter((BufferedImage)getImageDisplayed().getPhoto(), (BufferedImage)animationImage);
			
			g.drawImage(animationImage, this.getX(), this.getY(), this);
		}
		else if (imageDisplayed != null && flipped)
		{
			this.drawBackGround(g);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.setColor(new Color(0, 0, 0));
			this.drawAllAnnotation(g);
			System.out.println("RED: " + g.getColor().getRed());
		}
	}
	
	/**
	 * Draw the background of the photo component
	 */
	public void drawBackGround(Graphics g) 
	{
		// White
		g.setColor(new Color(255, 255, 255));
		g.fillRect(this.getX(), this.getY(), imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null)*(currentAngle/PhotoComponent.ANIMATION_MAXIMUM_EDGE));
		g.setClip(this.getX(), this.getY(), imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null)*(currentAngle/PhotoComponent.ANIMATION_MAXIMUM_EDGE));
		g.drawRect(this.getX(), this.getY(), imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null)*(currentAngle/PhotoComponent.ANIMATION_MAXIMUM_EDGE));
	}
	
	/**
	 * flip the photo component
	 * flipendo!
	 */
	public void flipPhotoComponent() {
		if(currentAngle <= 1 && !middleAnimationEdgeReached)
		{
			middleAnimationEdgeReached = true;
			flipped = !flipped;
		}
		else if (currentAngle >= PhotoComponent.ANIMATION_MAXIMUM_EDGE && middleAnimationEdgeReached)
		{
			timer.stop();
			middleAnimationEdgeReached = false;
			currentAngle = PhotoComponent.ANIMATION_MAXIMUM_EDGE;
			
		}
		else if (middleAnimationEdgeReached)
			currentAngle += 1;
		else if (!middleAnimationEdgeReached)
			currentAngle -=1;
		System.out.println("Animate");
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
			this.setPreferredSize(new Dimension(imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null)));
			this.revalidate();
			repaint();
		}
	}

	public void drawAllAnnotation(Graphics g)
	{
		for(Annotation a: annotationList)
		{
			g.setColor(a.getColor());
			g.setFont(a.getFont());
			a.drawAnnotation(lastCursorPosition, this, g, imageDisplayed.getPhoto().getWidth(null), imageDisplayed.getPhoto().getHeight(null));
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
		if(currentStrokeAnnotation == null)
		{
			currentStrokeAnnotation = new StrokeAnnotation(lastCursorPosition);
			annotationList.add(currentStrokeAnnotation);
		}
		currentStrokeAnnotation.addPointToStroke(e.getPoint());
		repaint();
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
		typingState = 0;
		currentTextAnnotation = null;
		if(flipped)
			getStatusBar().updateStatusBar("Waiting for annotation");
		else
			getStatusBar().updateStatusBar("Photo state");
		lastCursorPosition.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(System.currentTimeMillis() - dateLastClick < DOUBLE_CLICK_TIME_LIMIT)
		{   
			currentAngle = PhotoComponent.ANIMATION_MAXIMUM_EDGE;
			timer.start();
		}
		else if(Math.sqrt(Math.pow(e.getX()-lastCursorPosition.getX(), 2) + Math.pow(e.getY()-lastCursorPosition.getY(), 2)) < MAX_DISTANCE_SINGLE_CLICK  && flipped)
		{
			if(this.getWidth() - lastCursorPosition.getX() < SMALLEST_DISTANCE_LEDGE)
			{
				System.out.println("Too close to right ledge");
				getStatusBar().updateStatusBar("Too close to the right ledge");
			}
			else
			{
				typingState = 1;
				getStatusBar().updateStatusBar("Entered typing state");
				requestFocus();
			}
		}
		
		currentStrokeAnnotation = null;
		dateLastClick = System.currentTimeMillis();
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

	@Override
	public void keyPressed(KeyEvent e) {
		// Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char toType = e.getKeyChar();
		
		if(typingState == 1)
		{
			currentTextAnnotation = new TextAnnotation(String.valueOf(toType), lastCursorPosition);
			annotationList.add(currentTextAnnotation);
			typingState = 2;
		}
		else if (typingState == 2 && lastCursorPosition != null)
		{
			currentTextAnnotation.setUserAnnotation(currentTextAnnotation.getUserAnnotation() + toType);
		}
		this.repaint();
	}
	
}
