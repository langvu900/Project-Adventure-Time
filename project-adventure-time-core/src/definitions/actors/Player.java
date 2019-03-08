package definitions.actors;

//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.umu_jep.atime.GameScreen;

public class Player extends Actor{
	
	private String direction = "SOUTH";
	private Texture sprite;
	//private float speed = GameScreen.SPEED;
	//private OrthographicCamera camera;
	//private float mapHeight, mapWidth;
	private Rectangle boundRect;
	
	public Player(String name, Texture sprite) {
		this.setName(name);
		this.sprite = sprite;
		this.setBounds(this.getX(), this.getY(), sprite.getWidth(), sprite.getHeight());
		//this.mapHeight = GameScreen.prop.get("height", Integer.class) * GameScreen.prop.get("tileheight", Integer.class);
		//this.mapWidth = GameScreen.prop.get("width", Integer.class) * GameScreen.prop.get("tilewidth", Integer.class);
		boundRect = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
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
		
		batch.draw(sprite, this.getX(), this.getY());
	}

	public Rectangle getRectangle() {
		return boundRect;
	}
	
	public void setDirection(String direction) {
		if((direction == "NORTH" || direction == "SOUTH" || direction == "WEST" || direction == "EAST") && this.direction != direction) this.direction = direction;
	}
}
