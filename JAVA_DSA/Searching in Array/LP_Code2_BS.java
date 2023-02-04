import java.io.*;
import java.util.*;
public class Main{ 
    public static int binarySearch(int []a, int target){
        int low = 0, high = a.length - 1;       // 0 based indexing
        while (low <= high) {
            int mid = low + (high - low) / 2;    // to avoid integer overflow
    
            if (a[mid] == target)return 1;  		        // value found
            else if (a[mid] > target)high = mid - 1;
            else low = mid + 1;
          }
        return 0; 			   	// value not found in the array
    }

    public static void main(String args[]){
    
        int m;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of elements you want : ");
        m=sc.nextInt();    
        
        int arr[] = new int[m];
        
        int i;
           
        System.out.println("enter the elements : ");    
        for(i = 0 ; i < m ; i++){    
            arr[i]=sc.nextInt();  
        }  
        
        int target;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("enter the target: ");
        target = sc1.nextInt();
        
        if(binarySearch(arr , target) == 1)System.out.println("True");
        else System.out.println("False");
    }     
}
