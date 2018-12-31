package platformer;

import engine.*;
import processing.core.*;

public class Circle extends Sprite {
	
	public float speed = 1f;
	public float yspeed = 1f;
	public boolean hitTile = false;
	float gravity = 0.1f;
	public PVector velocity = new PVector(0, -1);
	
	//Player Characteristics
	public PVector size = new PVector(25,25); //width + height 
	private Physics2D physics;
	public int stroke = parent.color(120,120,255); //rgb
	public int fill = parent.color(255);
	private Player paddle;
	private int xDir = 1, yDir = -1;
	
	
	public Circle(PApplet p) 
	{
		super(p);
		
	}

	public Circle(PApplet p, float x, float y, float w, float h) 
	{
		super(p);
		speed = 1.0f;
		yspeed = 1.0f;
	}
	
	public void start() 
	{	
		this.transform.boundingBox.fromSize(size);
		this.transform.position = new PVector(parent.random(parent.width), parent.random(parent.height));
		this.velocity.rotate(parent.random(PApplet.TWO_PI));
		this.physics = new Physics2D(this);
		this.physics.start();
		paddle = new Player(parent);
	}

	
	public void checkCollisions(BoundingBox bb) 
	{
		this.physics.checkCollisions(bb);
		bounceBall();
		movement();
	}
	
	public void bounceBall() 
	{  
		{
		//if the circle has reached the edge resolution speed reversed
		if (this.transform.position.x > parent.width || this.transform.position.x < 0) 
			{
				xDir *= -1;
			}
		
		if (this.transform.position.y < 0 || this.transform.position.y > parent.height) 
			{
				yDir *= -1;
			}
		}	
	}
	
	public void movement() 
	{
		this.transform.position.x += xDir;
		this.transform.position.y += yDir;
	}
	
	public void setXDir (int xDir) 
	{
		this.xDir = xDir;
	}
	public void setYDir (int yDir) 
	{
		this.yDir = yDir;
	}

	public int getXDir()
	{
		return xDir;
	}
	
	public int getYDir() 
	{
		return yDir;
	}
	
	@Override
	public void update() 
	{
		
	}
	
	@Override
	public void render() //Rendering Character
	{
		super.render();
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.ellipse(this.transform.position.x, this.transform.position.y,this.size.x, this.size.y);
	}

}
