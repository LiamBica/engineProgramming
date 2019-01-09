package platformer;

import engine.*;
import processing.core.PApplet;

public class Launcher extends BaseLauncher 
{

	
	public Launcher(PApplet p) 
	{
		super(p);
	}
	
	
	public void StartGame() 
	{
		super.StartGame(); 
		
		//Builds Player
		Player player = new Player(parent); //Calling player class
		player.start();
		
		BallCircle circle = new BallCircle(parent);
		circle.start();
		
		this.gameManager.addObject(circle);
		this.gameManager.addPlayerGameObjects(circle);
		
		this.gameManager.addObject(player);
		
		
		
		
		//Builds Platforms
		int platforms = 10; //No of Platforms
		for(int i = 0; i < platforms; i++) 
		{
			Tile platform = new Tile(parent, 50 + i * 55, parent.height-400,50, 20);
			platform.start();
			this.gameManager.addObject(platform);
			this.gameManager.addGameBoundingBoxes(platform);
		}

		
	}
	
	public void UpdateAll() 
	{
		super.UpdateAll();
	}

}
