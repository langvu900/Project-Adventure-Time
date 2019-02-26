package definitions.actors;

//import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class BaseNPC extends Actor {

	public BaseNPC(float posX, float posY) {
		
		//Rectangle bounds = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		idleLoop(posX, posY, 5, 0, 10, 5);
	}

	private void idleLoop(float oldX, float oldY, float moveX, float moveY, int travelTime, float idleTime) {
		//Creates a movement pattern, consisting of a movement phase with set destination and travel time, and a set idle time
		//Parameters include current position, travel distance and travel time
			
			this.addAction(Actions.moveTo(oldX + moveX, oldY + moveY, travelTime));
			this.addAction(Actions.delay(idleTime));
			this.addAction(Actions.moveTo(oldX, oldY, travelTime));
			this.addAction(Actions.delay(idleTime));
	}
}

//NO COLLISION YET!
