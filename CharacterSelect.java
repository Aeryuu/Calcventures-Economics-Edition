import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class CharacterSelect extends JPanel
{
  static String userName;
  static String character = "";  
  static boolean charSelected = false;
  
  public CharacterSelect ()
  {         
    addMouseListener(new MouseAdapter() { 
      public void mousePressed(MouseEvent e) { 
        int relativeX = e.getX();
        int relativeY = e.getY();
        
        if (relativeX >= 47 && relativeX <= 241 && relativeY >= 147 && relativeY <= 542)
        {
          character = "Blue";
          charSelected = true;
          System.out.println ("Blue");
        }
        else if (relativeX >= 283 && relativeX <= 478 && relativeY >= 147 && relativeY <= 542)
        {
          character = "Red";
          charSelected = true;  
        }
        else if (relativeX >= 522 && relativeX <= 717 && relativeY >= 147 && relativeY <= 542) 
        {
          character = "Orange";
          charSelected = true;  
        }
        else if (relativeX >= 757 && relativeX <= 952 && relativeY >= 147 && relativeY <= 542) 
        {
          character = "Green";
          charSelected = true;
        }
        else if (relativeX >= 815 && relativeX <= 974 && relativeY >= 598 && relativeY <= 662 && charSelected) //Next 
        {
          getUserName ("Enter Name", "Hello! Please enter your name.", new JFrame ());   
        }
        else if (relativeX >= 26 && relativeX <= 185 && relativeY >= 598 && relativeY <= 662) //Main menu
        {
          character = "";
          charSelected = false;
          Driver.changeScreens("MainMenu");
        }
      } 
    }); 
  }
  
   public void paint(Graphics graphics)
  {    
    MediaTracker tracker = new MediaTracker (new Frame ());    
    
    Image blue = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Character Select Blue.png");
    Image red = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Character Select Red.png");
    Image orange = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Character Select Orange.png");
    Image green = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Character Select Green.png");
    Image main = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Character Select.png");
    
    tracker.addImage (blue, 0);        
    tracker.addImage (red, 1);      
    tracker.addImage (orange, 2);   
    tracker.addImage (green, 3);   
    tracker.addImage (main, 4);   
    
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
    
    if (character.equals("Blue"))
    {
      graphics.drawImage (blue, 0, 0, null); 
    }
    else if (character.equals("Red"))
    {
      graphics.drawImage (red, 0, 0, null); 
    }
    else if (character.equals("Orange"))
    {
      graphics.drawImage (orange, 0, 0, null); 
    }
    else if (character.equals("Green"))
    {
      graphics.drawImage (green, 0, 0, null); 
    }
    else
    {
      graphics.drawImage (main, 0, 0, null); 
    }
    repaint();
  }
  
  public void getUserName(String title, String message, JFrame frame)
  {
    JDialog myDialog = new JDialog (frame, title);
    
    JTextField inputField = new JTextField (20);
    
    JLabel labelMessage = new JLabel (message);
    
    labelMessage.setFont (new Font ("Arial", Font.PLAIN, 16));
    
    myDialog.add (labelMessage);
    
    myDialog.add (inputField);
    
    myDialog.setResizable(false);
    
    myDialog.setSize (500, 100);
    
    myDialog.setLayout (new FlowLayout ());
    
    JButton enterName = new JButton ("Enter");
    
    enterName.addActionListener (new ActionListener ( )
                                   {      
      
      public void actionPerformed (ActionEvent e)
      {
        userName = inputField.getText ();
        if (userName.length() > 0 && userName.length() < 15)
        {          
          myDialog.dispose ();
          frame.dispose();
          Driver.changeScreens("Levels"); //this is gonna go to the adventure selection screen
        }
        else
        {
          inputField.setText ("The name must be 1-14 characters.");
        }
      }      
    }                                 
    ) ;   
    
    myDialog.add (enterName);
    
    myDialog.setLocationRelativeTo (frame);
    
    myDialog.setVisible (true);
    
  }
}