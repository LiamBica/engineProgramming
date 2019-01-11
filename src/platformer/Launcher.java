package platformer;

import engine.*;
import processing.core.PApplet;

public class Launcher extends BaseLauncher 
{
	public boolean started = false;
	int time = parent.millis();
	int wait = 1000;
	int seconds = 0;
	int stopwatch = -4;
	public boolean startOnce;
	BallCircle ball;
	int textInitPosX = parent.width, textInitPosY = parent.height;
	int textSpeedV = 1;
	
	public Launcher(PApplet p) 
	{
		super(p);
	}
	
	
	public void StartGame() 
	{
		super.StartGame();
		startOnce = true;
		//parent.println("Starting");
	}
	
	
	public void timer() 
	{
		if(parent.millis() - time >= wait) 
		{
			seconds++;
			stopwatch++;
			time = parent.millis();
		}
		
		if(seconds >= 5 && startOnce) 
		{
			startOnce = false;
			GameManager.background = 200;
			RestartGame();
		}
		
		if(seconds <= 4) 
		{
			GameManager.background = 0;
			textInitPosY-=textSpeedV;
			parent.textAlign(parent.CENTER);
			parent.text("Recktangle Wrecker", parent.width / 2,textInitPosY);
			parent.text("by", parent.width / 2,textInitPosY + 20);
			parent.text("Liam Roberts-Bica", parent.width / 2,textInitPosY + 40);
			parent.text("Enjoy", parent.width/2, textInitPosY + 60);
		}else 
		{
			parent.textSize(16);
			parent.textAlign(parent.CENTER);
			parent.text("Score: " + BallCircle.points, parent.width/12, parent.height/12);
			parent.text("Time: " + stopwatch + "s", parent.width/12, parent.height/9);
		}

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
		timer();
		//PApplet.println(seconds);
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
