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
    Image fired = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Fired.png");
    Image character = Toolkit.getDefaultToolkit ().getImage ("Characters/Fired" + CharacterSelect.character+".png");
    tracker.addImage (fired, 0); 
    tracker.addImage (character,1);
    g.drawImage (fired, 0, 0, this);
    //put picture of character and write sentence
    g.drawImage(character, 0, 0,this);
    System.out.println(CharacterSelect.character);
    
  }
}