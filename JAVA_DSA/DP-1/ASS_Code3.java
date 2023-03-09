class Main {
	public static int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        if(n == 1)return nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);
        
        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }
        
        return dp[n-1];
	}
	public static void main(String[] args){
	    int []nums = {1,2,3,1};
		System.out.println("The maximum profit a thief can make : " + rob(nums));
	}
}
