package ai;

import com.badlogic.gdx.scenes.scene2d.Stage;

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
	public void act(BaseNPC npc, Stage stage) {
		
		if(isRunning()) {
			
			if(!npc.isAlive()) {
				
				fail();
				return;
			}
			if(!isAtDestination(npc)) {
				
				if(destX > npc.getX()) {
					
					npc.setX(npc.getX() + npc.getMoveSpeed());
				}else {
					
					npc.setX(npc.getX() - npc.getMoveSpeed());
				}
				
				if(destX < npc.getX()) {
					
					npc.setY(npc.getY() + npc.getMoveSpeed());
				}else {
					
					npc.setY(npc.getY() - npc.getMoveSpeed());
				}
			}else if(isAtDestination(npc)){
				
				succeed();
			}else {
				
				System.out.println("What");
			}
		}
	}
	
	public boolean isAtDestination(BaseNPC npc) {
		
		return destX == npc.getX() && destY == npc.getY();
	}

}
