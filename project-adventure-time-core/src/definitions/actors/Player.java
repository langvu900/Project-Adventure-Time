package definitions.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor{
	
	private String direction = "SOUTH";
	private float actorX = 0, actorY = 0; 
	private Texture sprite;
	
	public Player(String name, Texture sprite) {
		this.setName(name);
		this.sprite = sprite;
		
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(sprite, actorX, actorY);
	}

}
