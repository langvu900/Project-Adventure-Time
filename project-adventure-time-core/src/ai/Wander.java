package ai;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.Stage;

import definitions.actors.BaseNPC;

public class Wander extends Routine {
	
	public static Random random = new Random();
	public Stage stage = new Stage();
	public MoveTo moveTo;
	
	@Override
	public void start() {
		
		super.start();
		this.moveTo.start();
	}
	
	@Override
	public void reset() {

		this.moveTo = new MoveTo(random.nextInt((int) stage.getWidth()), random.nextInt((int) stage.getHeight()));
	}
	
	public Wander(Stage stage) {
		
		this.stage = stage;
		this.moveTo = new MoveTo(random.nextInt((int)stage.getWidth()), random.nextInt((int)stage.getHeight()));
	}

	@Override
	public void act(BaseNPC npc, Stage stage) {
		
		if(!moveTo.isRunning()) {
			
			return;
		}else if(this.moveTo.isFailure()) {
			
			fail();
		}
	}

}
