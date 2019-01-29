/** This is where all initial objects are constructed.
 * 
 * Put the load() method into the main game class (AdTimeGame) to run.
 * 
 * To creators: comment for each object is vital! */

package asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
	
	/**public static Sprite backgroundSprite;*/
	
	//public static final String testGIF = ;
	  public static final AssetDescriptor<Texture> testGif = new AssetDescriptor<Texture>("transtest.gif", Texture.class);
	  public static final AssetDescriptor<Texture> startTexture = new AssetDescriptor<Texture>("title/startButton.png", Texture.class);

	
	/** Loads all objects below 
	public static void load() {

		//Title screen:
			//Background
		Texture backgroundTexture = new Texture(Gdx.files.internal("SpriteJEP.png"));
		backgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		backgroundSprite = new Sprite(backgroundTexture);
			
	}*/

}