import java.io.*;
import java.text.*;
public class Calculate
{
    public static double integrate (int degree, double coefficient[], double lower, double upper, double sell) //
    {
        boolean v = false;
        double area = 0, area2 = 0; 
        DecimalFormat df = new DecimalFormat ("0.00");
        while (!v)
        {
            try
            {
                v = true;
                double indefinite[] = new double [degree + 1];
                double temp[] = new double [degree + 1];
                double temp2 [] = new double [degree + 1];
                double limit[] = new double [2];
                int count = degree;
                for (int i = 0 ; i <= degree ; i++)
                {
                    if(i==degree)
                        indefinite [i] = (coefficient[i] - sell)/(count+1);
                    else
                        indefinite [i] = coefficient [i] / (count + 1);
                    count--;
                }
                System.out.print ("The indefinite integral is:\t"); //used for testing
                for (int i = 0 ; i <= degree ; i++)
                {
                    System.out.print (indefinite [i] + "\t"); //used for testing
                }
                System.out.println ("C"); //used for testing
                count = degree + 1;
                for (int i = 0 ; i <= degree ; i++)
                {
                    temp [i] = indefinite [i] * Math.pow (upper, count);
                    temp2 [i] = indefinite [i] * Math.pow (lower, count);
                    area += temp [i];
                    area2 += temp2 [i];
                    count--;
                }
                System.out.println ("The area for these definite limits is " + df.format (area - area2) + " square units."); //used for testing
                
            }
            catch (Throwable t)
            {
                v = false;
            }
        }
        return(area - area2);
    }
    
//    public static String generateEquation(int whichEq)
//    {
//        //First, check what equation is needed
//        if(whichEq == 0)//consur //Then 
//        {
//            return (randCons(0) + " - " + randCoef(0) + "x -  " + randCoef2(0) + "x^2");
//        }
//        if(whichEq == 1)//prosur
//        if(whichEq == 1)//marrev
//        if(whichEq == 1)//marcos
//        if(whichEq == 1)//marpro
//            return (randCons(0));
//        return;//netinfl
//    }
    
    public static double randCons(int whichAd)
    {
        //First decide if it's gonna be 2 digits, 3 digits, or 4 digits
        int dig = (int)(Math.random()*3+2);
        System.out.println(dig);
        //if 2: 10 - 99; if 3: 100 - 999; if 4: 1000 - 9999
        return (int) (Math.random()*Math.pow(10,dig-1)*9+Math.pow(10,dig-1));
    }
    
    public static double randCoef(int whichAd, double cons)
    {
        double rand = (Math.random()*((cons/100)-0.05));
        DecimalFormat maxDigitsFormatter = new DecimalFormat("#.###################");
        StringBuilder pattern = new StringBuilder().append("0.0");
        double start = 0.1;
        while(rand < start)
        {
            start = start /10;
            pattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return -(Double.parseDouble(df.format(rand)));
    }
    
    public static double randCoef2(int whichAd, double cons, double coef)
    {
        if(whichAd == 0)
        {
            if((int)(Math.random()*3) != 2){
                int dig = 0, extra = 0;
                if(-coef <= 0.0001) //To see how small third coef should be; this depends on how close coef is to cons/100. The closer it is, the smaller third coef is.
                    dig = -4;
                else if(cons/100 + coef > 0.1)
                    dig = -5;
                else //if(cons/100 - coef <= 0.1)
                    dig = -6;
                if(cons >=1000) //Extra is used to subtract cons/10000 by a number. This number, which always contains 5, depends on the number of zeroes. If cons/10000 = 0.4, number = 0.05. If cons/10000 = 0.04, number = 0.0005 and so on.
                    extra = 2;
                else if(cons >= 100)
                    extra = 1;
                double rand = (Math.random()*((cons*(Math.pow(10,dig)))-5*Math.pow(10,(dig+extra))));
                DecimalFormat maxDigitsFormatter = new DecimalFormat("#.###################");
                StringBuilder pattern = new StringBuilder().append("0.0");
                double start = 0.1;
                while(rand < start)
                {
                    start = start /10;
                    pattern.append("0");
                }
                DecimalFormat df = new DecimalFormat(pattern.toString());
                //System.out.println(df.format(
                return -(Double.parseDouble(df.format(rand)));
            }
        }
        return 0;
    }
}
