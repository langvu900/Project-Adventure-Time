package definitions.actors;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class testMap {
	
	 //TiledMap map;
	//OrthogonalTiledMapRenderer tmR;
	//OrthographicCamera camera;
	//TiledMapTileLayer layer;
	
//	public testMap(TiledMap map) {
			static TiledMap map = new TmxMapLoader().load("TutorialMap.tmx");
			 //tmR = new OrthogonalTiledMapRenderer(map);
			static MapProperties prop = map.getProperties();
			
			public static int mapWidth = prop.get("width", Integer.class);
			public static int mapHeight = prop.get("height", Integer.class);
			public static int tilePixelWidth = prop.get("tilewidth", Integer.class);
			public static int tilePixelHeight = prop.get("tileheight", Integer.class);
			
			public static int mapPixelWidth = mapWidth * tilePixelWidth;
			public static int mapPixelHeight = mapHeight * tilePixelHeight;
			
//	}
	
}

