 
package  org;
 
 
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
 
 
 
public class BitmapFontTest extends SimpleApplication  implements ActionListener {

  
    
  BitmapText hintText;  
  BitmapText debugText; 
  boolean enabled=true;
  
 public   BitmapFontTest()
    {
        
    }
    
    @Override
    public void simpleInitApp() {
        
        //No stats
        setDisplayStatView(false);
        setDisplayFps(true);
        flyCam.setEnabled(false);
        //Background color
        viewPort.setBackgroundColor(ColorRGBA.Black);
            
        //Keys
        inputManager.addMapping("StrInc", new KeyTrigger(KeyInput.KEY_SPACE));
         inputManager.addListener(this, new String[]{"StrInc"});
          
        //Text
        BitmapFont font =  getAssetManager().loadFont("Interface/Fonts/Dejavu/eng_dejavu_lens.fnt");
	// BitmapFont font =  getAssetManager().loadFont("Interface/Fonts/Saira/eng_saira_cartoon.fnt");
	// BitmapFont font =  getAssetManager().loadFont("Interface/Fonts/Xolonium/eng_xolonium_flash.fnt");
	//BitmapFont font =  getAssetManager().loadFont("Interface/Fonts/Jellee/eng_jellee_bright.fnt");
	//BitmapFont font =  getAssetManager().loadFont("Interface/Fonts/Sulphur/eng_sulphur_blood.fnt");
	
         
         
         float fontSize = this.getCamera().getHeight()/13;
        float marginX = this.getCamera().getHeight()/25;
        float marginY = marginX/2.5f;
        //Text
	  
        BitmapText no1= buildLine(font,fontSize,"LOREM IPSUM DOLOR SIT AMET",  (int)marginX, (int)(this.getCamera().getHeight()-marginY ));
        BitmapText no2= buildLine(font,fontSize,"consectetur adipiscing elit, sed do ",  (int)marginX, (int)(no1.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no3= buildLine(font,fontSize,"EIUSMOD TEMPOR INCIDIDUNT UT ",  (int)marginX, (int)(no2.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no4= buildLine(font,fontSize,"labore et dolore magna aliqua.",  (int)marginX, (int)(no3.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no5= buildLine(font,fontSize,"UT ENIM AD MINIM VENIAM",  (int)marginX, (int)(no4.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no6= buildLine(font,fontSize,"quis nostrud exercitation ullamco",  (int)marginX, (int)(no5.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no7= buildLine(font,fontSize,"LABORIS nisi ut ALIQUIP ex ea",  (int)marginX, (int)(no6.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no8= buildLine(font,fontSize,"commodo consequat. Duis aute",  (int)marginX, (int)(no7.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no9= buildLine(font,fontSize,"IRURE dolor IN reprehenderit in",  (int)marginX, (int)(no8.getLocalTranslation().y-marginY-fontSize ));
        BitmapText no10= buildLine(font,fontSize,"voluptate VELIT esse CILLUM dolore",  (int)marginX, (int)(no9.getLocalTranslation().y-marginY-fontSize ));
       
        
         
      }
    
  BitmapText buildLine( BitmapFont font, float fontSize, String text, int posX, int posY)
  {
         BitmapText  label = new BitmapText(font);
	label.setSize(fontSize);
	label.setText(text);
	label.setLocalTranslation(posX, posY, 1.0f);
         guiNode.attachChild(label);
       
        return label;
	
  }
  /** Start the jMonkeyEngine application */
  public static void main(String[] args) {
       
        BitmapFontTest app = new BitmapFontTest();
         app.start();
     
  }

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
       
        
        if(!isPressed)
            return;
       
        if(name.equals("StrInc"))
        {
          
           enabled=!enabled;
           refreshDisplay();
	    //
         
        }
         
       
    }
void refreshDisplay()
  {
    debugText.setText("Enabled:"+enabled );
	  
  }    
    
}
