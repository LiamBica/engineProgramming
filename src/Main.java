
import platformer.Circle;
import platformer.Launcher;
import platformer.Player;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) 
	{
		PApplet.main("Main");
	}

	Launcher launcher;
	Player player;
	Circle circle;
	private int xSpeed;
	
	public void setup() 
	{
		
		background(0); //Black background
		launcher = new Launcher(this);

		launcher.StartGame();
		
		
	}
	
	public void draw() 
	{
		
		launcher.UpdateAll();
		
		
		
		
	}
	public void checkPaddle(int x1, int y1) 
	{
		if(player.hitPlayer(x1, y1) && circle.getXDir() > 0) 
		{
			circle.setYDir(-1);
			xSpeed = -1;
			circle.setXDir(xSpeed);
		}
		if(player.hitPlayer(x1, y1) && circle.getXDir() < 0) 
		{
			circle.setYDir(-1);
			xSpeed = 1;
			circle.setXDir(xSpeed);
		}
	}
	
	public void settings() 
	{
		size(640,480);
	}

}
