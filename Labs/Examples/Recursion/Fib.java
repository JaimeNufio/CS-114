// ******************************************************************* 
// Fib.java
//
// A utility class that provide methods to compute elements of the
// Fibonacci sequence.
// ******************************************************************* 
public class Fib 
{
//------------------------------------------------------------------
// Recursively computes fib(n) 
//------------------------------------------------------------------
   public static int fib1(int n) 
   {
   //Fill in code -- this should look very much like the 
   //mathematical specification
      if(n==0)
         return 0;
      else if(n==1)
         return 1;
      else
         return fib1(n-1) + fib1(n-2);
   } 
   
   public static int fib2(int n){
      if(n==0)
         return 0;
      else if(n==1)
         return 1;
      else{
         int fib = 0;
         int fibn1=1;
         int fibn2=0;
         for(int i = 2; i<=n; i++){
            fib=fibn1+fibn2;
            fibn2=fibn1;
            fibn1=fib;
         }
         return fib;
      }
   }
}