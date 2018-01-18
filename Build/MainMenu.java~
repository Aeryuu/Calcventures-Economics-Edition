import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.sound.sampled.*;

public class MainMenu extends JPanel
{
  public MainMenu ()
  {
    AdventureSelect.adventure = ""; 
    try
    {
      BufferedImage image = ImageIO.read(new File("Backgrounds/Main Menu.png"));
      JLabel picLabel = new JLabel(new ImageIcon(image));
      add(picLabel);
    }
    catch (IOException e)
    {
    }   
    
    //Goes to a different screen depending on what the user chooses
    addMouseListener(new MouseAdapter() { 
      public void mousePressed(MouseEvent e) { 
        
        int relativeX = e.getX();
        int relativeY = e.getY();
        
        System.out.println (relativeX + " " + relativeY);
        
        if (relativeX >= 105 && relativeX <= 404 && relativeY >= 226 && relativeY <= 421)
        {
          Driver.changeScreens("CharacterSelect");
        }
        else if (relativeX >= 591 && relativeX <= 892 && relativeY >= 266 && relativeY <= 421)
        {
          Driver.changeScreens("Instructions");
          System.out.println ("Instructions screen");
        }
        else if (relativeX >= 904 && relativeX <= 980 && relativeY >= 604 && relativeY <= 668)
        {
          System.exit(0);
        }
      }      
    });          
  }
}