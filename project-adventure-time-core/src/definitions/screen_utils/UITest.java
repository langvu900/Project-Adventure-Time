package definitions.screen_utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import definitions.Assets;

public class UITest extends Actor{
	
	Texture startButton;

	public UITest() {
		startButton = new Texture(Gdx.files.internal("title/startButton.png"));
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(startButton, 2, 2);
		batch.draw(startButton, 16*16/2, 2, 16*3, 16*2, 0, 0, 60, 40, false, false);
	}
}
