import java.util.Scanner;
public class Test {
    public static String mergeStrings(String a, String b){
      String answer = "";
      if(a.length() == 0){
          answer += b;
          return answer;
      }
      if(b.length() == 0){
          answer += a;
          return answer;
      }
      answer += a.substring(0, 1);
      answer += b.substring(0, 1);
      answer += mergeStrings(a.substring(1), b.substring(1));
      return answer;
    }
    
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       System.out.println("Enter the first string: ");
       String a = scn.nextLine();
       System.out.println("Enter the second string: ");
       String b = scn.nextLine();
       System.out.print("The desired output is : " + mergeStrings(a, b));
    }
}
 
