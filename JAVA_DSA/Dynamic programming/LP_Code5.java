import java.io.*;
class Main {
	static int catalanDP(int n){
		// Table to store results of subproblems
		int catalan[] = new int[n + 2];

		// Initialize first two values in table
		catalan[0] = 1;
		catalan[1] = 1;

		// Fill entries in catalan[] using recursive formula
		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++) {
				catalan[i]
					+= catalan[j] * catalan[i - j - 1];
			}
		}
		return catalan[n];
	}
	public static void main(String[] args) {
		
	    int n = 12;
	    System.out.println("The desired output is : " + catalanDP(n));
	}
}