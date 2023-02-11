import java.io.*;
import java.util.*;
public class Main{ 
  public static int squareRoot(int x) {
        int low = 0, high = x, answer = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            long val = mid * mid; // you can use long to avoid overflow error
            if(val == x) return mid;
            else if(val < x) {
                answer = mid;
                low = mid + 1;
            } 
            else high = mid - 1; 
        }
        
        return answer;
    }

    public static void main(String args[]){
    
        int m;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number whose square root you want : ");
        m=sc.nextInt();      
        
        System.out.println("The square root of the given number is : " + squareRoot(m));
    }     
}
