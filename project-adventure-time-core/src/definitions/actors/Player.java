package definitions.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.umu_jep.atime.GameScreen;

public class Player extends Actor{
	
	private static final int FRAME_COLS = 4, FRAME_ROWS = 4;
	
	Animation<TextureRegion> jasAnimation;
	Texture sheet;
	SpriteBatch spritebatch;	
	float time;
	
	
	private String direction = "SOUTH";
	private Texture sprite;
	//private float speed = GameScreen.SPEED;
	//private OrthographicCamera camera;
	//private float mapHeight, mapWidth;
	private Rectangle boundRect;
	TextureRegion currentFrame;
	TextureRegion[] tregionFore, tregionRight, tregionBack, tregionLeft;

	public static Animation<TextureRegion> jasAnimationSouth, jasAnimationEast, jasAnimationNorth, jasAnimationWest;
	
	public Player(String name, Texture sprite) {
		this.setName(name);
		this.sprite = sprite;
		this.setBounds(this.getX(), this.getY(), sprite.getWidth(), sprite.getHeight());
		//this.mapHeight = GameScreen.prop.get("height", Integer.class) * GameScreen.prop.get("tileheight", Integer.class);
		//this.mapWidth = GameScreen.prop.get("width", Integer.class) * GameScreen.prop.get("tilewidth", Integer.class);
		boundRect = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		animation();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		/*//Move right
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			for(RectangleMapObject rectangleObject : GameScreen.mapCollision.getByType(RectangleMapObject.class)) {
				if(this.getRight() <= mapWidth && !rectangleObject.getRectangle().overlaps(new Rectangle(this.getX()+1, this.getY(), this.getWidth(), 10))) {
					if(this.getX()+this.getWidth()/2 == GameScreen.camera.position.x && mapWidth >= GameScreen.camera.position.x + GameScreen.camera.viewportWidth/2 + 1) GameScreen.camera.translate(1*GameScreen.SPEED,0);
					this.moveBy(1*GameScreen.SPEED, 0);
				}
			}
			if(direction != "EAST") direction = "EAST";
		}
		
		//Move left
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			for(RectangleMapObject rectangleObject : GameScreen.mapCollision.getByType(RectangleMapObject.class)) {
				if(this.getX() >= 0 && !rectangleObject.getRectangle().overlaps(new Rectangle(this.getX()-1, this.getY(), this.getWidth(), 10))) {
					if(this.getX()+this.getWidth()/2 == GameScreen.camera.position.x && 0 <= GameScreen.camera.position.x - GameScreen.camera.viewportWidth/2 - 1) GameScreen.camera.translate(-1*GameScreen.SPEED,0);
					this.moveBy(-1*GameScreen.SPEED, 0);
				}
			}
			if(direction != "WEST") direction = "WEST";
		}
		
		//Move up
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			for(RectangleMapObject rectangleObject : GameScreen.mapCollision.getByType(RectangleMapObject.class)) {
				if(this.getTop() <= mapHeight && !rectangleObject.getRectangle().overlaps(new Rectangle(this.getX(), this.getY()+1, this.getWidth(), 11))) {
					if(this.getY()+this.getHeight()/2 == GameScreen.camera.position.y && mapHeight >= GameScreen.camera.position.y + GameScreen.camera.viewportHeight/2 + 1) GameScreen.camera.translate(0,1*GameScreen.SPEED);
					this.moveBy(0, 1*GameScreen.SPEED);
				}
			}
			if(direction != "NORTH") direction = "NORTH";
		}
		
		//Move down
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			for(RectangleMapObject rectangleObject : GameScreen.mapCollision.getByType(RectangleMapObject.class)) {
				if(this.getY() >= 0 && !rectangleObject.getRectangle().overlaps(new Rectangle(this.getX(), this.getY()-1, this.getWidth(), 10))) {
					if(this.getY()+this.getHeight()/2 == GameScreen.camera.position.y && 0 <= GameScreen.camera.position.y - GameScreen.camera.viewportHeight/2 - 1) GameScreen.camera.translate(0,-1*GameScreen.SPEED);	
					this.moveBy(0, -1*GameScreen.SPEED);
				}
			}
			if(direction != "SOUTH") direction = "SOUTH";
		}*/
		time += Gdx.graphics.getDeltaTime();
		
		if(direction == "SOUTH") currentFrame = jasAnimationSouth.getKeyFrame(time, true);
		if(direction == "EAST") currentFrame = jasAnimationEast.getKeyFrame(time, true);
		if(direction == "NORTH") currentFrame = jasAnimationNorth.getKeyFrame(time, true);
		if(direction == "WEST") currentFrame = jasAnimationWest.getKeyFrame(time, true);

		if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.W)) 
			batch.draw(currentFrame, this.getX(), this.getY());
		else batch.draw(getStillSprite(direction), this.getX(), this.getY());
		
	}

	public Rectangle getRectangle() {
		return boundRect;
	}
	
	public void setDirection(String direction) {
		if((direction == "NORTH" || direction == "SOUTH" || direction == "WEST" || direction == "EAST") && this.direction != direction) this.direction = direction;
	}

	private TextureRegion getStillSprite(String direction) {
		if(direction == "SOUTH") return tregionFore[0];
		else if(direction == "EAST") return tregionRight[0];
		else if(direction == "NORTH") return tregionBack[0];
		else return tregionLeft[0];
	}

	
	public void animation(){
		sheet = new Texture(Gdx.files.internal("sprites/JasSprites.png"));
		
		TextureRegion[][] tmp = TextureRegion.split(sheet,
				sheet.getWidth() / FRAME_COLS, 
				sheet.getHeight() / FRAME_ROWS);
		
		 tregionFore = new TextureRegion[4];
		 tregionRight = new TextureRegion[4];
		 tregionBack = new TextureRegion[4];
		 tregionLeft = new TextureRegion[4];
		
		int index = 0;
		
		for (int j = 0; j < FRAME_COLS; j++) {
			tregionFore[index++] = tmp[0][j];
		} index = 0;
			
		for (int j = 0; j < FRAME_COLS; j++) {
			tregionRight[index++] = tmp[1][j];
		} index = 0;
	
		for (int j = 0; j < FRAME_COLS; j++) {
			tregionBack[index++] = tmp[2][j];
		} index = 0;
					
		for (int j = 0; j < FRAME_COLS; j++) {
			tregionLeft[index++] = tmp[3][j];
		}
		
		jasAnimationSouth = new Animation<TextureRegion>(0.075f, tregionFore);
		jasAnimationEast = new Animation<TextureRegion>(0.075f, tregionRight);
		jasAnimationNorth = new Animation<TextureRegion>(0.075f, tregionBack);
		jasAnimationWest = new Animation<TextureRegion>(0.075f, tregionLeft);

		time = 0f;

	 }
}
	
