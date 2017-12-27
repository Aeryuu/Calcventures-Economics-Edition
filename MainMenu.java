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
    try
    {
      BufferedImage image = ImageIO.read(new File("Backgrounds/Main Menu.png"));
      JLabel picLabel = new JLabel(new ImageIcon(image));
      add(picLabel);
    }
    catch (IOException e)
    {
    }   
  }
}