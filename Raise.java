import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Raise extends JPanel
{ 
  public Raise()
  {        
    addMouseListener(new MouseAdapter() { 
      public void mousePressed(MouseEvent e) { 
        
        int relativeX = e.getX();
        int relativeY = e.getY();
        
        if (relativeX >= 130 && relativeX <= 215 && relativeY >= 500 && relativeY <= 553) //Go back to main menu
        {
            Driver.changeScreens("MainMenu");
        }
        else if (relativeX >= 130 && relativeX <= 215 && relativeY >= 500 && relativeY <= 553) //Go back to adventure choosing screen
        {
            Driver.changeScreens("AdventureSelect");
        }
      } 
    }); 
  }
  
  public void paintComponent (Graphics g)
  {
    MediaTracker tracker = new MediaTracker (new Frame ());    
    Image raise = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Raise.png");
    tracker.addImage (raise, 0); 
    g.drawImage (raise, 0, 0, this);
    //put picture of character and write sentence with name
  }
}