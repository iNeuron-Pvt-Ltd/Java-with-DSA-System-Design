import java.io.*;
import java.util.*;


public class Main
{   static int func(int n)
{
    if (n == 0)
    return 0;
    return (n % 10 + func(n / 10));
}
	public static void main(String[] args) {
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int ans = func(n);
		System.out.println(" Sum of digits in " + n
       + " is " + ans );
	}
}

 