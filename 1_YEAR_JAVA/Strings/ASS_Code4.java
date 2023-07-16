import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        int num;
        // Input the integer
        System.out.println("Enter the integer: ");
        // Create Scanner object
        Scanner s = new Scanner(System.in);
        // Read the next integer from the screen
        num = s.nextInt();

    	StringBuilder result = new StringBuilder();
     
    	String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
     
    	int i = 0;
                //iterate until the number becomes zero, NO NEED to go until the last element in roman array
    	while (num >0) {
    		while ( num >= values[i]) {
    			num -= values[i];
    			result.append(roman[i]);
    		}
    		i++;
    	}
        String answer = result.toString();
        System.out.println("The roman numeral for given integer is : " + answer);
    }
}