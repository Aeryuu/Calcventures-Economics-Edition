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
        
        if (relativeX >= 28 && relativeX <= 148 && relativeY >= 581 && relativeY <= 658) //Go back to main menu
        {
            Driver.changeScreens("MainMenu");
        }
        else if (relativeX >= 853 && relativeX <= 973 && relativeY >= 581 && relativeY <= 658) //Go back to adventure choosing screen
        {
           AdventureSelect.adventure = "";
            Driver.changeScreens("AdventureSelect");
        }
      } 
    }); 
  }
  
  public void paintComponent (Graphics g)
  {
    MediaTracker tracker = new MediaTracker (new Frame ());    
    Image raise = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Raise.png");
    Image character = Toolkit.getDefaultToolkit ().getImage ("Characters/" + CharacterSelect.character+".png");
    tracker.addImage (raise, 0); 
    tracker.addImage(character,1);
    g.drawImage (raise, 0, 0, this);
    g.drawImage(character, 340, 355,this);
  }
}