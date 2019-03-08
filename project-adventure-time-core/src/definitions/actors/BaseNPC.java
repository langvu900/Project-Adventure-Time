package definitions.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import definitions.actors.Player;

public class BaseNPC extends Actor {

	public int hp;
	public int speed;
	public float range;
	
	public Player player;

	Texture sprite = new Texture("sprites/NPC_Placeholder.png");
	
	public BaseNPC(int hp, int speed, float range, Player player) {

		this.hp = hp;
		this.speed = speed;
		this.range = range;
		
		this.setBounds(this.getX(), this.getY(), sprite.getWidth(), sprite.getHeight());
		
		this.player = player;
	}
	
	public void wander() {
		
		while(!detectPlayer(range, player)) {
			
			float destX = (float) Math.random() * speed;
			float destY = (float) Math.random() * speed;
			
			this.moveBy(destX, destY);
		}
	}
	
	public boolean detectPlayer(float range, Player player) {
		
		//Determine absolute value of position difference
		float diffX = Math.abs(this.getX() - player.getX());
		float diffY = Math.abs(this.getY() - player.getY());
		
		//True, if distance to player is <= range
		if (diffX <= range || diffY <= range) {
			
			return true;
		}
		return false;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
    	batch.draw(sprite, this.getX(), this.getY());
	}
}
