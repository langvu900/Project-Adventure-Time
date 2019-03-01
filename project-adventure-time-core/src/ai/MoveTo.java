package ai;

import com.umu_jep.atime.GameScreen;

import definitions.actors.BaseNPC;

public class MoveTo extends Routine {
	
	final public int destX;
	final public int destY;
	
	public MoveTo(int destX, int destY) {
		
		super();
		this.destX = destX;
		this.destY = destY;
	}

	@Override
	public void reset() {

		start();
	}

	@Override
	public void act(BaseNPC npc, GameScreen stage) {
		// TODO Auto-generated method stub

	}

}
