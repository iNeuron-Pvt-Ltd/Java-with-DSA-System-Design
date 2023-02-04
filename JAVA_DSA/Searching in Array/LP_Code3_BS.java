import java.io.*;
import java.util.*;
public class Main{ 
   public static int search(int[] a, int x){
	int n = a.length, l = 0, r = n-1, answer = -1;
	        
	while(l <= r) {
	    int mid = (l+r)/2;
	    if(a[mid] == x) {
	    	answer = mid;
	    	r = mid-1;  // trying to find the minimum index at which value x is present 
	    }
	    else if(a[mid] > x) {
	        r = mid-1;
	    } else l = mid+1;
	}

	return answer;
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
        
        int answer = search(arr , target);
        if(answer != -1)System.out.println("The first occurrence of given target is at " + answer);
        else System.out.println("The element does not occur, therefore value of answer is " + answer);
    }     
}
