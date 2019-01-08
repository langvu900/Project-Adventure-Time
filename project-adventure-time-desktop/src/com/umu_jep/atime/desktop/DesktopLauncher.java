package com.umu_jep.atime.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.umu_jep.atime.AdTimeGame;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Adventure Time!";
		config.width = 800;
		config.height = 600;
		
		new LwjglApplication(new AdTimeGame(), config);
	}
}
