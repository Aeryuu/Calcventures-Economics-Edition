import java.io.*;
import java.text.*;
public class Calculate
{
    public static double integrate (int whichAd, int degree, double coefficient[], double lower, double upper, double sell) //
    {
        boolean v = false;
        double area = 0, area2 = 0; 
        DecimalFormat df = new DecimalFormat ("0.00");
        if(whichAd == 2)
        {
            coefficient[2] = coefficient[1];
            coefficient[1] = coefficient[0];
            coefficient[0] = 0;
        }
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
                    {
                        if(whichAd != 1)
                            indefinite [i] = (coefficient[i] - sell)/(count+1);
                        else
                            indefinite [i] = (sell - coefficient[i])/(count+1);
                    }
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
    
    public static double randCons(int whichAd)
    {
        int dig;
        if(whichAd == 0)
        {
            //First decide if it's gonna be 2 digits, 3 digits, or 4 digits
            dig = ((int)(Math.random()*3)+2);
            //if 2: 10 - 99; if 3: 100 - 999; if 4: 1000 - 9999
            if(dig == 4)
                return ((int) (Math.random()*9000) + 1000);
            if(dig == 3)
                return ((int) (Math.random()*900) + 100);
            return ((int) (Math.random()*90) + 10);
        }
        if(whichAd == 1)
        {
            dig = ((int)(Math.random()*3)+1);
            System.out.println(dig);
            //if 1: 1 - 9; if 2: 10 - 99; if 3: 100 - 999
            if(dig == 3)
                return ((int) (Math.random()*900) + 100);
            if(dig == 2)
                return ((int) (Math.random()*90) + 10);
            return ((int) (Math.random()*9) + 1);
        }
        if(whichAd == 2)
        {
            dig = ((int)(Math.random()*4)+1);
            if(dig == 4)
                return ((int) (Math.random()*9000) + 1000);
            if(dig == 3)
                return ((int) (Math.random()*900) + 100);
            if(dig == 2)
                return ((int) (Math.random()*90) + 10);
            return ((int) (Math.random()*9) + 1);
        }
        if(whichAd == 3)
        {
            dig = (int)(Math.random()*4);
            System.out.println(dig);
            //if 1: 1 - 9; if 2: 10 - 99; if 3: 100 - 999; if 0: [0,1)
            if(dig == 3)
                return ((int) (Math.random()*900) + 100);
            if(dig == 2)
                return ((int) (Math.random()*90) + 10);
            if(dig == 1)
                return ((int) (Math.random()*9) + 1);
            return Math.random();
        }
        return 0;
    }
    
    public static double randCoef(int whichAd, double cons)
    {
        DecimalFormat maxDigitsFormatter = new DecimalFormat("#.###################");
        StringBuilder pattern;
        double rand, start;
        if(whichAd == 0)
        {
            rand = (Math.random()*((cons/100)-0.05));
            start = 0.1;
            pattern = new StringBuilder().append("0.0");
            while(rand < start)
            {
                start = start /10;
                pattern.append("0");
            }
            DecimalFormat df = new DecimalFormat(pattern.toString());
            return -(Double.parseDouble(df.format(rand)));
        }
        if(whichAd == 1)
        {
            rand = (Math.random()*3+0.01);
            start = 0.01;
            pattern = new StringBuilder().append("0.00");
            while(rand < start)
            {
                start = start /10;
                pattern.append("0");
            }
            DecimalFormat df = new DecimalFormat(pattern.toString());
            return Double.parseDouble(df.format(rand));
        }
        if(whichAd == 2)
        {
            rand = (Math.random()*((cons/100)));
            start = 0.01;
            pattern = new StringBuilder().append("0.00");
            while(rand < start)
            {
                start = start /10;
                pattern.append("0");
            }
            DecimalFormat df = new DecimalFormat(pattern.toString());
            return -(Double.parseDouble(df.format(rand)));
        }
        return 0;
    }
    
    public static double randCoef2(int whichAd, double cons, double coef)
    {
        int dig = 0, extra = 0;
        DecimalFormat maxDigitsFormatter = new DecimalFormat("#.###################");
        StringBuilder pattern = new StringBuilder().append("0.0");
        double rand, start = 0.1;
        if(whichAd == 0)
        {
            if((int)(Math.random()*3) != 2){
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
                rand = (Math.random()*((cons*(Math.pow(10,dig)))-5*Math.pow(10,(dig+extra))));
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
        if(whichAd == 1)
        {
            rand = (Math.random()*0.001);
            start = 0.1;
            while(rand < start)
            {
                start = start /10;
                pattern.append("0");
            }
            DecimalFormat df = new DecimalFormat(pattern.toString());
            return Double.parseDouble(df.format(rand));
        }
        return 0;
    }
}
