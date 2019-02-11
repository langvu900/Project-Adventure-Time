/**
 * @Actor extended class to define buttons for title screen.
 */
package definitions.screen_utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.umu_jep.atime.AdTimeGame;
import com.umu_jep.atime.GameScreen;

public class TitleButton extends Actor{
	
	Texture texture;
	AdTimeGame game;
	Screen titelScreen;
	private boolean click = false;
	
	//TODO optimize individual functions
	public TitleButton(String name, float x, float y, Texture texture, AdTimeGame game, Screen titelScreen) {
		this.setName(name);
		this.setX(x);
		this.setY(y);
		this.texture = texture;
		this.game = game;
		this.titelScreen = titelScreen;
		this.setTouchable(Touchable.enabled);
		this.setBounds(x, y, texture.getWidth(), texture.getHeight());
		this.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				click = true;
				return true;
			}
		});
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(texture, this.getX(), this.getY());
	}
	
	@Override
	public void act(float delta) {
		if(click) {

			if(this.getName() == "start") {
				game.setScreen(new GameScreen(game));
				titelScreen.dispose();
			}
			//if(this.getName() == "option") game.setScreen(new TitleOptionScreen(game));;
			//TODO credit screen
			if(this.getName() == "exit") {
				Gdx.app.exit();
				titelScreen.dispose();
			}
		}

	}
}
