import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions extends JPanel
{
  Image instructions;
  int counter = 1;
  
  public Instructions()
  {        
    addMouseListener(new MouseAdapter() { 
      public void mousePressed(MouseEvent e) { 
        
        int relativeX = e.getX();
        int relativeY = e.getY();
        
        if (relativeX >= 130 && relativeX <= 215 && relativeY >= 500 && relativeY <= 553) //Previous
        {
          if (counter != 1)
          {
            counter--;
            repaint();
          }
          else
          {
            Driver.changeScreens("MainMenu");
          }
        }
        else
        {
          if (relativeX >= 786 && relativeX <= 870 && relativeY >= 500 && relativeY <= 553) //Next
          {
            if (counter != 4)
            {
              counter++;
              repaint();
            }
          }
        }
      } 
    }); 
  }
  
  public void paintComponent (Graphics g)
  {
    MediaTracker tracker = new MediaTracker (new Frame ());    
    instructions = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Instructions" + counter + ".png");
    tracker.addImage (instructions, 0); 
    g.drawImage (instructions, 0, 0, this);
  }
}