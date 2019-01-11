package platformer;

import engine.*;
import processing.core.*;

public class BallCircle extends Sprite {
	
	//Player Characteristics
	int stroke = parent.color(120,120,255); //rgb
	int fill = parent.color(255);
	Paddle paddle;
	public float x;
	public float y;
	public float w = 30;
	public float h = 30;
	public static int points;

	//Movement speed;
	private int xDir = 4, yDir = -4;
	
	
	public BallCircle(PApplet p) 
	{
		super(p);
	}	

	public BallCircle(PApplet p, float x, float y, Paddle paddle) 
	{
		super(p);
		this.paddle = paddle; 
		this.x = x;
		this.y = y;
		this.transform.position = new PVector(x, y);
	}

	public void start() 
	{	
		this.points = 0;
		this.size.x = w;
		this.size.y = h;
		this.transform.boundingBox.fromSize(size);
	}

	
	 void bounceBall() 
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
				bounceY();
				this.transform.position.y = parent.height - 200;
			}
			//if the ball hits the paddle's Y axis 		//If the ball hits between the right side of the paddle and the middle [    ||====]
			BoundingBox paddle_bb =  this.paddle.transform.WorldBoundingBox();
			BoundingBox ball_bb =  this.transform.WorldBoundingBox();
			if(ball_bb.bottom >= paddle_bb.top ) 
			{
				if(this.transform.position.y <= paddle_bb.bottom) 
				{			


					if(ball_bb.right >= paddle_bb.left && ball_bb.left <= paddle_bb.right) 
					{
						bounceY();
					}
					
					if(ball_bb.right >= paddle_bb.left && (ball_bb.top > paddle_bb.top && ball_bb.bottom < paddle_bb.bottom))
					{
						bounceLeft();
						
						PApplet.println("hit RIGHT$$$$$$$$$$$$$$$$$$$$$$$$");
					}
					if(ball_bb.left <= paddle_bb.right &&(ball_bb.top > paddle_bb.top && ball_bb.top < paddle_bb.bottom))
					{
						bounceRight();
						PApplet.println("hit LEFT$$$$$$$$$$$$$$$$$$$$$$$$");
					}

				}
			}
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
		//	PApplet.println("hit left: "+ bb.left + " right: "+ bb.right + ", ball top: " + ball_bb.top + " bb.bottom: " + bb.bottom );
			if(this.transform.position.x < bb.right && this.transform.position.x > bb.left) 
			{
				PApplet.println("$$$$$$$$$$$$$$$$$$$$$  bouncing");
				bounceY();
				points++;
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
