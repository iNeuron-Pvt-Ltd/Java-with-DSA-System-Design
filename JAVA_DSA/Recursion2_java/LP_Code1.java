import java.io.*;
class Main {
	static int sumOfDigits(int n){
	    if(n==0)return 0;
	    return n%10 + sumOfDigits(n/10);
	}
	
	public static void main (String[] args){
		int n = 1543;
		System.out.println("The sum of digits are : " + sumOfDigits(n));
	}
}