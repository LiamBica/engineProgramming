package platformer;

import engine.*;
import processing.core.*;

public class BallCircle extends Sprite {
	
	//Player Characteristics
	int stroke = parent.color(120,120,255); //rgb
	int fill = parent.color(255);
	
	public float x;
	public float y;
	public float w = 30;
	public float h = 30;


	//Movement speed;
	private int xDir = 4, yDir = -4;
	
	
	public BallCircle(PApplet p) 
	{
		super(p);
	}

	
	public void start() 
	{	
		
		this.transform.position = new PVector(parent.width / 2, parent.height - 200);
		this.size.x = w;
		this.size.y = h;
		this.transform.boundingBox.fromSize(size);
	}

	
	public void bounceBall() 
	{  
		
			
			//if the circle has reached the edge resolution speed reversed
			if (this.transform.position.x > parent.width || this.transform.position.x < 0) 
			{
				bounceLeft();
			}
			//If the ball hits the ceiling it will bounce down
			if (this.transform.position.y < 0) 
			{
				bounceY();
			}
			//If ball falls through it's removed until the game is reset
			if(this.transform.position.y >= parent.height + 30) 
			{
				//this.fill = parent.color(0);
				//this.stroke = parent.color(0);
				this.start();
				bounceY();
				}
			//if the ball hits the paddle's Y axis 				//If the ball hits between the right side of the paddle and the middle [    ||====]
			if (this.transform.position.y == parent.height - 100 && (this.transform.position.x <= parent.mouseX +60 && this.transform.position.x > parent.mouseX) )
			{
				bounceRight();
				bounceY();
			}
	
			//If the ball hits the paddle's Y axis 			//If the ball hits between the left side of the paddle and the middle [=====||     ]
			if (this.transform.position.y == parent.height - 100 && (this.transform.position.x < parent.mouseX  && this.transform.position.x >= parent.mouseX -60) )
			{
				bounceLeft();
				bounceY();
			}
			if (this.transform.position.y == - 100 && (this.transform.position.x < parent.mouseX  && this.transform.position.x >= parent.mouseX -60) )
			{
				bounceLeft();
				bounceY();
			}
//ball falls of bottom of screen?
			
		
	}
	
	public void bounceLeft() 
	{
		xDir *= -1;
	}
	public void bounceRight() 
	{
		xDir *= 1;
	}
	public void bounceY() 
	{
		yDir *= -1;
	}
	
	public void movement() 
	{
		this.transform.position.x += xDir;
		this.transform.position.y += yDir;
	}
	@Override
	public void checkCollisions( BoundingBox bb) {
		BoundingBox ball_bb = this.transform.WorldBoundingBox();
	//	PApplet.println("hit left: "+ bb.left + " right: "+ bb.right + ", ball x: " + ball_bb.top);
		boolean ballUnder = bb.bottom > ball_bb.top;
		boolean ballOver = bb.top > ball_bb.bottom;
		if(ballUnder && !ballOver)  {
			PApplet.println("hit left: "+ bb.left + " right: "+ bb.right + ", ball top: " + ball_bb.top + " bb.bottom: " + bb.bottom );
			
			if(this.transform.position.x < bb.right && this.transform.position.x > bb.left) {
				PApplet.println("$$$$$$$$$$$$$$$$$$$$$  bouncing");
				bounceY();
				//tile destroy
				bb.parentGameObject.destroy = true;
				
			}
			
		}
	}
	
	@Override
	public void update() 
	{
		x = this.transform.position.x;
		y = this.transform.position.y;
		movement();
		bounceBall();
	}
	
	@Override
	public void render() //Rendering Character
	{
		super.render();
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.ellipse(this.transform.position.x, this.transform.position.y, w, h);
	}

}
