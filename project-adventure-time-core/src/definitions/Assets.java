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
	/** Title screen */
	  public static final AssetDescriptor<Texture> JasAdventure = new AssetDescriptor<Texture>("title/Jas Adventure.png", Texture.class);
	  public static final AssetDescriptor<Texture> JasTitlescreen = new AssetDescriptor<Texture>("title/JasTransparent.png", Texture.class);
	  public static final AssetDescriptor<Texture> testGif = new AssetDescriptor<Texture>("transtest.gif", Texture.class);
	  public static final AssetDescriptor<Texture> startTexture = new AssetDescriptor<Texture>("title/Start.png", Texture.class);
	  
	/** UI */
	  //public static final AssetDescriptor<Texture> testUI = new AssetDescriptor<Texture>("nobu1.png", Texture.class);
	  public static final AssetDescriptor<Texture> testBackground = new AssetDescriptor<Texture>("background/test1.jpg", Texture.class);
	  
	/** Sprites */
	  public static final AssetDescriptor<Texture> playerSprite = new AssetDescriptor<Texture>("SpriteJEP.png", Texture.class);
	  
	/** Maps */
	  public static final AssetDescriptor<TiledMap> testMap = new AssetDescriptor<TiledMap>("maps/TutorialMap2.tmx", TiledMap.class);

	
	/** Loads all objects below 
	public static void load() {

		//Title screen:
			//Background
		Texture backgroundTexture = new Texture(Gdx.files.internal("SpriteJEP.png"));
		backgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		backgroundSprite = new Sprite(backgroundTexture);
			
	}*/

	  
	  
}