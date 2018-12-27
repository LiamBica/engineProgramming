package engine;

import processing.core.PVector;

public class Physics2D extends GameComponent 
{
	
	private PVector velocity = new PVector(0,0);
	public BoxCollider2D boxCollider2D;
	
	float gravity = 0.1f;
	boolean canJump = true;
	boolean hasHitSomething = false;
	
	
	public Physics2D(GameObject g)
	{
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {

		this.boxCollider2D = new BoxCollider2D(this.gameObject);
	}

	@Override
	public void update()
	{
		
		this.transform.position.y += velocity.y;

	}

	@Override
	public void render()
	{
		// TODO Auto-generated method stub

	}
	
	public void checkCollisions(BoundingBox _boundingBox) {
		if( this.boxCollider2D.checkCollision(_boundingBox)) 
		{
			velocity = new PVector(0,0);
			isGrounded();
			hasHitSomething = true;
		}
	}
	
	
	public void isGrounded()
	{
		canJump = true;
	}
	
	
	

}
