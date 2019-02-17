package com.umu_jep.atime.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.umu_jep.atime.AdTimeGame;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "JEP's Adventure Time";
		config.width = 1280;
		config.height = 720;
		config.resizable = false;

		new LwjglApplication(new AdTimeGame(), config);
	}
}
