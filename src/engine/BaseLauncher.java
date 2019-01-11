package engine;

import processing.core.*;

public abstract class BaseLauncher 
{
	
	public PApplet parent;
	
	public BaseLauncher(PApplet p) 
	{
		parent = p;
	}
	
	public GameManager gameManager;
	
	public void StartGame() 
	{
		gameManager = new GameManager(parent);
	}
	
	public void UpdateAll() 
	{
		gameManager.UpdateAll();
	}
	
}
