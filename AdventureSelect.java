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
                
                if (relativeX >= 52 && relativeX <= 286 && relativeY >= 109 && relativeY <= 327 && adventure.equals(""))
                {
                    adventure = "ConSurplus";
                    System.out.println (adventure);
                }
                else if (relativeX >= 52 && relativeX <= 286 && relativeY >= 353 && relativeY <= 572 && adventure.equals(""))
                {
                    adventure = "ProSurplus";
                    System.out.println (adventure);
                }
                else if (relativeX >= 383 && relativeX <= 617 && relativeY >= 109 && relativeY <= 327 && adventure.equals("")) 
                {
                    adventure = "MargRevenue";
                    System.out.println (adventure);
                }
                else if (relativeX >= 383 && relativeX <= 617 && relativeY >= 353 && relativeY <= 572 && adventure.equals("")) 
                {
                    adventure = "MargCost";
                    System.out.println (adventure);
                }
                else if (relativeX >= 713 && relativeX <= 974 && relativeY >= 109 && relativeY <= 327 && adventure.equals(""))
                {
                    adventure = "MargProfit";  
                    System.out.println (adventure);
                }
                else if (relativeX >= 713 && relativeX <= 974 && relativeY >= 353 && relativeY <= 572 && adventure.equals(""))
                {
                    adventure = "NetInvestFlow";  
                    System.out.println (adventure);
                }
                else if (relativeX >= 421 && relativeX <= 579 && relativeY >= 598 && relativeY <= 662 && adventure.equals("")) //Main menu
                {
                    CharacterSelect.character = "";
                    CharacterSelect.charSelected = false;
                    Driver.changeScreens("MainMenu");
                }
                else if (relativeX >= 427 && relativeX <= 57279 && relativeY >= 508 && relativeY <= 571 && !adventure.equals("")) //If they click Play
                {
                    System.out.println ("PRESSED PLAY"); 
                    Driver.changeScreens(adventure); //Takes them to the adventure they chose
                }
                else if (relativeX >= 862 && relativeX <= 934 && relativeY >= 43 && relativeY <= 114 && !adventure.equals("")) //If they click X
                {
                    adventure = "";
                }
            } 
        }); 
    }
    
    public void paint(Graphics graphics)
    {    
        MediaTracker tracker = new MediaTracker (new Frame ());    
        
        Image a = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select ConSurplus.png");
//    Image b = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select ProSurplus.png");
//    Image c = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select MargRevenue.png");
//    Image d = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select MargCost.png");
//    Image e = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select MargProfit.png");
//    Image f = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select NetInvestFlow.png");
        Image main = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/Adventure Select.png");
        
        tracker.addImage (a, 0);        
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
        
        if (adventure.equals(""))
        {
            graphics.drawImage (main, 0, 0, null); 
        }
        else if (adventure.equals("ConSurplus"))
        {
            graphics.drawImage (a, 0, 0, null); 
        }
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
        
        repaint();
    }  
    
}