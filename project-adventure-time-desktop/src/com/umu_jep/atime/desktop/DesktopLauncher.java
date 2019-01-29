package com.umu_jep.atime.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.umu_jep.atime.AdTimeGame;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Adventure Time!";
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		
		config.width = (int) dim.getWidth();
		config.height = (int) dim.getHeight();
		
		new LwjglApplication(new AdTimeGame(), config);
	}
}
