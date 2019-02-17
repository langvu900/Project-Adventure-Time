package definitions.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor{
	
	private String direction = "SOUTH";
	private Texture sprite;
	
	public Player(String name, Texture sprite) {
		this.setName(name);
		this.sprite = sprite;
		this.setBounds(this.getX(), this.getY(), sprite.getWidth(), sprite.getHeight());
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(sprite, this.getX(), this.getY());
	}
	
}
