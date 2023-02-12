import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		int number;
		 System.out.println("Enter the integer: ");
 
        // Create Scanner object
        Scanner s = new Scanner(System.in);
 
        // Read the next integer from the screen
        number = s.nextInt();
        
        if((number & 1) == 1) System.out.println("Given number is odd.");
        else  System.out.println("Given number is even.");
	}
}

