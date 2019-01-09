package engine;
import processing.core.*;

public class BoundingBox 
{

	public GameObject parentGameObject;
	public BoundingBox(GameObject o, int _l, int _r, int _t, int _b) 
	{
		if(o != null) {
			parentGameObject = o;
		}else {
			PApplet.println("Error no parent");
		}
		
		left = _l;
		right = _r;
		top = _t;
		bottom = _b;
		

	}
	public void fromSize(PVector size) 
	{
		this.left = -size.x/2f;
		this.right = size.x/2f;
		this.top = -size.y/2f;
		this.bottom = size.y/2f;
	}
	
	public float left;
	public float right;
	public float bottom;
	public float top;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
