// ****************************************************************** 
// DigitPlay.java
//
// Finds the number of digits in a positive integer.
// ****************************************************************** 
import java.util.Scanner;
public class DigitPlay 
{
   public static void main (String[] args) 
   {
      int num; //a number
      Scanner scan = new Scanner(System.in);
      System.out.println ();
      System.out.print ("Please enter a positive integer: ");
      num = scan.nextInt ();
      if (num <= 0)
         System.out.println ( num + " isn't positive -- start over!!"); 
      else 
      {
      // Call numDigits to find the number of digits in the number
      // Print the number returned from numDigits
         System.out.println ("\nThe number " + num + " contains " +
            + numDigits (num) + " digits."); 
         System.out.println (); 
         System.out.println ("\nThe number " + num + " contains " +
            + numDigits2 (num) + " digits."); 
         System.out.println (); 
         
         System.out.print("\nThe sum of digits in number " + num + " is " +
            + sumDigits (num) + " "); 
            System.out.print("\nThe sum of digits in number " + num + " is " +
            + sumDigits2 (num) + " ");
         if(sumDigits (num) % 7 == 0)
            System.out.println ("-- ok"); 
         else
            System.out.println ("-- error"); 

      }
   }
// -----------------------------------------------------------
// Recursively counts the digits in a positive integer
// -----------------------------------------------------------
   public static int numDigits (int num) 
   {
      if (num < 10)
         return (1); 
      else
         return (1 + numDigits (num/10));
   }
   
   public static int numDigits2(int num){
      int count = 0;
      while(num/10 >0){ //(num/10 > 0) is the basecase
         count++;
         num = num/10; //<= recursion formula
      }
      return count+1; // originally she had written count+num
   }
   
    public static int sumDigits (int num) 
   {
      if (num < 10)
         return (num); 
      else
         return (num%10 + sumDigits (num/10));
   }
   
   public static int sumDigits2(int num){
      int sum=0;
      while(num/10>0){
         sum+=num%10;
         num=num/10;
      }
      return sum+num;
   }
}
