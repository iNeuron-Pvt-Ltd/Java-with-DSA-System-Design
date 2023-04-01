import java.io.*;
class Main {
	static int gcd(int a, int b){
        if (a == 0 || b == 0) return 0;
        if (a == b) return a;
        if (a > b) return gcd(a-b, b);
        return gcd(a, b-a);
    }
	public static void main (String[] args) {
	    int a = 33 ; int b = 27;
		System.out.println(" GCD of " + a + " and " + b + " is : " + gcd(a , b));
	}
}