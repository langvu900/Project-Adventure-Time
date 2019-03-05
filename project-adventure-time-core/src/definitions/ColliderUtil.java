package definitions;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class ColliderUtil {
	
	// Check if Polygon intersects Rectangle
	private boolean isCollision(Polygon p, Rectangle r) {
	    Polygon rPoly = new Polygon(new float[] { 0, 0, r.width, 0, r.width,
	            r.height, 0, r.height });
	    rPoly.setPosition(r.x, r.y);
	    if (Intersector.overlapConvexPolygons(rPoly, p))
	        return true;
	    return false;
	}
}
