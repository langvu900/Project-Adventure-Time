package screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.umu_jep.atime.AdTimeGame;

public class TitelScreen implements Screen {
	
	AdTimeGame game;
	OrthographicCamera camera;
	
	public TitelScreen(AdTimeGame game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
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
		// TODO Auto-generated method stub
		
	}

}
