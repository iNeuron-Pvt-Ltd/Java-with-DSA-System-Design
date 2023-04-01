import java.io.*;
class Main {
	static int gcd(int a, int b){
    		if(b == 0)return a;
    		return gcd(b, a % b);  
    }
	public static void main (String[] args) {
	    	int a = 3 ; int b = 27;
		System.out.println(" GCD of " + a + " and " + b + " is : " + gcd(a , b));
	}
}