
package com.umu_jep.atime;

import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Screen;

import screens.SplashScreen;
import screens.TitelScreen;

public class AdTimeGame extends Game {
	
	public TitelScreen titel;
	public SplashScreen splash;
	//private Screen test;

	@Override
	public void create() {
		
		titel = new TitelScreen(this);
		
	}
}
