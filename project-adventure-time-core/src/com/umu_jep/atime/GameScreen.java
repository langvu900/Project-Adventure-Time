/**
 * WARNING: @camera has its (0,0) coordinates at the center of the screen.
 */
package com.umu_jep.atime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.*;
/*import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;*/
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import definitions.Assets;
//import definitions.Collider;
import definitions.actors.Player;
import definitions.screen_utils.GameMenuButtons;
import definitions.screen_utils.UITest;

public class GameScreen implements Screen {

	AdTimeGame game;
	private SpriteBatch batch;
	public AssetManager manager;
	public static OrthographicCamera camera;
	public Viewport viewport;
	private Stage uiStage, gameStage, menuStage, dialogStage;		//different screens (stages) for in-game display (might decrease in amount)

	public boolean gameIsPaused, dialogScreenCalled, menuScreenCalled;
	private String dialogText, dialogName;		//not used yet
	
	private Player player;
	private final String playerName = "Jep";
	
	private Texture test, backTest;
	private Sprite backSprite;
	
	public float SPEED = 2;
	private float playerX = 1, playerY = 1;
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;
	private MapLayer collisionLayer;
	public static MapProperties prop;
	public static MapObjects mapCollision;

	
	public GameScreen(AdTimeGame game) {
		this.game = game;
		batch = new SpriteBatch();
		manager = new AssetManager();
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(16*16, 16*9, camera);
		
		uiStage = new Stage(viewport, batch);
		gameStage = new Stage(viewport, uiStage.getBatch());
		menuStage = new Stage(viewport, uiStage.getBatch());
		dialogStage = new Stage(viewport, uiStage.getBatch());

	}
	
	@Override
	public void show() {
		loadAssets();
		loadMap(Assets.testMap);
		mapCollision = collisionLayer.getObjects();
		
		gameIsPaused = false;
		menuScreenCalled = false;
		dialogScreenCalled = false;
		viewport.apply();
		camera.setToOrtho(false, 16*16, 9*16);
		
		Gdx.input.setInputProcessor(menuStage);
		player = new Player(playerName, manager.get(Assets.playerSprite));
		player.setPosition(playerX, playerY);
		gameStage.addActor(player);
		
		uiStage.addActor(new UITest(camera));		//TODO parameter texture
		
		menuStage.addActor(new GameMenuButtons("resume", camera, manager.get(Assets.startTexture), game, this));
		
		backSprite.setBounds(0, 0, manager.get(Assets.testBackground).getWidth(), manager.get(Assets.testBackground).getHeight());
		
		//System.out.print(mapCollision.getByType(PolygonMapObject.class).get(0).getPolygon());
	}

	@Override
	public void render(float delta) {		
		if(!gameIsPaused) {			//check if any screen other than the game screen is active
			Gdx.gl.glClearColor(1, 1, 1, 0.5f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			//batch.setProjectionMatrix(camera.combined);		//Test
			
			mapRenderer.render();
			mapRenderer.setView(camera);
			batch.begin();
			//backSprite.draw(batch);
			batch.end();
			
			checkMovement();
			gameStage.draw();

			uiStage.draw();			//always after gameStage.draw()

		}
		
		menu();			//check if menu screen is called
		dialog();		//check if dialog screen is called
		camera.update();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		manager.dispose();
		uiStage.dispose();
		gameStage.dispose();
		menuStage.dispose();
		dialogStage.dispose();
		mapRenderer.dispose();
	}
	
	/**
	 * Non Libgdx methods
	 * */
	
	/** Loading assets */
	private void loadAssets() {
		manager.load(Assets.playerSprite);
		manager.load(Assets.testGif);			//Test
		manager.load(Assets.startTexture);
		manager.load(Assets.testBackground);
		manager.finishLoading();;
		
		test = manager.get(Assets.testGif);		//test
		backSprite = new Sprite(manager.get(Assets.testBackground));

	}
	
	/** Loading map/s */
	public void loadMap(AssetDescriptor<TiledMap> mapName) {
		manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		manager.load(mapName);
		manager.finishLoading();
		
		map = manager.get(mapName);
		mapRenderer = new OrthogonalTiledMapRenderer(map, 1);
		collisionLayer = (MapLayer) map.getLayers().get("natural_collision");
		prop = map.getProperties();
	}
	
	/** ESC button, in-game menu */
	public void menu( ) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			if(!menuScreenCalled) {
				gameIsPaused = true;
				menuScreenCalled = true;
			} else if (!dialogScreenCalled){
				gameIsPaused = false;			//returns to game screen by 2nd press
				menuScreenCalled = false;
			} else menuScreenCalled = false;
		}
		if(menuScreenCalled) {
			menuStage.draw();
			menuStage.act();
		}
	}
	
	/** Dialog screen */
	private void dialog() {
		//TODO DialogStage
		//TODO Parameters
		if(dialogScreenCalled) {
			gameIsPaused = true;
			dialogStage.draw();
		}
	}
	
	private void checkMovement() {
		//System.out.println(player.getRectangle());
		float mapWidth = prop.get("width", Integer.class) * prop.get("tilewidth", Integer.class);
		float mapHeight = prop.get("height", Integer.class) * prop.get("tileheight", Integer.class);
		boolean moveable = true;
		
		// Move right
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			//Collision check
			for(RectangleMapObject rectangleObject : mapCollision.getByType(RectangleMapObject.class)) {
				if(rectangleObject.getRectangle().overlaps(new Rectangle(player.getX()+1, player.getY(), player.getWidth(), 10))) {
					moveable = false;
					break;
				}else moveable = true;
			}
			
			if(player.getRight() <= mapWidth && moveable) {
				if(player.getX()+player.getWidth()/2 == camera.position.x && mapWidth >= camera.position.x + camera.viewportWidth/2 + 1) camera.translate(1*SPEED,0);
				player.moveBy(1*SPEED, 0);
			}
			player.setDirection("EAST");;
		}
		
		//Move left
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			//Collision check
			for(RectangleMapObject rectangleObject : mapCollision.getByType(RectangleMapObject.class)) {
				if(rectangleObject.getRectangle().overlaps(new Rectangle(player.getX()-1, player.getY(), player.getWidth(), 10))) {
					moveable = false;
					break;
				} else moveable = true;
			}
			
			if(player.getX() >= 0 && moveable) {
				if(player.getX()+player.getWidth()/2 == camera.position.x && 0 <= camera.position.x - camera.viewportWidth/2 - 1) camera.translate(-1*SPEED,0);
				player.moveBy(-1*SPEED, 0);
			}
			player.setDirection("WEST");
		}
		
		//Move up
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			//Collision check
			for(RectangleMapObject rectangleObject : mapCollision.getByType(RectangleMapObject.class)) {
				if(rectangleObject.getRectangle().overlaps(new Rectangle(player.getX(), player.getY()+1, player.getWidth()-1, 11))) {
					moveable = false;
					break;
				} else moveable = true;
			}
			
			if(player.getTop() <= mapHeight && moveable) {
				if(player.getY()+player.getHeight()/2 == camera.position.y && mapHeight >= camera.position.y + camera.viewportHeight/2 + 1) camera.translate(0,1*SPEED);
				player.moveBy(0, 1*SPEED);
			}
			player.setDirection("NORTH");
		}
		
		//Move down
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			//Collision check
			for(RectangleMapObject rectangleObject : mapCollision.getByType(RectangleMapObject.class)) {
				if(rectangleObject.getRectangle().overlaps(new Rectangle(player.getX(), player.getY()-1, player.getWidth()-1, 10))) {
					moveable = false;
					break;
				} else moveable = true;
			}
			
			if(player.getY() >= 0 && moveable) {
				if(player.getY()+player.getHeight()/2 == camera.position.y && 0 <= camera.position.y - camera.viewportHeight/2 - 1) camera.translate(0,-1*SPEED);	
				player.moveBy(0, -1*SPEED);
			}
			player.setDirection("SOUTH");
		}
	}
	
}
