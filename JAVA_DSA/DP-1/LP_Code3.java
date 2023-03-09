import java.util.*;
public class Main{
    public static int coinChange(int[] coins, int amount) {
        if(amount <= 0 || coins.length == 0) return 0;
        int[] sums = new int[amount + 1]; // DP array to keep track of the minimum coins to reach each sum
        Arrays.fill(sums, Integer.MAX_VALUE);
        sums[0] = 0;
        for(int i=0; i<coins.length; i++){
            for(int j=0; j<sums.length; j++){ // for every sum from 0 -> amount.
                if(j >= coins[i] && sums[j - coins[i]] != Integer.MAX_VALUE) { 
                    sums[j] = Math.min(sums[j], 1 + sums[j - coins[i]]); // take minimum coins needed
                }
            }
        }
        if(sums[sums.length-1] == Integer.MAX_VALUE) return -1;
        return sums[sums.length-1];
    }
	
	public static void main (String args[]){
		int []coins = {1,2,5};
		int amount = 11;
		
		System.out.println("The minimum number of coins are : " + coinChange(coins , amount));
	}
};

