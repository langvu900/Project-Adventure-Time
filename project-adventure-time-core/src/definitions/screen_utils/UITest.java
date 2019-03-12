package definitions.screen_utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class UITest extends Actor{
	
	Texture ui;
	OrthographicCamera camera;

	public UITest(OrthographicCamera camera) {		//TODO parameter texture
		ui = new Texture(Gdx.files.internal("UI.png"));
		
		this.camera = camera;
		//this.setX(position.x);
		//this.setY(position.y);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(ui, camera.position.x - camera.viewportWidth/2 + 1, camera.position.y + camera.viewportHeight/2 - ui.getHeight());
	}
}
