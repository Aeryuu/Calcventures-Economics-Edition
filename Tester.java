
import java.text.*;

public class Tester
{

  public Tester()
  {
      DecimalFormat df = new DecimalFormat ("0.00");
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
      double cons = Calculate.randCons(0);
      System.out.println(cons);
      double coef = Calculate.randCoef(0,cons)
      System.out.println(coef);
      System.out.println(Calculate.randCoef2(0,cons,coef));
      
//      int degree = 2;
//      double [] coeff = new double[degree + 1];
//      coeff[0]=-0.0001;
//      coeff[1]=-0.2;
//      //coeff[2]=1200;
//      coeff[2]=Calculate.randCons(0);
//      //Screen 1: Equation is introduced
//      String term2 = "", term3 = "";
//      if(coeff[1] != 0)
//          term2 = df2.format(coeff[1])+"x";
//      if(coeff[0] != 0)
//          term3 = df2.format(coeff[0])+"x^2 ";
//      System.out.println(df2.format(coeff[2]) + term2 + term3);//just for consur
//      //Screen 2: Introduce sales level
//      int x1=(int)((-coeff[1]+(Math.sqrt(Math.pow(coeff[1],2)-4*coeff[0]*coeff[2])))/(2*coeff[0]));
//      int x2=(int)((-coeff[1]-(Math.sqrt(Math.pow(coeff[1],2)-4*coeff[0]*coeff[2])))/(2*coeff[0]));
//      System.out.println("x1: " + x1 + " and x2: " + x2);
//      int sales = 0, x = 0;
//      if(x2>0 && (x2 < x1 || x1 < 0))
//          x = x2;
//      if(x1>0 && (x1 < x2 || x2 < 0))
//          x = x1;
//       sales = (int)(Math.random()*x);
//       System.out.println("x: " + x + " and Sales: " + sales);
//      //Screen 3: Calculate for selling price
//      double sell = 0;
//      for (int i = 0 ; i <= degree ; i++)
//      {
//          sell += coeff[i] * Math.pow(sales,degree-i);
//      }
//       System.out.println("Sell price: $" + df.format(sell));
//      //Screen 4: Calculate integral
//      System.out.println("A) $" + df.format(Calculate.integrate(degree, coeff,0,sales, sell))); //Real answer
//      System.out.println("B) $" + df.format(Calculate.integrate(degree, coeff,0,sales, 0))); //Fake answer, forgot to subtract sell price
//      System.out.println("C) $" + df.format(Math.abs(Calculate.integrate(degree, coeff,0,sell, sell)))); //Fake answer, used sell price as upper bounds
//      System.out.println("D) $" + df.format(Math.abs(Calculate.integrate(degree, coeff,0,sell, sales)))); //Fake answer, used sell price as upper bounds and subtracted sales level
 }
 
  public static void main(String [] args)
  {
    new Tester();
  }  
}