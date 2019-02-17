/** This is where all initial objects are constructed.
 * 
 * Put the load() method into the main game class (AdTimeGame) to run.
 * 
 * To creators: comment for each object is vital! */

package definitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Assets {
	
	/**public static Sprite backgroundSprite;*/
	
	//public static final String testGIF = ;
	  public static final AssetDescriptor<Texture> testGif = new AssetDescriptor<Texture>("transtest.gif", Texture.class);
	  public static final AssetDescriptor<Texture> startTexture = new AssetDescriptor<Texture>("title/startButton.png", Texture.class);
	  public static final AssetDescriptor<Texture> testUI = new AssetDescriptor<Texture>("SpriteJep.png", Texture.class);
	  public static final AssetDescriptor<Texture> testBackground = new AssetDescriptor<Texture>("background/test1.jpg", Texture.class);
	  
	  /**Maps*/
	  public static final AssetDescriptor<TiledMap> testMap = new AssetDescriptor<TiledMap>("TutorialMap.tmx", TiledMap.class);
	  	
	  //public static final AssetDescriptor<Texture> playerSprite = new AssetDescriptor<Texture>("sprites/", Texture.class);

	
	/** Loads all objects below 
	public static void load() {

		//Title screen:
			//Background
		Texture backgroundTexture = new Texture(Gdx.files.internal("SpriteJEP.png"));
		backgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		backgroundSprite = new Sprite(backgroundTexture);
			
	}*/

	  
	  
}