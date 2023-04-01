import java.io.*;
class Main {
    static int sum(int n , int i) {
        if (i == n + 1) return 0;
        return i + sum(n , i + 1);    
    }
	public static void main (String[] args) {
	    int n = 5 ;
		System.out.println(" The desired output is : " + sum(n , 1));
	}
}