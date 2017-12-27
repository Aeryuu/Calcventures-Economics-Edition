import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the basic driver class, for the Calcventures: Economics Edition game. It uses a static method for changing classes through
 * gameplay.
 * Note that since javadoc is not picking up caught exceptions, we included the exceptions in the local
 * variables.
 */
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
  
  /**
   * The static changescreens method.
   * Allows a new class to be called and implemented to the frame during gamelplay.
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>panel </b> This creates of a class with the name className passed in by a string.
   * <p>
   * <b>newScreen </b> This creates a JPanel for the new class to be displayed on. 
   * <p>
   * <b>e </b> Of type Exception, it is used when creating the new classes.
   * 
   * @param className String is a string that passes the class name that the program wants to change to.
   * */  
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
  
  /**
   * This method is the main method that runs the program.
   * It sets the output window to a double buffer.
   * 
   * @param args is a String [] for the main method parameters.
   */  
  public static void main(String [] args)
  {
    RepaintManager.currentManager(null).setDoubleBufferingEnabled(true);
    new Driver();
  }  
}