package platformer;

import engine.*;
import processing.core.*;

public class Circle extends Sprite {
	
	//Player Characteristics
	int stroke = parent.color(120,120,255); //rgb
	int fill = parent.color(255);
	float w;
	float h;

	private int xDir = 3, yDir = -3;
	
	
	public Circle(PApplet p) 
	{
		super(p);
		this.size.x = w;
		this.size.y = h;
	}

	
	public void start() 
	{		
		w = 30;
		h = 30;
		this.transform.position = new PVector(parent.random(parent.width), parent.random(parent.height));		
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
	
	
	@Override
	public void update() 
	{
		bounceBall();
		movement();
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
