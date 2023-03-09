import java.util.*;
class Main {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i =n-1;i>=0;i--){
            for(int j=i+1; j< n;j++){
                if(nums[j] > nums[i]) dp[i] = Math.max(dp[i], 1+dp[j]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
  
	public static void main(String[] args){
       int []nums = {0,1,0,3,2,3};
	   System.out.println("The desired output is : " + lengthOfLIS(nums));
	}
}
