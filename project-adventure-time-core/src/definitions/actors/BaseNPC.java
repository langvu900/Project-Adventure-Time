package definitions.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
//import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class BaseNPC extends Actor {
	
	public Texture baseNPCSprite;

	public BaseNPC(float posX, float posY, boolean isTouchable, boolean isHostile) {
		
		//Rectangle bounds = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		idleLoop(posX, posY, 5, 0, 10, 5);
	}

	private void idleLoop(float oldX, float oldY, float moveX, float moveY, int travelTime, float idleTime) {
		//Creates a movement pattern, consisting of a movement phase with set destination and travel time, and a set idle time
		//Parameters in order: Current position (X and Y), travel distance (X and Y), travel and idle time in seconds.
			
			this.addAction(Actions.moveTo(oldX + moveX, oldY + moveY, travelTime));
			this.addAction(Actions.delay(idleTime));
			this.addAction(Actions.moveTo(oldX, oldY, travelTime));
			this.addAction(Actions.delay(idleTime));
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		batch.draw(baseNPCSprite, this.getX(), this.getY());
	}
}

//NO COLLISION YET!
