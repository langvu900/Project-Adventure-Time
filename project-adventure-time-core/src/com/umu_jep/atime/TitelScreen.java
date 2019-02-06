/**
 * Appears after the splash screen.
 */
package com.umu_jep.atime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import definitions.Assets;
import definitions.screen_utils.TitleButton;

public class TitelScreen implements Screen {
	
	AdTimeGame game;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private AssetManager manager;
	private Vector3 touch;
	private ExtendViewport viewport;
	
	private Rectangle startButton, optionButton, exitButton, creditButton;
	
	private Texture testGIF;
	private BitmapFont font;
	private Texture startTexture;
	private Stage input;
	
	public TitelScreen(AdTimeGame game) {
		this.game = game;
		
		//In-window coordinates
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);		//in.window resolution
		viewport = new ExtendViewport(1280, 720, camera);
		
		//Declarations
		batch = new SpriteBatch();
		manager = new AssetManager();
		touch = new Vector3();
		font = new BitmapFont();
		input = new Stage(viewport, batch);
	}

	@Override
	public void show() {
		loadAssets();
		
		startButton = new Rectangle(640, 360, 60, 40);

		Gdx.input.setInputProcessor(input);
		input.addActor(new TitleButton("start", 1280/2, 720/2, startTexture, game));
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);		//Sync with orthographic camera
				
		batch.begin();
		batch.draw(testGIF, 0, 0);
		font.draw(batch, "Start", 1280/2, 720/2);
		//batch.draw(startTexture, startButton.x, startButton.y);
		batch.end();
		input.draw();
		input.act();
		//checkInput();
		
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
		// TODO Auto-generated method stub
		batch.dispose();
		manager.dispose();
		font.dispose();
	}

	/**
	 * Non Libgdx methods
	 */
	
	/**Load assets from Assets.class*/
	private void loadAssets() {
		manager.load(Assets.testGif);
		manager.load(Assets.startTexture);
		
		manager.finishLoading();

		testGIF = manager.get(Assets.testGif);
		startTexture = manager.get(Assets.startTexture);

	}
	
	/**Check button clicked*/
	/*private void checkInput() {
		if(Gdx.input.isTouched()) {
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			if(startButton.x <= touch.x && startButton.y <= touch.y 
					&& touch.x <= startButton.x+startButton.width && touch.y <= startButton.y+startButton.height) {
				game.setScreen(new GameScreen(game));
				dispose();
			}
			
			if(optionButton.x <= touch.x && optionButton.y <= touch.y 
					&& touch.x <= optionButton.x+optionButton.getWidth() && touch.y <= optionButton.getY()+optionButton.getHeight()) {
				//game.setScreen(new TitleOptionScreen(game));
			}
			
			if(creditButton.x <= touch.x && creditButton.y <= touch.y 
					&& touch.x <= creditButton.x+creditButton.getWidth() && touch.y <= creditButton.getY()+creditButton.getHeight()) {
				//game.setScreen(new CreditScreen(game));
			}
			
			if(exitButton.x <= touch.x && exitButton.y <= touch.y 
					&& touch.x <= exitButton.x+exitButton.getWidth() && touch.y <= exitButton.getY()+exitButton.getHeight()) {
				Gdx.app.exit();
				dispose();
			}
		}
	}*/

}
