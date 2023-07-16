
import java.util.*;
public class Main {
   public static String compress(String s) {
       StringBuilder sb = new StringBuilder();
       int curr = 0;
       while (curr < s.length()) {
           int last = curr;
           while (curr + 1 < s.length() && s.charAt(curr) == s.charAt(curr + 1))
               curr++;
           sb.append(s.charAt(curr));
           sb.append(Integer.toString(curr - last + 1));
           curr++;
       }
       return sb.toString();
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.next();
       System.out.println(compress(s));
   }
}
