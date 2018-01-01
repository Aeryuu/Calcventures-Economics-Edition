import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** 
 * This class opens an image.
 */

public class SplashScreen extends JPanel
{
  
  /**
   * This is the class constructor.
   */ 
  public SplashScreen() 
  {
  }
  
  /**
   * This method reads in the splashscreen background from a folder and draws it
   * onto the screen. The try catch block is there to prevent the program from
   * crashing if the image is not found.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>tracker </b> This is a reference variable that points to the MediaTracker 
   * <p>
   * <b>background </b> This stores the image that is displayed.
   * <p>
   * <b>Exceptions: </b>
   *  <p>
   * <b>e </b> Of type InterruptedException, this is caught in case of an interruption, when reading the image from a file.
   * @param graphics This is needed to draw the image onto the screen
   */ 
  public void paint(Graphics graphics)
  {    
    MediaTracker tracker = new MediaTracker (new Frame ());    
    Image background = Toolkit.getDefaultToolkit ().getImage ("resources/Images/Backgrounds/Splashscreen.png");
    tracker.addImage (background, 0);        
    try
    {
      tracker.waitForAll ();
    }
    catch (InterruptedException e)
    {
    }
    if (tracker.isErrorAny ())
    {
      return;
    }
    
    graphics.drawImage (background, 0, 0, 1000, 675, null);
  }
}