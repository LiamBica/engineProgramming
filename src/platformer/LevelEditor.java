package platformer;

import engine.*;
import processing.core.PApplet;

public class LevelEditor extends BaseLauncher 
{
	public boolean started = false;

	GameManager gm;
	BallCircle player;
	public boolean shouldStart;

	public LevelEditor(PApplet p) 
	{
		super(p);
	}
	
	float w = 150;
	float h = 80;
	float x = 415;
	float y = 350;
	
	public void StartGame() 
	{
		super.StartGame();
		GameManager.background = 0;
		parent.println("Starting");
	}
	


	public void RestartGame() 
	{
		Paddle player = new Paddle(parent); //Calling player class
		player.start();
		this.gameManager.addObject(player);
		
		spawnTiles(10);
		
		int balls = 1; //No of Platforms
		for(int i = 0; i < balls; i++) { 
			BallCircle ball = new BallCircle(parent, parent.width / 2 + parent.random(-50, 50), parent.height - 200 + parent.random(-50, 50), player);
			ball.start();
			this.gameManager.addObject(ball);
			this.gameManager.addPlayerGameObjects(ball);
		}
		this.gameManager.StartAll();
		this.started = true;
	}

		
	
	public void UpdateAll() 
	{
		super.UpdateAll();
		parent.rect(x, y, w, h);
		parent.rect(x,y,w,h);
		parent.fill(255);
		parent.text("Spawn player", x, y);
		parent.textSize(15);
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
	void startButton() 
	{
		parent.rect(x,y,w,h);
		parent.fill(255);
		parent.text("Spawn player", x, y);
		parent.textSize(15);
		if(parent.mousePressed == true)
		{	//If the mouse position is over the rectangle position
			if(parent.mouseX> x && parent.mouseX <x+w && parent.mouseY>y && parent.mouseY <y+h) 
			{
				//Spawn player
				parent.background(0);
				player.update();
				
			}
		}
	
		
	}
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) 
	{
			
		if(mouseButton == 37) 
		{
			//DoSomething();		
		}
			
	}	
	

}
