public class Palindrome {  
    public static boolean isPalindrome(int []arr , int n){
        int i = 0 , j = n - 1;
        while(i <= j){
            if(arr[i] != arr[j])return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String argvs[]) {  
     
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};  
        int len = arr.length;  
        System.out.println("For the input array: ");  
        for(int  i = 0; i < len; i++) System.out.print(arr[i] + " ");  
        System.out.println();
        System.out.println("Is the given array a palindrome: " + isPalindrome(arr , len));
    }  
} 
