import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class MarRevenue extends JPanel
{
    int degree = 1, counter = 1;
    double [] coeff = new double[degree + 1];
    DecimalFormat maxDF = new DecimalFormat("#.###################");
    DecimalFormat df = new DecimalFormat ("0.00");
    String term2 = "", equation = "", correct = "";
    int max = 0, first = 0, second = 0, choice = 0;
    static ArrayList<String> arr;
    
    public MarRevenue()
    {      
        //Generates Equation
        coeff[1]=Calculate.randCons(2);
        coeff[0]=Calculate.randCoef(2, coeff[1]);
        
        if(coeff[0] != 0)
        {
             if(coeff[0] == -1)
                term2 = "-x";
            else
                term2 = maxDF.format(coeff[0])+"x"; //Bx form
        }
        System.out.println(maxDF.format(coeff[1]) + term2);//just for testing
        equation = maxDF.format(coeff[1]) + term2;
        
        //Generates sales level
        max = (int)(-coeff[1]/coeff[0]);
        second = (int)(Math.random()*(max-30)+30); 
        if((int)(Math.random()*2) == 1)
            first = (int)(Math.random()*(second-10));
        System.out.println("max: " + max + " first: " + first + " and second: " + second); //partially used for testing
        
       //Calculates integral and generates 4 options
        arr = new ArrayList<String>(Arrays.asList("$" + df.format(Calculate.integrate(0, degree, coeff, first ,second, 0))));
        correct = arr.get(0);
        if(first != 0)
        {
            arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first ,second + (second-first),0))));
            arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,0,second,0))));
        }
        else
        {
            if ((int)(Math.random()*2)==0)
                arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first/2,second/2,0))));
            else
                arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first*2 ,second*2,0))));
            if((int)(Math.random()*2)==0)
                arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first*3,second*3,0))));
            else
                arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first/3,second/3,0))));
        }
        if((int)(Math.random()*2)==0)
            arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first*2, second/3,0))));
        else
            arr.add("$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first/3, second*2,  0))));
        for (int y = 4; y >= 1; y--)
        {
            choice = (int)(Math.random()*y);
            System.out.println("Choice: " + choice + " Y: " + y + " Array int: " + arr.get(choice)); //used for testing
            System.out.println(arr.get(choice));
            arr.add(arr.get(choice));
            arr.remove(choice);
        }
        
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
                
                if (counter == 4) //Mission 1
                {          
                    if (relativeX >= 601 && relativeX <= 868 && relativeY >= 257 && relativeY <= 304) //First choice
                    {
                        if(MarRevenue.getValue(0).equals(correct))
                        {
                            Driver.dialogBox(0);
                        }
                        else
                        {
                            Driver.dialogBox(2);
                        }
                        //if answer is correct --> output a textbox telling them they are correct, Driver.changeScreens("Raise");
                        //else if answer is incorrect --> output a textbox telling them they are incorrect, Driver.changeScreens("Fired");
                    }
                    else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 336 && relativeY <= 382) //Second choice
                    {
                        if(MarRevenue.getValue(1).equals(correct))
                        {
                            Driver.dialogBox(0);
                        }
                        else
                        {
                            Driver.dialogBox(2);
                        }
                    }
                    else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 417 && relativeY <= 465) //Third choice
                    {
                        if(MarRevenue.getValue(2).equals(correct))
                        {
                            Driver.dialogBox(0);
                        }
                        else
                        {
                            Driver.dialogBox(2);
                        }
                    }
                    else if (relativeX >= 601 && relativeX <= 868 && relativeY >= 498 && relativeY <= 545) //Last choice
                    {
                        if(MarRevenue.getValue(3).equals(correct))
                        {
                            Driver.dialogBox(0);
                        }
                        else
                        {
                            Driver.dialogBox(2);
                        }
                    }
                }    
            } 
        }); 
    }
    
    public static String getValue(int index)
    {
        return arr.get(index);
    }
    
    public void paintComponent (Graphics g)
    {
        MediaTracker tracker = new MediaTracker (new Frame ());    
        Image marRevenue = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/MarRevenue" + counter + ".png");
        tracker.addImage (marRevenue, 0); 
        g.drawImage (marRevenue, 0, 0, null);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        g.setColor (Color.red);
        
        if (counter == 1)
        {
            g.drawString (equation, 282, 307); //output the equation of the demand curve onto the screen
        }
        else if (counter == 2)
        {
            g.drawString (first + " "+ second, 365, 315); //output the sales level onto the screen
        }
        else if (counter == 4)
        {
            g.drawString (equation, 260, 350); //output the equation of the demand curve
            g.drawString (first + " "+ second, 260, 447); //output the sales level
            g.drawString (arr.get(0), 677, 289); //option 1
            g.drawString (arr.get(1), 677, 368); //option 2
            g.drawString (arr.get(2), 677, 451); //option 3
            g.drawString (arr.get(3), 677, 533); //option 4
        }
        repaint();
    }
}