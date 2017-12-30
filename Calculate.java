import java.io.*;
import java.text.*;
public class Calculate
{
    public static double integrate (int whichAd, int degree, double coeff[], double lower, double upper, int sales) //
    {
        boolean v = false;
        double area = 0, area2 = 0; 
        DecimalFormat df = new DecimalFormat ("0.00");
        while (!v)
        {
            try
            {
                v = true;
//  BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
//  System.out.print ("Enter the highest degree of the polynomial: ");
//  int degree = Integer.parseInt (br.readLine ());
                double coefficient[] = new double [degree + 1];
                double indefinite[] = new double [degree + 1];
                double temp[] = new double [degree + 1];
                double temp2 [] = new double [degree + 1];
                double limit[] = new double [2];
                double sell = 0;
                //int sales = 500;
                int count = degree;
                for (int i = 0 ; i <= degree ; i++)
                {
                    coefficient [i] = coeff[i];
                    if(whichAd == 0 || whichAd == 1)
                        sell += coefficient[i] * Math.pow(sales,degree-i);
                    if(i==degree)
                    {
                       // System.out.println(coefficient[i]);
                        indefinite [i] = (coefficient[i] - sell)/(count+1);
                    }
                    else
                        indefinite [i] = coefficient [i] / (count + 1);
                    count--;
                }
                System.out.print ("The indefinite integral is:\t");
                for (int i = 0 ; i <= degree ; i++)
                {
                    System.out.print (indefinite [i] + "\t");
                }
                System.out.println ("C");
//                do
//                {
//                    System.out.print ("Enter the lower limit: ");
//                    limit [0] = Double.parseDouble (br.readLine ());
//                    System.out.print ("Enter the upper limit: ");
//                    limit [1] = Double.parseDouble (br.readLine ());
//                    if (limit [1] < limit [0])
//                    {
//                        System.out.println ("The bounds must be from small to large!");
//                    }
//                }
//                while (limit [1] < limit [0]);
                count = degree + 1;
                for (int i = 0 ; i <= degree ; i++)
                {
                    temp [i] = indefinite [i] * Math.pow (upper, count);
                    temp2 [i] = indefinite [i] * Math.pow (lower, count);
                    area += temp [i];
                    area2 += temp2 [i];
                    count--;
                }
                System.out.println ("The area for these definite limits is " + df.format (area - area2) + " sqrare units.");
                
            }
            catch (Throwable t)
            {
                v = false;
            }
        }
        return(area - area2);
      //  return 0;
    }
}
