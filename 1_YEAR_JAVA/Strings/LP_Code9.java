import java.util.*;

public class Main {

  public static void main(String[] args) {
      
    StringBuilder str1 = new StringBuilder();
    System.out.println("Initial Capacity of str1: " + str1.capacity());

    StringBuilder str2 = new StringBuilder(10);
    System.out.println("Initial Capacity of str2: " + str2.capacity());
    
    CharSequence seq = "Physics";
    StringBuilder str3 = new StringBuilder(seq);
    System.out.println("str3: " + str3);

    StringBuilder str4 = new StringBuilder("Physics");
    System.out.println("str4: " + str4);
  }
}
