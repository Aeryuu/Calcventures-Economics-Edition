import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver extends JFrame
{  
  static JFrame frame = new JFrame("Calcventures: Economics Edition"); 

  public Driver()
  {
    frame.setSize(1005, 708);
    frame.setResizable (false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.getContentPane().add(new SplashScreen());
    frame.setVisible(true);
    try
    {
      Thread.sleep (8000); 
    }
    catch (Exception e)
    {
    }
    frame.getContentPane().removeAll();    
    frame.getContentPane().add(new MainMenu());
    frame.setVisible(true);
  }
  
  public static void changeScreens(String className)
  {    
    try
    {
      Class<?> panel = Class.forName(className);
      JPanel newScreen = (JPanel) panel.newInstance();
      
      frame.getContentPane().removeAll();
      frame.getContentPane().add(newScreen);
      frame.revalidate();
      frame.setResizable (false);
    }
    catch (Exception e)
    {
    }
  }
 
  public static void main(String [] args)
  {
    RepaintManager.currentManager(null).setDoubleBufferingEnabled(true);
    new Driver();
  }  
}