package com.umu_jep.atime.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.umu_jep.atime.AdTimeGame;
/*import com.umu_jep.atime.AdTimeGameDefault;*/

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "JEP's Adventure Time";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new AdTimeGame(), config);
	}
}
