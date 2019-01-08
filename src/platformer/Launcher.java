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
		
		Circle circle = new Circle(parent);
		circle.start();
		
		this.gameManager.addObject(circle);
		
		
		this.gameManager.addObject(player);
		
		
		
		/*//Builds Platforms
		int platforms = 8; //No of Platforms
		for(int i = 0; i < platforms; i++) 
		{
			Tile platform = new Tile(parent, 50 + i * 55, parent.height-50,50, 20);
			platform.start();
			this.gameManager.addObject(platform);
			this.gameManager.addGameBoundingBoxes(platform);
		}
		*/
		
	}
	
	public void UpdateAll() 
	{
		super.UpdateAll();
	}

}
