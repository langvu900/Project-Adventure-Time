package com.umu_jep.atime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import definitions.Assets;
import definitions.actors.Player;
import definitions.screen_utils.UITest;

public class GameScreen implements Screen {

	AdTimeGame game;
	private boolean gameIsPaused;
	private SpriteBatch batch;
	private AssetManager manager;
	
	private OrthographicCamera camera;
	private Viewport viewport;
	private Stage uiStage, gameStage, menuStage, dialogStage;		//different screens (stages) for in-game display

	private boolean dialogScreenCalled, menuScreenCalled;
	private String dialogText, dialogName;		//not used yet
	
	private Actor player;
	private final String playerName = "Jep";
	
	Texture test;
	
	public GameScreen(AdTimeGame game) {
		this.game = game;
		batch = new SpriteBatch();
		manager = new AssetManager();
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(16*16, 16*9, camera);
		
		uiStage = new Stage(viewport);
		gameStage = new Stage(viewport);
		menuStage = new Stage(viewport);
		dialogStage = new Stage(viewport);
		
		//player = new Player(playerName, manager.get(Assets.playerSprite));
	}
	
	@Override
	public void show() {
		loadAssets();
		gameIsPaused = false;
		menuScreenCalled = false;
		dialogScreenCalled = false;
		camera.setToOrtho(false, 16*16, 9*16);
		//gameStage.addActor(player);
		
		uiStage.addActor(new UITest());
	}

	@Override
	public void render(float delta) {
		camera.update();
		
		if(!gameIsPaused) {			//check if any screen other than the game screen is active
			Gdx.gl.glClearColor(0.5f, 0, 0, 0.5f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			batch.setProjectionMatrix(camera.combined);		//Test
			
			gameStage.draw();
			uiStage.draw();			//always after gameStage.draw()
			//TODO Delete this
			batch.begin();
			//batch.draw(test, 1, 1);
			batch.end();
			
		}
		
		menu();			//check if menu screen is called

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
		manager.finishLoading();;
		
		test = manager.get(Assets.testGif);		//test

	}
	
	/** ESC button, in-game menu */
	private void menu( ) {
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
		}
	}
	
	/** Dialog screen */
	private void dialog() {
		//TODO DialogStage
		//TODO Parameters
		if(gameIsPaused && dialogScreenCalled) {
			dialogStage.draw();
		}
	}

}
