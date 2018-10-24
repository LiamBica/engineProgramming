package engineProgramming;
import processing.core.*;

public class Player extends Sprite {

	Player(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}


	float speed = 2.0f; //Movement Speed
	float jumpS = 2f; //Jump Height
	public PVector size = new PVector (30, 30);
	
	@Override
	public void update() {
		super.update();

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}
	
	
}
