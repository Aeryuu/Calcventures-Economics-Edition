import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplashScreen extends JPanel
{
  
  public SplashScreen() 
  {
  }
  
  public void paint(Graphics graphics)
  {    
    MediaTracker tracker = new MediaTracker (new Frame ());    
    Image background = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Splashscreen.png");
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