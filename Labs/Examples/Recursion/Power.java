// ***************************************************************** 
// Power.java
//
// Reads in two integers and uses a recursive power method
// to compute the first raised to the second power.
// ***************************************************************** 
import java.util.Scanner;
public class Power 
{
   public static void main(String[] args) 
   {
      int base, exp; 
      int answer;
      Scanner scan = new Scanner(System.in);
      System.out.print("Welcome to the power program! "); 
      System.out.println("Please use integers only.");
   //get base
      System.out.print("Enter the base you would like raised to a power: ");
      base = scan.nextInt();
   //get exponent
      System.out.print("Enter the power you would like it raised to: ");
      exp = scan.nextInt();
      answer = power (base,exp);
      System.out.println(base + " raised to the " + exp + " is " + answer);
      System.out.println(base + " raised to the " + exp + " is " + power2(base,exp));
      System.out.println("Lab Practice 12 - 2 Qustion 5");
      System.out.println(strConcat(exp));
      System.out.println(strConcat2(exp));

      System.out.println("Lab Practice 12 - 2 Qustion 6");
   
      System.out.println(asterConcat(exp));
      System.out.println(asterConcat2(exp));
      System.out.println("Lab Practice 12 - 2 Qustion 7");
   
      System.out.println(power(exp));
      System.out.println(power2(exp));

   
   }
// ----------------------------------------------
// Computes and returns base^exp
// ----------------------------------------------
   public static int power(int base, int exp) 
   {
      int pow;
      //if the exponent is 0, set pow to 1 
      if(exp == 0)
         pow = 1;
      //otherwise set pow to base*base^(exp-1) 
      else
         pow = base*power(base,exp-1);
      //return pow
      return pow;
   } 
   
   public static int power2(int base, int exp){
      int rs = 1; //exp=0
      for(int i = 0; i < exp; i++){
         rs= rs*base;
      }
      return rs;
   }
   
   public static String power(int n){
      if(n==1){            
         return "1";
      }
      else{
         return power(n-1) + " " + n + " " + power(n-1);
      }   
   }
   
   public static String power2(int n){
      String rs = "1";
      for(int i = 2; i<=n; i++){
         rs = rs+" "+i+" "+rs;
      }
      return rs;
   }
   
   public static String strConcat(int n){
      if(n==0){
         return "";
      }
      else
         return "CS 113 " + strConcat(n-1); 
   }
   
   public static String strConcat2(int n){
      String rs = "";
      for(int i = 0; i<n;i++){
         rs += "CS 113 ";
      }
      return rs;
   }
   
   public static String asterConcat(int n){
      if(n==0){
         return "";
      }
      else
         return "*" + asterConcat(n-1)+"!"; 
   }
   
   public static String asterConcat2(int n){
      String rs="";
      for(int i=0;i<n;i++){
         rs="*"+rs+"!";
      }
      return rs;
   }
}