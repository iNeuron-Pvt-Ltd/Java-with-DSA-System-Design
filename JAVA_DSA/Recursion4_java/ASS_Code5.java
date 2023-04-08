import java.util.*;
import java.util.Scanner;
public class Test{
    public static int countLowerCase(String str, int idx) {
        if(idx == str.length()-1){
            if(str.charAt(idx) >= 'a' && str.charAt(idx) <= 'z') return 1;
            return 0;
        }
        if(str.charAt(idx) >= 'a' && str.charAt(idx) <= 'z') return countLowerCase(str, idx + 1) + 1;
        return countLowerCase(str, idx + 1);
    }
    
    public static void main(String[] args){
         Scanner scn = new Scanner(System.in);
        System.out.println("Enter the input string: ");
        String str = scn.nextLine();
        System.out.println("Number of lowercase characters are : " + countLowerCase(str, 0));
    }
}
