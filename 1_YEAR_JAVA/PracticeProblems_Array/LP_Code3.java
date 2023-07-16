public class Main {  
    public static int missingNumber(int[] nums) {
        int xor = 0, i = 0;
    	for (i = 0; i < nums.length; i++) {
    		xor = xor ^ i ^ nums[i];
    	}
    
    	return xor ^ i;
    }
    public static void main(String argvs[]) {  
     
        int arr[] = {3, 0, 1};  
        int len = arr.length;  
        System.out.println("For the input array: ");  
        for(int  i = 0; i < len; i++) System.out.print(arr[i] + " ");  
        System.out.println();
        System.out.println("The missing number is: " + missingNumber(arr));
    }  
}  
