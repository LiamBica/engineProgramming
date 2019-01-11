package engine;
import java.util.ArrayList;

import processing.core.*;

public abstract class GameObject extends ProcessingEntity 
{
	public GameObject(PApplet p) 
	{
		super(p);
		this.components = new ArrayList<GameComponent>();
		transform = new Transform(this);
	}

	public String name;
	public String tag;
	public boolean destroy = false;
	public ArrayList<GameComponent> components;
	public Transform transform;
	public void checkCollisions( BoundingBox bb) {}
	
	
	
	public abstract void start();
	public abstract void update();
	public abstract void render();
	public String ToString() {
		return this.name;
	}
}
