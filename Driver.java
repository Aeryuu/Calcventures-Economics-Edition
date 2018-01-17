import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver extends JFrame
{  
    static JFrame frame = new JFrame("Calcventures: Economics Edition"); 
    static ImageIcon raiseIcon = new ImageIcon("Icons/Raise.png"), firedIcon = new ImageIcon("Icons/Fired.png");
    
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
    
    public static void dialogBox(int whichBox)//0 if raise, 1 if correct,2 if fired
    {    
        if(whichBox == 0)
        {
            JOptionPane.showMessageDialog(null,"You chose the right answer!", "You did it!", JOptionPane.INFORMATION_MESSAGE,raiseIcon);
            changeScreens("Raise");
        }
        else if(whichBox == 1)
            JOptionPane.showMessageDialog(null,"You chose the right answer!", "You did it!", JOptionPane.INFORMATION_MESSAGE); 
        else
        {
            JOptionPane.showMessageDialog(null, "You chose the wrong answer!", "Oh no!", JOptionPane.INFORMATION_MESSAGE,firedIcon);
            changeScreens("Fired");
        }
    }
    
    public static void main(String [] args)
    {
        RepaintManager.currentManager(null).setDoubleBufferingEnabled(true);
        new Driver();
    }  
}