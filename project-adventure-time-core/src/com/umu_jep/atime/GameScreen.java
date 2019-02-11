/**
 * WARNING: @camera has its (0,0) coordinates at the center of the screen.
 */
package com.umu_jep.atime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import definitions.Assets;
import definitions.actors.Player;
import definitions.screen_utils.GameMenuButtons;
import definitions.screen_utils.UITest;

public class GameScreen implements Screen {

	AdTimeGame game;
	private SpriteBatch batch;
	private AssetManager manager;
	private OrthographicCamera camera;
	private Viewport viewport;
	private Stage uiStage, gameStage, menuStage, dialogStage;		//different screens (stages) for in-game display (might decrease in amount)

	public boolean gameIsPaused, dialogScreenCalled, menuScreenCalled;
	private String dialogText, dialogName;		//not used yet
	
	private Player player;
	private final String playerName = "Jep";
	
	private Texture test, backTest;
	private Sprite backSprite;
	
	private float SPEED = 2;
	
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
		//player = new Player(playerName, manager.get(Assets.playerSprite));

	}
	
	@Override
	public void show() {
		loadAssets();
		gameIsPaused = false;
		menuScreenCalled = false;
		dialogScreenCalled = false;
		viewport.apply();
		camera.setToOrtho(false, 16*16, 9*16);
		
		Gdx.input.setInputProcessor(menuStage);
		//gameStage.addActor(player);
		uiStage.addActor(new UITest(camera));		//TODO parameter texture
		menuStage.addActor(new GameMenuButtons("resume", camera, manager.get(Assets.startTexture), game, this));
		backSprite.setBounds(0, 0, manager.get(Assets.testBackground).getWidth(), manager.get(Assets.testBackground).getHeight());
	}

	@Override
	public void render(float delta) {
		camera.update();
		
		if(!gameIsPaused) {			//check if any screen other than the game screen is active
			Gdx.gl.glClearColor(0.5f, 0, 0, 0.5f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			//batch.setProjectionMatrix(camera.combined);		//Test
			
			gameStage.draw();
			//TODO Delete this
			batch.begin();
			backSprite.draw(batch);
			batch.end();
			
			checkMovement();

			uiStage.draw();			//always after gameStage.draw()

		}
		
		menu();			//check if menu screen is called
		dialog();		//check if dialog screen is called

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
	}
	
	/**
	 * Non Libgdx methods
	 * */
	
	/** Loading assets */
	private void loadAssets() {
		//manager.load(Assets.playerSprite);
		manager.load(Assets.testGif);			//Test
		manager.load(Assets.startTexture);
		manager.load(Assets.testBackground);
		manager.finishLoading();;
		
		test = manager.get(Assets.testGif);		//test
		backSprite = new Sprite(manager.get(Assets.testBackground));

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
		if(Gdx.input.isKeyPressed(Input.Keys.D) && backSprite.getWidth() >= camera.position.x + camera.viewportWidth/2 + 1) {
			camera.translate(1*SPEED,0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) && backSprite.getX() <= camera.position.x - camera.viewportWidth/2 - 1) {
			camera.translate(-1*SPEED,0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W) && backSprite.getHeight() >= camera.position.y + camera.viewportHeight/2 + 1) {
			camera.translate(0,1*SPEED);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S) && backSprite.getY() <= camera.position.y - camera.viewportHeight/2 - 1) {
			camera.translate(0,-1*SPEED);
		}
	}

}
