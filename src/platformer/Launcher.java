package platformer;

import engine.*;
import processing.core.PApplet;

public class Launcher extends BaseLauncher 
{

	BallCircle player;
	
	public Launcher(PApplet p) 
	{
		super(p);
	}
	
	
	public void StartGame() 
	{
		super.StartGame(); 
		
		//Builds Player
		Paddle player = new Paddle(parent); //Calling player class
		player.start();
		
		//BallCircle circle = new BallCircle(parent);
		//circle.start();
		
	//	this.gameManager.addObject(circle);
	//	this.gameManager.addPlayerGameObjects(circle);
		
		this.gameManager.addObject(player);
		
		
		
		
		//Builds Platforms
		spawnTiles(10);
		
		int balls = 1; //No of Platforms
		for(int i = 0; i < balls; i++) 
		{
			BallCircle ball = new BallCircle(parent, parent.width / 2 + parent.random(-50, 50), parent.height - 200 + parent.random(-50, 50), player);
			ball.start();
			this.gameManager.addObject(ball);
			this.gameManager.addPlayerGameObjects(ball);
		
		}

		
	}
	
	public void UpdateAll() 
	{
		super.UpdateAll();
		parent.text(BallCircle.points, parent.width/12, parent.height/12);
	}
	
	public void spawnTiles(int numOfTiles) {
		int platforms = numOfTiles; //No of Platforms
		for(int i = 0; i < platforms; i++) 
		{
			Tile platform = new Tile(parent, 50 + i * 55, parent.height-400,50, 20);
			platform.start();
			this.gameManager.addObject(platform);
			this.gameManager.addGameBoundingBoxes(platform);
		
		}
		
		
	}
	

}
