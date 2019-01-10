package com.umu_jep.atime.desktop;

//import java.awt.Dimension;
//import java.awt.Toolkit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.umu_jep.atime.AdTimeGame;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		config.title = "Adventure Time!";
		
		Gdx.graphics.setWindowedMode(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); //causes NullPointerException
		//Gdx.graphics.setWindowedMode((int) screenSize.getWidth(), (int) screenSize.getHeight()); //causes NullPointerException as well
		//probably caused by setWindowedMode()
		
		new LwjglApplication(new AdTimeGame(), config);
	}
}
