import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConSurplus extends JPanel
{
  int counter = 1;

  public ConSurplus()
  {      
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) { 
        
        int relativeX = e.getX();
        int relativeY = e.getY();
        
        System.out.println (relativeX + " " + relativeY);
        
        if (relativeX >= 832 && relativeX <= 916 && relativeY >= 548 && relativeY <= 601 && counter != 4 && counter != 6) //Next
        {
            counter++;
            repaint();
        }
        
        if (counter == 1)
        {
          //output the equation of the demand curve onto the screen
        }
        else if (counter == 2)
        {
          //output the value of the sales level onto the screen
        }
        else if (counter == 4) //Mission 1
        {
          //Paste in all of the math code, output demand curve equation, sales level, and four different selling prices onto the screen
          
          if (relativeX >= 601 && relativeX <= 868 && relativeY >= 257 && relativeY <= 304) //First choice
          {
            //if answer is correct --> output a textbox telling them they are correct, counter++, repaint();
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
          else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 336 && relativeY <= 382) //Second choice
          {
            //if answer is correct --> output a textbox telling them they are correct, counter++, repaint();
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
          else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 417 && relativeY <= 465) //Third choice
          {
            //if answer is correct --> output a textbox telling them they are correct, counter++, repaint();
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
          else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 498 && relativeY <= 545) //Last choice
          {
            //if answer is correct --> output a textbox telling them they are correct, counter++, repaint();
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
        }
        else if (counter == 6) //Mission 2
        {
          //Paste in all of the math code, output demand curve equation, sales level, selling price, and four possible answers onto the screen
          if (relativeX >= 601 && relativeX <= 868 && relativeY >= 257 && relativeY <= 304) //First choice
          {
            //if answer is correct --> output a textbox telling them they are correct, Driver.changeScreens("Raise");
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
          else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 336 && relativeY <= 382) //Second choice
          {
            //if answer is correct --> output a textbox telling them they are correct, Driver.changeScreens("Raise");
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
          else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 417 && relativeY <= 465) //Third choice
          {
            //if answer is correct --> output a textbox telling them they are correct, Driver.changeScreens("Raise");
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
          else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 498 && relativeY <= 545) //Last choice
          {
            //if answer is correct --> output a textbox telling them they are correct, Driver.changeScreens("Raise");
            //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
          }
        }        
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