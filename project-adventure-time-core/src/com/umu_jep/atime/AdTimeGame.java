package com.umu_jep.atime;

import com.badlogic.gdx.Game;

/**import asset.Assets;
import com.badlogic.gdx.Screen;*/

public class AdTimeGame extends Game {
	
	@Override
	public void create() {
		
		//sAssets.load();

		setScreen(new SplashScreen(this));
		
	}
}
