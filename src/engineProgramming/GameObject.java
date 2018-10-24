package engineProgramming;
import processing.core.PApplet;
public abstract class GameObject 
{
	public String name;
	PApplet parent;
	GameObject(PApplet p)
	{
		parent = p;
		
	}

	
public abstract void update();
public abstract void render();




}
