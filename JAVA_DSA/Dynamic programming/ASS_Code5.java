class Main {
    public static int coinChange(int amount, int[] coins) {
        // Declaring a 2-D array for storing solutions to subproblems:
    	int size = coins.length;
    	int[][] arr = new int[size + 1][amount + 1];
    	
      // Initializing first column of array to 1 because a sum of 0 can be made in one possible way: {0}
    	for(int i = 0; i < size + 1; i++)arr[i][0] = 1;
    	
      // Applying the recursive solution:
    	for(int i = 1; i < size + 1; i++)
    		for(int j = 0; j < amount+ 1; j++)
    			if(coins[i - 1] > j)  // Cannot pick the highest coin:
    				arr[i][j] = arr[i - 1][j];
    			else  // Pick the highest coin:
    				arr[i][j] = arr[i][j - coins[i - 1]] + arr[i - 1][j];
    	
    	return arr[size][amount];
    }
  
	public static void main(String[] args){
       int amount = 5;
       int []nums = {1 , 2 , 5}; 
	   System.out.println("The desired output is : " + coinChange(amount , nums));
	}
}
