package definitions.actors;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import definitions.actors.Player;

public class BaseNPC extends Actor {

	public float posX;
	public float posY;
	
	public int hp;				//Health Points of the NPC
	public int speed;			//Determines maximal movement range and movement speed
	public float sightRange;	//Determines range at which the NPC will interact with the player
	public int combatStyle;		//Determines if the NPC attacks in melee or ranged, or if it flees when attacked
	public float attackRange;	//Determines range at which teh NPC can deal damage to the player
	public String behaviour;	//Determines behaviour pattern for the NPC. 
								//Possible patterns are: melee, ranged, flee, neutral, follow
	
	public Player player;

	Texture sprite = new Texture("sprites/NPC_Placeholder.png");
	
	public BaseNPC(float posX, float posY, int hp, int speed, float sightRange, float attackRange, int combatStyle, String behaviour, Player player) {
		
		this.posX = posX;
		this.posY = posY;
		
		this.hp = hp;
		this.speed = speed;
		this.sightRange = sightRange;
		this.combatStyle = combatStyle;
		this.behaviour = behaviour;
		
		this.setBounds(this.getX(), this.getY(), sprite.getWidth(), sprite.getHeight());

		this.player = player;

		this.setPosition(posX, posY);
		System.out.println("NPC created at X = " + this.getX() + ", Y = " + this.getY());
	}
	
	public void wander() {
			
			//Determines idle movement as a fraction of maximum speed
			Random rng = new Random();
			
			if (detectPlayer(sightRange, player)) {
				
				this.takeAction(behaviour);
			}else {
				
				float destX = rng.nextFloat() * speed;
				float destY = rng.nextFloat() * speed;
				boolean boolX = rng.nextBoolean();
				boolean boolY = rng.nextBoolean();
				
				//Determines direction of idle movement
				if (boolX && boolY) {

					this.addAction(Actions.moveTo(this.getX() + destX, this.getY() + destY, speed));
				}else if (boolX && !boolY) {
					
					this.addAction(Actions.moveTo(this.getX() + destX, this.getY() - destY, speed));
				}else if(!boolX && boolY) {
					
					this.addAction(Actions.moveTo(this.getX() - destX, this.getY() + destY, speed));
				}else if(!boolX && !boolY) {
					
					this.addAction(Actions.moveTo(this.getX() - destX, this.getY() - destY, speed));
				}
			}
	}
	
	public void stationary() {
		
		if(!detectPlayer(sightRange, player)) {
			
			this.takeAction(behaviour);
		}
	}
	
	public boolean detectPlayer(float sightRange, Player player) {

		//Delays the initial reaction and the time between following reactions
		this.addAction(Actions.delay(10 - speed));
		
		//Determine absolute value of position difference
		float diffX = Math.abs(this.getX() - player.getX());
		float diffY = Math.abs(this.getY() - player.getY());
		
		//True, if distance to player is <= sightRange
		if (diffX <= sightRange || diffY <= sightRange) {
			
			System.out.println("Player detected at X = " + player.getX() + ", Y = " + player.getY());
			return true;
		}
		return false;
	}
	
	public void takeAction(String behaviour) {
		
		switch (behaviour) {
		
		case "melee": melee();
		
		case "ranged": ranged();
		
		case "flee": flee();
		
		case "neutral": neutral();
		
		case "follow": follow();
		}
	}
	
	public void melee() {
		
		System.out.println(">>>Engaging in melee combat");
		
		float enemyX = player.getX();
		float enemyY = player.getY();
		
		this.addAction(Actions.moveTo(enemyX, enemyY, speed));
		
		hit();
	}
	
	public void ranged() {
		
		System.out.println(">>>Engaging in ranged combat");
		
		float diffX = Math.abs(this.getX() - player.getX());
		float diffY = Math.abs(this.getY() - player.getY());
		
		//True, if distance to player is <= sightRange
		if (diffX <= attackRange/3) {
			
			moveAway("x");
		}
		if (diffY <= attackRange/3) {
			
			moveAway("y");
		}
		shoot();
	}
	
	public void flee() {
		
		System.out.println(">>>Attempting to flee");
		
		if (detectPlayer(sightRange/2, player)) {
			
			this.addAction(Actions.moveTo(moveAway("x"), moveAway("y"), speed));
		}
	}
	
	public float moveAway(String returnValue) {
		
		float enemyX = player.getX();
		float enemyY = player.getY();
		float destination = 0;
		
		if (returnValue == "x") {
			
			if (enemyX >= this.getX()) {
				
				destination =+ speed;
			}else {

				destination =- speed;
			}
		}else if (returnValue == "y") {
			
			if (enemyY >= this.getY()) {
				
				destination =+ speed;
			}else {

				destination =- speed;
			}
		}
		return destination;
	}
	
	public void neutral() {
		//Doesn't react on it's own, but reacts when attacked
		
		int startHP = hp;
		
		if (hp < startHP) {
			
			if(combatStyle == 1) {
				
				ranged();
			}else if(combatStyle == 2) {
				
				melee();
			}else {
				
				flee();
			}
		}
	}
	
	public void follow() {
		//Follow player while still keeping minimal distance
		
	}
	
	public void hit() {
		//Damages on contact with delay between attacks
		
	}
	
	public void shoot() {
		//Creates Projectile?
		
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
    	batch.draw(sprite, posX, posY);
	}
}
