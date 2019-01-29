package com.umu_jep.atime;

import com.badlogic.gdx.Screen;

public class SplashScreen implements Screen {
	
	AdTimeGame game;
	
	public SplashScreen(AdTimeGame game) {
		this.game = game;
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		//TODO splash animation
		
		game.setScreen(new TitelScreen(game));
		
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
