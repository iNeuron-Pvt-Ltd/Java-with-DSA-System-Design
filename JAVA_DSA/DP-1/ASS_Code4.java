class Main {
    public static int uniquePaths(int m, int n) {
      //Two variables i.e. to go right or to got down so 2D array.  
        int dp[][]=new int[m+1][n+1];  
        return solve(0,0,m,n,dp);
    }
    public static int solve(int i,int j,int m,int n,int[][]dp){
        if(i == m - 1 &&  j == n - 1) return 1;
        if(i >= m || j >= n) return 0;
        
        if(dp[i][j]!=0) return dp[i][j];
        
       dp[i][j] = solve(i + 1 , j , m , n , dp) + solve(i , j + 1 , m , n , dp);//Two choices Either go right or go down. Answer would be the sum of both the combinations.        
      return dp[i][j];
    }
	public static void main(String[] args){
	    int m = 5 , n = 4;
		System.out.println("The desired output is : " + uniquePaths(m,n));
	}
}
    