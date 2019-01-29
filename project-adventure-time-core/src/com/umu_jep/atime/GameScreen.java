package com.umu_jep.atime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {

	AdTimeGame game;
	private boolean gameIsPaused;
	private SpriteBatch batch;
	private AssetManager manager;
	private Stage uiStage;
	private Stage gameStage;
	
	public GameScreen(AdTimeGame game) {
		this.game = game;
		batch = new SpriteBatch();
		manager = new AssetManager();
		//Gdx.gl.glEnable(GL20.GL_BLEND);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		gameIsPaused = true;
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		if(!gameIsPaused) {
			Gdx.gl.glClearColor(0.5f, 0, 0, 0.5f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		}
		
		menu();

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
		
	}
	
	/**
	 * Non Libgdx methods
	 * */
	
	/** ESC button, in-game menu */
	private void menu( ) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			if(!gameIsPaused) gameIsPaused = true;
			else gameIsPaused = false;
			//TODO MenuStage

		}
	}
	
	/** Dialog screen */
	private void dialog() {
		//TODO DialogStage
		//TODO Parameters
	}

}
