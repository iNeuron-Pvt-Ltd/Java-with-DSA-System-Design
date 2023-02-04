import java.io.*;
import java.util.*;
public class Main{ 
  
    public static int repeatedNumber(int[] a, int low, int high){
      int answer = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(a[mid] > mid)low = mid + 1;
            else {
                answer = a[mid];
                high = mid - 1;
            }
        }
     return answer;
    }

    public static void main(String args[]){
    
        int m;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements you want to add : ");
        m=sc.nextInt();      
        
        int []arr = new int[m];
        
        System.out.print("Enter the elements of the array: ");
        
        for(int i=0;i<m;i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.println("The repeated number in the given array is " + repeatedNumber(arr , 0 , m - 1));
    }     
}