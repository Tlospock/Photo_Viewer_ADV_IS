/**
 * 
 */
package treeNode;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * @author Tlos
 *
 */
public class ContainerNode extends Node{

	public ContainerNode(Node parentTemp) {
		super(parentTemp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		super.drawChildren();
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
		if(childrens.size() <= 0)
		{
			this.setBounds(null);
			return;
		}
		
		if(childrens.size() == 1)
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
