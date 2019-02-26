package definitions;

import com.badlogic.gdx.math.Rectangle;

public class Collider {
	
	public static boolean isCollided(Rectangle r1, Rectangle r2) {
		if(r1.x <= r2.x+r2.width && r1.y <= r2.y+r2.height && r1.x >= r2.x && r1.y >= r2.y) return true;
		else if(r1.x+r1.width >= r2.x && r1.y+r1.height >= r2.y && r1.x+r1.width <= r2.x+r2.width && r1.y+r1.height <=r2.y+r2.height) return true;
		else return false;
	}
	
	public static boolean isCollidedLeft(Rectangle actor, Rectangle object) {
		return actor.x+actor.width >= object.x;
	}

}
