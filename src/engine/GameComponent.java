package engine;



public abstract class GameComponent extends ProcessingEntity 
{

	public GameComponent(GameObject g) 
	{		
		super(g.parent);
		this.gameObject = g;
		this.transform = this.gameObject.transform;
		this.gameObject.components.add(this);
	}
	
	public abstract void start();
	public abstract void update();
	public abstract void render();
	public GameObject gameObject;
	public Transform transform;
	
}
