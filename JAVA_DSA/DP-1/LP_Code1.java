public class Main{
    static void fibonacciSeries(int n){
    	// Declare an array to store Fibonacci numbers. 
    	int dp[] = new int[n+1]; // 1 extra to handle case, n = 0
    	int i;
    	dp[0] = 0;
    	dp[1] = 1;
    	
    	for (i = 2; i <= n; i++){
    	// Add the previous 2 numbers in the series	and store it 
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	
    	for(int val : dp)System.out.print(val + " ");
    	System.out.println();
    }
	
	public static void main (String args[]){
		int n = 11;
		fibonacciSeries(n);
	}
};

