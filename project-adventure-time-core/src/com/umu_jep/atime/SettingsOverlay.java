package com.umu_jep.atime;

import java.awt.Checkbox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SettingsOverlay{
	
	private Stage settingsStage;
	
	public void create() {
		
		settingsStage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(settingsStage);
		
		Checkbox windowMode  = new Checkbox("Fullscreen");
		//settingsStage.addActor(windowMode);
	}
	
	public void render() {
		
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		settingsStage.act();
		settingsStage.draw();
	}
	
}
