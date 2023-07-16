import java.util.*;


public class Main {
   public static String reverseWord(String s) {
       StringBuilder sb = new StringBuilder(s);
       int i = 0;
       while (i < sb.length()) {
           // get the last index of the current word
           int j = i;
           while (j + 1 < sb.length() && sb.charAt(j + 1) != ' ') {
               j++;
           }


           int last = j;
           // reverse the word
           while (i < j) {
               Character temp = sb.charAt(i);
               sb.setCharAt(i, sb.charAt(j));
               sb.setCharAt(j, temp);
               i++;
               j--;
           }
           i = last + 2;
       }
       return sb.toString();
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.nextLine();
       System.out.println(reverseWord(s));
   }
}

