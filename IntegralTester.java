
import java.text.*;

public class IntegralTester
{

  public IntegralTester()
  {
      
      DecimalFormat df = new DecimalFormat ("0.00");
     // Integration inte = new Integration();//int degree, double coeff[], double lower, double upper, int sales, int sell
      double[] coeff = new double[3];
      coeff[0]=-0.0001;
      coeff[1]=-0.2;
      coeff[2]=1200;
      System.out.println("A) $" + df.format(Calculate.integrate(0,2, coeff,0,500,500)));
  }
 
  public static void main(String [] args)
  {
    new IntegralTester();
  }  
}