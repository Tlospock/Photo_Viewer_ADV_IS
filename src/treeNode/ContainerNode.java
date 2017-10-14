/**
 * 
 */
package treeNode;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * @author Tlos
 *
 */
public class ContainerNode extends Node{

	private JComponent parentPosition;
	
	public ContainerNode(Node parentTemp, JComponent parentPanel) {
		super(parentTemp);
		parentPosition = parentPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g, JComponent panel) {
		super.drawChildren(g, panel);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addChildren(Node childrenToAdd)
	{
		super.addChildren(childrenToAdd);
		this.updateBounds();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeChildren(Node childToRemove){
		boolean isRemoved = super.removeChildren(childToRemove);
		this.updateBounds();
		
		return isRemoved;
	}
	
	/**
	 * To update the bounds after adding o removing one or several children
	 */
	public void updateBounds()
	{
		this.setBounds(new Rectangle(0, 0, 0, 0));
		if(childrens.size() <= 0)
		{
			this.setBounds(null);
			return;
		}
		
		if(this.getBounds() == null && childrens.size() >= 1)
		{
			this.setBounds(new Rectangle((Rectangle) childrens.get(0).getBounds()));
			return;
		}
		
		for(Node n : childrens)
		{
			if(n.getBounds().getX() > this.getBounds().getX())
				this.getBounds().setRect(n.getBounds().getX(), this.getBounds().getY(), this.getBounds().getWidth(), this.getBounds().getHeight());
			
			if(n.getBounds().getY() > this.getBounds().getY())
				this.getBounds().setRect(this.getBounds().getX(), n.getBounds().getY(), this.getBounds().getWidth(), this.getBounds().getHeight());

			if(n.getBounds().getWidth() > this.getBounds().getWidth())
				this.getBounds().setRect(this.getBounds().getX(), this.getBounds().getY(), n.getBounds().getWidth(), this.getBounds().getHeight());
			
			if(n.getBounds().getHeight() > this.getBounds().getHeight())
				this.getBounds().setRect(this.getBounds().getX(), this.getBounds().getY(), this.getBounds().getWidth(), n.getBounds().getHeight());
		}
		
	}

}
