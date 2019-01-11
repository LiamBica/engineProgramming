package engine;
import processing.core.*;
import java.util.ArrayList;



public class GameManager 
{	
	
	private ArrayList<GameObject> gameObjects;
	private ArrayList<GameObject> playerGameObjects;
	private ArrayList<BoundingBox> gameBoundingBoxes;
	
	public static int background = 0;
	public PApplet parent;

	public GameManager(PApplet p) 
	{
			parent = p;
			gameObjects = new ArrayList<GameObject>();
			playerGameObjects = new ArrayList<GameObject>();
			gameBoundingBoxes = new ArrayList<BoundingBox>();
			
	}	
	
	//Game Objects
	
	public void addObject(GameObject g)
	{
		gameObjects.add(g);
	}
	
	public void removeObjects(GameObject g) 
	{
		gameObjects.remove(gameObjects.lastIndexOf(g));
	}
	
	//Game Objects **
	
	
	public void addGameBoundingBoxes(GameObject b) 
	{
		gameBoundingBoxes.add(b.transform.WorldBoundingBox());
	}
	
	public void addPlayerGameObjects(GameObject b) 
	{
		playerGameObjects.add(b);
	}

	public void checkCollisions() 
	{
   	 for(int i = 0; i < gameBoundingBoxes.size(); i++){
		 BoundingBox bb = gameBoundingBoxes.get(i);
		 for(int j = 0; j < playerGameObjects.size(); j++){
	            GameObject p = playerGameObjects.get(j);
	            p.checkCollisions(bb);
	           if(bb.parentGameObject.destroy) {
	        	   gameBoundingBoxes.remove(bb);
	           }

	        }
        
     }
	}
	
	public void StartAll() 
	{
		for(int i = 0; i < gameObjects.size(); i++) 
		{
			GameObject g = gameObjects.get(i);
			g.start();
		}
	}
	
	public void UpdateAll() 
	{
		checkCollisions();
		
		
		parent.background(background);
		for (int i = 0; i < gameObjects.size(); i ++) 
		{
			GameObject g = gameObjects.get(i);
			if(g.destroy) {
				gameObjects.remove(g);
				continue;
			}
			g.update();
			g.render();
		}
	}


}
