import java.util.*;

public class Main {  
    public static void main(String[] args) {
  
      StringBuilder sb1 = new StringBuilder("Physics wallah");
      System.out.println("string = " + sb1);
  
      // returns the index of the specified substring
      System.out.println("Index of substring  = " + sb1.indexOf("allah"));
    
      // returns -1 as substring is not found 
      System.out.println("Index of substring  = " + sb1.indexOf("k"));
   }
}
