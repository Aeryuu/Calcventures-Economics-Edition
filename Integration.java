import java.io.*;
import java.text.*;
public class Integration
{
    //public double calculate (int 
    public static void main (String args[])
    {
 boolean v = false;
 DecimalFormat df = new DecimalFormat ("#.####");
 while (!v)
 {
     try
     {
  v = true;
  BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
  System.out.print ("Enter the highest degree of the polynomial: ");
  int degree = Integer.parseInt (br.readLine ());
  double coefficient[] = new double [degree + 1];
  double indefinite[] = new double [degree + 1];
  double temp[] = new double [degree + 1];
  double temp2 [] = new double [degree + 1];
  double limit[] = new double [2];
  double area = 0, area2 = 0, sellPrice = 0;
  int sales = 500;
  int count = degree;
  for (int i = 0 ; i <= degree ; i++)
  {
      System.out.print ("Enter coefficient " + (i + 1) + ": ");
      coefficient [i] = Double.parseDouble (br.readLine ());
      sellPrice += coefficient[i] * Math.pow(sales,degree-i);
      if(i==degree)
          indefinite [i] = (coefficient[i] - sellPrice)/(count+1);
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
  do
  {
      System.out.print ("Enter the lower limit: ");
      limit [0] = Double.parseDouble (br.readLine ());
      System.out.print ("Enter the upper limit: ");
      limit [1] = Double.parseDouble (br.readLine ());
      if (limit [1] < limit [0])
      {
   System.out.println ("The bounds must be from small to large!");
      }
  }
  while (limit [1] < limit [0]);
  count = degree + 1;
  for (int i = 0 ; i <= degree ; i++)
  {
      temp [i] = indefinite [i] * Math.pow (limit [1], count);
      temp2 [i] = indefinite [i] * Math.pow (limit [0], count);
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
    }
}
