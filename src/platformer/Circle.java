package platformer;

import engine.*;
import processing.core.*;

public class Circle extends Sprite {
	
	//Player Characteristics
	int stroke = parent.color(120,120,255); //rgb
	int fill = parent.color(255);
	float w = 30;
	float h = 30;
	float xvar;

	//Movement speed;
	private int xDir = 3, yDir = -3;
	Player paddle;
	
	
	public Circle(PApplet p) 
	{
		
		super(p);
		

	}

	
	public void start() 
	{		
		Player paddle = new Player(parent);
		this.transform.position = new PVector(parent.random(parent.width), parent.random(parent.height));		
	}

	
	public void bounceBall() 
	{  
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
				this.fill = parent.color(0);
				this.stroke = parent.color(0);
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
	public void update() 
	{
		movement();
		bounceBall();
	//	parent.println(parent.mouseX );
	//	parent.println(this.transform.position);
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
