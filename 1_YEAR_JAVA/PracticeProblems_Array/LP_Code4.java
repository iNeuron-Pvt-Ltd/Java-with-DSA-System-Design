public class Main {  
    private static int lower_bound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low] == target? low : -1;
    }   
    public static void main(String argvs[]) {  
     
        int arr[] = {1,2,4,5,8,19,20};  
        int len = arr.length;  
        System.out.println("For the input array: ");  
        for(int  i = 0; i < len; i++) System.out.print(arr[i] + " ");  
        System.out.println();
        int tgt = 8;
        System.out.println("The given target value is :" + tgt);
        System.out.println("The lower bound of the given target is: " + lower_bound(arr , tgt));
    }  
}  
