import java.util.*;
import java.text.*;

public class Tester
{
    
    public Tester()
    {
        //******************* Used to test the coef and coef2 random functions work and to see how they should work
//      double max = 0;
//      DecimalFormat df3 = new DecimalFormat ("0.00");
//      DecimalFormat df = new DecimalFormat("");
//      for(int x = 0;x<500;x++)
//      {
//      double rand = Math.random()*(0.00999-5*Math.pow(10,-4));
//      DecimalFormat maxDigitsFormatter = new DecimalFormat("#.###################");
//        StringBuilder pattern = new StringBuilder().append("0.0");
//        double start = 0.1;
//        while(rand < start)
//        {
//            start = start /10;
//            pattern.append("0");
//        }
//         df = new DecimalFormat(pattern.toString());
//        if(Double.parseDouble(df.format(rand)) > max)
//            max = Double.parseDouble(df.format(rand)); 
//      //System.out.println(df.format(rand));
//      }
//      System.out.println("MAX: " + df.format(max));
        
        //*************************** Used to test the Math.random function
//      double a =0,b,c; 
//      for(int x = 0;x<50;x++)
//      {
//          a = Math.random()*3+2; b = Math.random()*3+2; c = Math.random()*3+2;
//          System.out.println(a);
//          System.out.println((int)a);
//          System.out.println(b);
//          System.out.println((int)b);
//          System.out.println(c);
//          System.out.println((int)c);
//      }
//      a = Double.parseDouble(df.format(a));
//      System.out.println(a);
        //  System.out.println(Calculate.randCons(0));
        //   System.out.println(Calculate.randCons(0));
        
        //************* Used to test all three random functions and displays the x-ints to show how the smaller positive one is above 100
//      double cons = Calculate.randCons(0); 
//      System.out.println(cons);
//      double coef = Calculate.randCoef(0,cons);
//        DecimalFormat maxDigitsFormatter = new DecimalFormat("#.###################");
//      System.out.println(maxDigitsFormatter.format(coef));
//      
//      double coef2 = Calculate.randCoef2(0,cons,coef);
//      System.out.println(maxDigitsFormatter.format(coef2));
//      
//      int x1=(int)((-coef+(Math.sqrt(Math.pow(coef,2)-4*coef2*cons)))/(2*coef2));
//      int x2=(int)((-coef-(Math.sqrt(Math.pow(coef,2)-4*coef2*cons)))/(2*coef2));
//      System.out.println("X1: " + x1 + " X2: " + x2);
        
        
//******************** Actual program for prosur
        int degree = 2;
        double [] coeff = new double[degree + 1];
        DecimalFormat maxDF = new DecimalFormat("#.###################");
        DecimalFormat df = new DecimalFormat ("0.00");
        String term2 = "", term3 = "";
        int sales = 0, x = 0;
        
        coeff[2]=Calculate.randCons(0);
        coeff[1]=Calculate.randCoef(0,coeff[2]);
        coeff[0]=Calculate.randCoef2(0,coeff[2],coeff[1]);
        //Screen 1: Equation is introduced
        if(coeff[1] != 0)
            term2 = maxDF.format(coeff[1])+"x"; //Bx form
        if(coeff[0] != 0)
            term3 = maxDF.format(coeff[0])+"x^2 "; //Ax^2 form
        System.out.println(maxDF.format(coeff[2]) + term2 + term3);//just for consur //just for testing
        //Screen 2: Introduce sales level
        sales = (int)(Math.random()*10000);
        System.out.println("x: " + x + " and Sales: " + sales); //partially used for testing
        
        //Screen 3: Calculate for selling price
        double sell = 0;
        for (int i = 0 ; i <= degree ; i++)
        {
            sell += coeff[i] * Math.pow(sales,degree-i);
        }
        sell = Double.parseDouble(df.format(sell)); //sell becomes the rounded price displayed on screen
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        int choice;
        for (int y = 3; y >= 0; y--)
        {
            choice = (int)(Math.random()*y);
            if(arr.get(choice) == 1)
                System.out.println("A) $" + df.format(sell)); //Real answer
            else if(arr.get(choice) == 2)
                System.out.println("B) $" + df.format(Math.abs(sell - coeff[2]))); //Fake answer, didn't add constant
            else if(arr.get(choice) == 3)
            {
                if(-coeff[0]>0.001)
                    System.out.println("C) $" + df.format(sell - coeff[0]*Math.pow(sales,2))); //Fake answer, didn't add Ax^2
                else if(-coeff[1]>0.001)
                    System.out.println("C) $" + df.format(sell - coeff[1]*sales)); //Fake answer, didn't add Bx
                else
                    System.out.println("C) $" + df.format(sell - 1)); //Fake answer, in case, by some magical chance, both B and C are super small and sell price is close to constant
            }
            else//(arr.get(choice) == 4)
            {
                if((int)(Math.random()*2)==0)
                    System.out.println("D) $" + df.format(sell/2)); //Fake answer, divided sell by two
                else
                    System.out.println("D) $" + df.format(sell*2)); //Fake answer, multiplied sell by two
            }
            arr.remove(choice);
        }
        
        //Screen 4: Calculate integral
        arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        for (int y = 3; y >= 0; y--)
        {
            choice = (int)(Math.random()*y);
            if(arr.get(choice) == 1)
                System.out.println("A) $" + df.format(Calculate.integrate(degree, coeff,0,sales, sell))); //Real answer
            else if(arr.get(choice) == 2)
                System.out.println("B) $" + df.format(Calculate.integrate(degree, coeff,0,sales, 0))); //Fake answer, forgot to subtract sell price
            else if(arr.get(choice) == 3)
                System.out.println("C) $" + df.format(Math.abs(Calculate.integrate(degree, coeff,0,sell, sell)))); //Fake answer, used sell price as upper bounds
            else//(arr.get(choice) == 4)
                System.out.println("D) $" + df.format(Math.abs(Calculate.integrate(degree, coeff,0,sell, sales)))); //Fake answer, used sell price as upper bounds and subtracted sales level
            arr.remove(choice);
        }
        
        
        
// ********************* To test the randomness of Math.random
//      int one = 0, zero = 0, ack = 0,what = 0;
//      for(int x = 0;x<100;x++)
//      {
//          ack = (int)(Math.random()*3);
//          if (ack == 0)
//              zero++;
//          else if(ack ==1)
//              one++;
//          else
//              what++;
//      }
//  System.out.println("Zeros: " + zero + " Ones: " + one + " Whats: " + what);
    }
    
    //All the logic for consumer surplus
    public void consumerSurplus() 
    {
        int degree = 2;
        double [] coeff = new double[degree + 1];
        DecimalFormat maxDF = new DecimalFormat("#.###################");
        DecimalFormat df = new DecimalFormat ("0.00");
        String term2 = "", term3 = "";
        int sales = 0, x = 0;
        
        coeff[2]=Calculate.randCons(0);
        coeff[1]=Calculate.randCoef(0,coeff[2]);
        coeff[0]=Calculate.randCoef2(0,coeff[2],coeff[1]);
        
        //Screen 1: Equation is introduced
        if(coeff[1] != 0)
            term2 = maxDF.format(coeff[1])+"x"; //Bx form
        if(coeff[0] != 0)
            term3 = maxDF.format(coeff[0])+"x^2 "; //Ax^2 form
        System.out.println(maxDF.format(coeff[2]) + term2 + term3);//just for consur //just for testing
        
        //Screen 2: Introduce sales level
        if(coeff[0] != 0)
        {
            int x1=(int)((-coeff[1]+(Math.sqrt(Math.pow(coeff[1],2)-4*coeff[0]*coeff[2])))/(2*coeff[0]));
            int x2=(int)((-coeff[1]-(Math.sqrt(Math.pow(coeff[1],2)-4*coeff[0]*coeff[2])))/(2*coeff[0]));
            System.out.println("x1: " + x1 + " and x2: " + x2); //used for testing
            if(x2>0 && (x2 < x1 || x1 < 0))
                x = x2;
            if(x1>0 && (x1 < x2 || x2 < 0))
                x = x1;
        }
        else
            x = (int)(-coeff[2]/coeff[1]);
        sales = (int)(Math.random()*x);
        System.out.println("x: " + x + " and Sales: " + sales); //partially used for testing
        
        //Screen 3: Calculate for selling price
        double sell = 0;
        for (int i = 0 ; i <= degree ; i++)
        {
            sell += coeff[i] * Math.pow(sales,degree-i);
        }
        sell = Double.parseDouble(df.format(sell)); //sell becomes the rounded price displayed on screen
        ArrayList<String> arr = new ArrayList<String>(Arrays.asList("A) $" + df.format(sell),"B) $" + df.format(Math.abs(sell - coeff[2]))));
        if(-coeff[0]>0.001)
            arr.add("C) $" + df.format(sell - coeff[0]*Math.pow(sales,2))); //Fake answer, didn't add Ax^2
        else if(-coeff[1]>0.001)
            arr.add("C) $" + df.format(sell - coeff[1]*sales)); //Fake answer, didn't add Bx
        else
            arr.add("C) $" + df.format(sell - 1)); //Fake answer, in case, by some magical chance, both B and C are super small and sell price is close to constant
        if((int)(Math.random()*2)==0)
            arr.add("D) $" + df.format(sell/2)); //Fake answer, divided sell by two
        else
            arr.add("D) $" + df.format(sell*2)); //Fake answer, multiplied sell by two 
        int choice;
        for (int y = 4; y >= 1; y--)
        {
            choice = (int)(Math.random()*y);
            System.out.println("Choice: " + choice + " Y: " + y + " Array int" + arr.get(choice)); //used for testing
            System.out.println(arr.get(choice));
            arr.remove(choice);
        }
        //Screen 4: Calculate integral
        arr = new ArrayList<String>(Arrays.asList("A) $" + df.format(Calculate.integrate(degree, coeff,0,sales, sell)),"B) $" + df.format(Calculate.integrate(degree, coeff,0,sales, 0)),"C) $" + df.format(Math.abs(Calculate.integrate(degree, coeff,0,sell, sell))),"D) $" + df.format(Math.abs(Calculate.integrate(degree, coeff,0,sell, sales)))));
        for (int y = 4; y >= 1; y--)
        {
            choice = (int)(Math.random()*y);
            System.out.println("Choice: " + choice + " Y: " + y + " Array int" + arr.get(choice)); //used for testing
            System.out.println(arr.get(choice));
            arr.remove(choice);
        }
    }
    
    public static void main(String [] args)
    {
        Tester t = new Tester();
        t.consumerSurplus();
    }  
}