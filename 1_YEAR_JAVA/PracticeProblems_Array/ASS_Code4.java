import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Main
{  public static int findOddOccuring(int[] arr)
    {
        int xor = 0;
        for (int i: arr) {
            xor = xor ^ i;
        }
        return xor;
    }
	public static void main(String[] args) {
		int n;  
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter the number of elements you want to store: ");  
        //reading the number of elements from the that we want to enter  
        n=sc.nextInt();  
        //creates an array in the memory of length 10  
        int[] array = new int[10];  
        System.out.println("Enter the elements of the array: ");  
        for(int i=0; i<n; i++)  
        {  
        //reading array elements from the user   
            array[i]=sc.nextInt();  
        }
     System.out.println("The odd occurring element is " + findOddOccuring(array));
	}
}
