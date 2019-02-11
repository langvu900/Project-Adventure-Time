/**
 * @Actor extended class to define buttons for menu in game screen.
 */
package definitions.screen_utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.umu_jep.atime.AdTimeGame;
import com.umu_jep.atime.GameScreen;

public class GameMenuButtons extends Actor {
	
	Texture texture;
	Vector3 position;
	//private boolean click = false;

	//TODO optimize individual function
	public GameMenuButtons(final String name, OrthographicCamera camera, Texture texture, final AdTimeGame game, final GameScreen screen) {
		position = camera.position;
		this.texture = texture;
		this.setBounds(this.getX(), this.getY(), texture.getWidth(), texture.getHeight());
		this.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					if(name == "resume") {
						screen.menuScreenCalled = false;
						if(!screen.dialogScreenCalled) screen.gameIsPaused = false;
						//click = false;
					}
					//if(this.getName() == "option") game.setScreen(new TitleOptionScreen(game));;
					//TODO credit screen
					if(name == "exit") {
						Gdx.app.exit();
						screen.dispose();
					}
					return false;
			}
		});
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		this.setX(position.x);
		this.setY(position.y);
		batch.draw(texture, this.getX(), this.getY());
	}

}
