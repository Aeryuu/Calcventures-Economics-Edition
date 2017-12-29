import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConSurplus extends JPanel
{
  int counter = 1;

  public ConSurplus()
  {      
    addMouseListener(new MouseAdapter() {  //Will use when images have been photoshopped
      public void mousePressed(MouseEvent e) { 
        
        int relativeX = e.getX();
        int relativeY = e.getY();
//        
//        if (relativeX >= 749 && relativeX <= 981 && relativeY >= 584 && relativeY <= 659) //Next
//        {
//          if (counter != 6)
//          {
//            counter++;
//            repaint();
//          }
//          else
//          {
//            Driver.changeScreens("MainMenu");
//          }
//        }
//        else
//        {
//          if (relativeX >= 19 && relativeX <= 251 && relativeY >= 584 && relativeY <= 659) //Previous
//          {
//            if (counter != 1)
//            {
//              counter--;
//              repaint();
//            }
//          }
//        }
      } 
    }); 
  }
  
  public void paintComponent (Graphics g)
  {
    MediaTracker tracker = new MediaTracker (new Frame ());    
    Image conSurplus = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/ConSurplus" + counter + ".png");
    tracker.addImage (conSurplus, 0); 
    g.drawImage (conSurplus, 0, 0, null);
    repaint();
  }
}