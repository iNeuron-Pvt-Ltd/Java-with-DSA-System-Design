public class Main{
    static void climbingStairs(int n){
    	// Declare an array to store Fibonacci numbers. 
    	int dp[] = new int[n+1]; 
    	int i;
    	dp[0] = 1;  //here ith index denotes i+1 that are i+1 stairs available
    	dp[1] = 1; 
    	
    	for (i = 2; i <= n; i++){
    	// Add the previous 2 numbers in the series	and store it 
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	
        System.out.println("The possible ways are : " + dp[n]);
    }
	
	public static void main (String args[]){
		int n = 5;
		climbingStairs(n);
	}
};

