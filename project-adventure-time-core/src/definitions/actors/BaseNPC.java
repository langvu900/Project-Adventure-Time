package definitions.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import ai.Routine;

public class BaseNPC extends Actor {
	
	final String name;
	float posX;
	float posY;
	float moveSpeed;
	float range;
	int hp;
	int damage;

	private Stage stage;
	Routine routine;
	
	Texture texture = new Texture("sprites/NPC_Placeholder.png");
	
	public BaseNPC(String name, Stage stage, float posX, float posY, float moveSpeed, float range, int hp, int damage) {
		
		this.name = name;
		this.stage = stage;
		this.posX = posX;
		this.posY = posY;
		this.moveSpeed = moveSpeed;
		this.range = range;
		this.hp = hp;
		this.damage = damage;
	}
	
	public int getHP() {
		
		return hp;
	}
	
	public boolean isAlive() {
		
		if (hp <= 0) {
			
			return true;
		}
		return false;
	}
    
    public float getMoveSpeed() {
    	
    	return moveSpeed;
    }
    
    public void update() {
    	
    	if(routine.getState() == null) {
    		
    		routine.start();
    	}
    	routine.act(this, stage);
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
    	batch.draw(texture, posX, posY);
    }
}
