import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main
{   public static int countSetBits(int n){
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
	public static void main(String[] args) {
		 int number;
		 System.out.println("Enter the integer: ");
 
        // Create Scanner object
        Scanner s = new Scanner(System.in);
 
        // Read the next integer from the screen
        number = s.nextInt();
        
        int answer = countSetBits(number);
        System.out.println("The number of set bits in the given number are " + answer);
	}
}
