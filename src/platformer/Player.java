package platformer;
import engine.*;


import processing.core.*;
import processing.core.PApplet;


public class Player extends Sprite {
	
	float speed = 3f;
	float gravity = 0.1f;
	
	//Player Characteristics
	public PVector size = new PVector(12,12); //width + height 
	private Physics2D physics;
	public int stroke = parent.color(120,120,255); //rgb
	public int fill = parent.color(255);
	
	
	
	
	public Player(PApplet p) 
	{
		super(p);
		
		// TODO Auto-generated constructor stub
	}

	public Player(PApplet p, float x, float y, float w, float h) 
	{
		super(p);
		speed = 3.0f;
	}
	
	public void start() {
		this.transform.position.x = parent.width / 2;
		this.transform.position.y = parent.height /2;
		this.transform.boundingBox.fromSize(size);
		this.physics = new Physics2D(this);
		this.physics.start();
		
	}
	
	public void checkCollisions(BoundingBox bb) 
	{
		this.physics.checkCollisions(bb);
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
		parent.rect(this.transform.position.x, this.transform.position.y,this.size.x, this.size.y);
	}

}