import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fired extends JPanel
{ 
  public Fired()
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
    Image fired = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Fired.png");
    Image character = Toolkit.getDefaultToolkit ().getImage ("Characters/Fired" + CharacterSelect.character+".png");
    tracker.addImage (fired, 0); 
    tracker.addImage (character,1);
    g.drawImage (fired, 0, 0, this);
    g.drawImage(character, 430, 280,this);
    System.out.println(CharacterSelect.character);
    
  }
}