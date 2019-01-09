package engine;

import processing.core.PVector;


public class Transform {

	public Transform(GameObject o) 
	{
		parentGameObject = o;
		 boundingBox = new BoundingBox(parentGameObject,-1,1,-1,1);
	}
	public GameObject parentGameObject;
	public PVector position = new PVector(0,0);
	public PVector rotation = new PVector(0,0);
	public PVector scale = new PVector(0,0);;
	
	public BoundingBox boundingBox;
	public BoundingBox WorldBoundingBox() 
	{
		BoundingBox bb = new BoundingBox(parentGameObject,-1,1,-1,1);
		bb.left = position.x + boundingBox.left;
		bb.right = position.x + boundingBox.right;
		bb.top = position.y + boundingBox.top;
		bb.bottom = position.y + boundingBox.bottom;
		return bb;
		
		
		
		
	}
	

}