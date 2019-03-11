package definitions.screen_utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class UITest extends Actor{
	
	Texture startButton;
	OrthographicCamera camera;

	public UITest(OrthographicCamera camera) {		//TODO parameter texture
		//startButton = new Texture(Gdx.files.internal("nobu1.png"));
		
		this.camera = camera;
		//this.setX(position.x);
		//this.setY(position.y);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(startButton, camera.position.x - camera.viewportWidth/2 + 1, camera.position.y + camera.viewportHeight/2 - startButton.getHeight()/662*16*3, 16*3, 16*3, 0, 0, 662, 662, false, false);
	}
}
