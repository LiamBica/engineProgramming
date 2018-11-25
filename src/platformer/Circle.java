package platformer;

import engine.BoundingBox;
import engine.Physics2D;
import engine.Sprite;
import processing.core.*;

public class Circle extends Sprite {
	
	float speed = 1f;
	float yspeed = 1f;
	float gravity = 0.1f;
	public PVector velocity = new PVector(0, -1);
	
	//Player Characteristics
	public PVector size = new PVector(25,25); //width + height 
	private Physics2D physics;
	public int stroke = parent.color(120,120,255); //rgb
	public int fill = parent.color(255);
	
	
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
	
	public void start() {	
		

		this.transform.boundingBox.fromSize(size);
		this.transform.position = new PVector(parent.random(parent.width), parent.random(parent.height));
		this.velocity.rotate(parent.random(PApplet.TWO_PI));

	}
	
	
	public void checkCollisions(BoundingBox bb) {


		bounceBall();


	}
	
	public void bounceBall() 
	{
		
		this.transform.position.x += speed;
		//if the circle has reached the edge resolution speed reversed
		if (this.transform.position.x > parent.width || this.transform.position.x < 0) 
		{
			speed *= -1;
		}
		this.transform.position.y += yspeed;
		if (this.transform.position.y < 0 || this.transform.position.y > parent.height) 
		{
			yspeed *= -1;
		}
	}
	

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
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
