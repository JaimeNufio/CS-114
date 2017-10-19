import java.util.Scanner;
public class Palindromes{

   public static boolean isPalindrome(String text){
      if(text.length()<2)
         return true;
      else      
         return text.charAt(0) == text.charAt(text.length()-1) && isPalindrome(text.substring(1,text.length()-1));
   }
   
   public static boolean isPalindrome2(String text){
      boolean rs = false;
      while(text.length()>1){
         if(text.charAt(0) != text.charAt(text.length()-1))
            return false;
         text = text.substring(1,text.length()-1);
      }
      return true;
   }
   
   public static void main(String[] args){
      System.out.print("Enter a String: ");
      Scanner scan = new Scanner(System.in);
      String s = scan.next();
      System.out.println("is Palindrome:\t" +isPalindrome(s));
      System.out.println("is Palindrome:\t" +isPalindrome2(s));
   }

}