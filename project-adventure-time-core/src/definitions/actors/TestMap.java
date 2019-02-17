package definitions.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TestMap extends Actor{
	
	TiledMap map;
	
	
	public TestMap(TiledMap map) {
		this.map = map;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		
	}
	
}
