package platformer;
import engine.*;


import processing.core.*;
import processing.core.PApplet;


public class Player extends Sprite {
	
	float speed = 3f;
	float gravity = 0.1f;
	
	//Player Characteristics
	public PVector size = new PVector(120,20); //width + height 
	private Physics2D physics;
	public int stroke = parent.color(120,120,255); //rgb
	public int fill = parent.color(255);
	
	
	public Player(PApplet p) 
	{
		super(p);
		
	}

	public Player(PApplet p, float x, float y, float w, float h) 
	{
		super(p);
		speed = 3.0f;
	}
	@Override
	public void start() {	
		super.start();
		this.transform.position.y = parent.width -199;//this.transform.position.x = parent.width / 2;
		this.transform.boundingBox.fromSize(size);

		
		
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
		parent.rect(parent.mouseX, this.transform.position.y,this.size.x, this.size.y);
	}

}
