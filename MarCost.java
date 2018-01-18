import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class MarCost extends JPanel
{
    int degree = 2, counter = 1;
    double [] coeff = new double[degree + 1];
    DecimalFormat maxDF = new DecimalFormat("#.###################");
    DecimalFormat df = new DecimalFormat ("0.00");
    String term2 = "", term3 = "", equation = "", correct = "";
    int first = 0, second = 0, choice = 0;
    double start;
    static ArrayList<String> arr;
    
    public MarCost()
    {      
        //Generates Equation
       coeff[2]=Calculate.randCons(3);
        coeff[1]=Calculate.randCoef(3, coeff[2]);
        coeff[0]=Calculate.randCoef2(3,coeff[2],coeff[1]);
        
       if(coeff[1] != 0)
        {
            if(coeff[1] == -1)
                term2 = "-x";
            else if(coeff[1] == 1)
                term2 = "x";
            else
                term2 = maxDF.format(coeff[1])+"x"; //Bx form
        }
        if(coeff[0] != 0)
        {
            if(coeff[0] == 1)
                term3 = "+x^2";
            else
                term3 = maxDF.format(coeff[0])+"x^2 "; //Ax^2 form
        }
        System.out.println(maxDF.format(coeff[1]) + term2 + term3);//just for testing
        equation = maxDF.format(coeff[1]) + term2 + term3;
        
        //Generates sales level
        second = ((int)(Math.random()*9991)) + 10; 
        if((int)(Math.random()*2) == 1)
            first = (int)(Math.random()*(second-10));
        System.out.println(" first: " + first + " and second: " + second); //partially used for testing
        
        //Generates startup cost
        start = Double.parseDouble(df.format(Math.random()*100001));
        System.out.println("Startup cost: " + start);
        
       //Calculates integral and generates 4 options
        arr = new ArrayList<String>(Arrays.asList("$" + df.format(Calculate.integrate(0, degree, coeff, first ,second, 0) + start), "$" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first,(int)(Math.random()*second),0))), "$" + df.format((Math.abs(Calculate.integrate(0, degree, coeff,first, second,0))))));
        correct = arr.get(0);
        if(first != 0)
            arr.add("C) $" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,0,second,0))+ start));
        else
        {
            if((int)(Math.random()*2)==0)
                arr.add("C) $" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first,second*2,0))+ start));
            else
                arr.add("C) $" + df.format(Math.abs(Calculate.integrate(0, degree, coeff,first,second/2,0))+ start));
        }
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
        Image marCost = Toolkit.getDefaultToolkit ().getImage ("Backgrounds/MarCost" + counter + ".png");
        tracker.addImage (marCost, 0); 
        g.drawImage (marCost, 0, 0, null);
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
            g.drawString (arr.get(0), 677, 289); //option 1
            g.drawString (arr.get(1), 677, 368); //option 2
            g.drawString (arr.get(2), 677, 451); //option 3
            g.drawString (arr.get(3), 677, 533); //option 4
        }
        repaint();
    }
}