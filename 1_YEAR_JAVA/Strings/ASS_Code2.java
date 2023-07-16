import java.util.*;


public class Main {
   public static String toggleCase(String s) {
       StringBuilder sb = new StringBuilder(s);
       for (int i = 0; i < sb.length(); i++) {
           char ch = sb.charAt(i);
           if (Character.isUpperCase(ch)) {
               // convert to lowerCase
               sb.setCharAt(i, Character.toLowerCase(ch));
           } else if (Character.isLowerCase(ch)) {
               // convert to UpperCase
               sb.setCharAt(i, Character.toUpperCase(ch));
           }
       }
       return sb.toString();
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.next();
       System.out.println(toggleCase(s));
   }
}
