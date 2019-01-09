package platformer;
import engine.*;


import processing.core.*;
import processing.core.PApplet;


public class Player extends Sprite {
	
	//Player Characteristics
	public int stroke = parent.color(120,120,255); //rgb
	public int fill = parent.color(255);
	public float w = 120;
	public float h = 20;
	public float x;
	public float y;
	public PVector position = new PVector();
	public Player(PApplet p) 
	{
		super(p);
		this.size.x = w;
		this.size.y = h;
	}
	
	@Override
	public void start() 
	{	
		super.start();
		this.transform.position.y = parent.height - 100;//this.transform.position.x = parent.width / 2;
	}


	
	@Override
	public void update() 
	{
		position = transform.position;
		y = this.transform.position.y;
	}
	
	@Override
	public void render() //Rendering Character
	{
		super.render();
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(parent.mouseX - w/2, this.transform.position.y ,w, h);
	}

}
