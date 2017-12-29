import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class AdventureSelect extends JPanel
{
  static String adventure = "";  

  public AdventureSelect ()
  {         
    addMouseListener(new MouseAdapter() { 
      public void mousePressed(MouseEvent e) { 
        int relativeX = e.getX();
        int relativeY = e.getY();
        
        if (relativeX >= 52 && relativeX <= 286 && relativeY >= 109 && relativeY <= 327)
        {
          adventure = "ConSurplus";
          System.out.println (adventure);
        }
        else if (relativeX >= 52 && relativeX <= 286 && relativeY >= 353 && relativeY <= 572)
        {
          adventure = "ProSurplus";
          System.out.println (adventure);
        }
        else if (relativeX >= 383 && relativeX <= 617 && relativeY >= 109 && relativeY <= 327) 
        {
          adventure = "MargRevenue";
          System.out.println (adventure);
        }
        else if (relativeX >= 383 && relativeX <= 617 && relativeY >= 353 && relativeY <= 572) 
        {
          adventure = "MargCost";
          System.out.println (adventure);
        }
        else if (relativeX >= 713 && relativeX <= 974 && relativeY >= 109 && relativeY <= 327)
        {
          adventure = "MargProfit";  
          System.out.println (adventure);
        }
        else if (relativeX >= 713 && relativeX <= 974 && relativeY >= 353 && relativeY <= 572)
        {
          adventure = "NetInvestFlow";  
          System.out.println (adventure);
        }
        else if (relativeX >= 421 && relativeX <= 579 && relativeY >= 598 && relativeY <= 662) //Main menu
        {
          adventure = "";
          Driver.changeScreens("MainMenu");
        }
      } 
    }); 
  }
  
   public void paint(Graphics graphics)
  {    
    MediaTracker tracker = new MediaTracker (new Frame ());    
    
//    Image a = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select ConSurplus.png");
//    Image b = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select ProSurplus.png");
//    Image c = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select MargRevenue.png");
//    Image d = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select MargCost.png");
//    Image e = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select MargProfit.png");
//    Image f = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select NetInvestFlow.png");
    Image main = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select.png");
    
//    tracker.addImage (a, 0);        
//    tracker.addImage (b, 1);      
//    tracker.addImage (c, 2);   
//    tracker.addImage (d, 3);  
//    tracker.addImage (e, 4);   
//    tracker.addImage (f, 5);  
    tracker.addImage (main, 6);   
    
    try
    {
      tracker.waitForAll ();
    }
    catch (InterruptedException i)
    {
    }
    if (tracker.isErrorAny ())
    {
      return;
    }
    
//    if (adventure.equals("ConSurplus"))
//    {
//      graphics.drawImage (a, 0, 0, null); 
//    }
//    else if (adventure.equals("ProSurplus"))
//    {
//      graphics.drawImage (b, 0, 0, null); 
//    }
//    else if (adventure.equals("MargRevenue"))
//    {
//      graphics.drawImage (c, 0, 0, null); 
//    }
//    else if (adventure.equals("MargCost"))
//    {
//      graphics.drawImage (d, 0, 0, null); 
//    }
//    else if (adventure.equals("MargProfit"))
//    {
//      graphics.drawImage (e, 0, 0, null); 
//    }
//    else if (adventure.equals("NetInvestFlow"))
//    {
//      graphics.drawImage (f, 0, 0, null); 
//    }
    if (adventure.equals(""))
    {
      graphics.drawImage (main, 0, 0, null); 
    }
    repaint();
  }  

}