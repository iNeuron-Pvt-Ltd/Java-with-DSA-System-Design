import java.io.*;
import java.util.*;
public class Main{ 
  
    public static boolean isPerfectSquare(int num) {
       if(num == 1) return true ;  // edge case
       long start = 0 ;   // Take Long as the inputs have large value
       long end = num /2 ;
        while(start <= end ){
            long mid = start + ( end - start ) / 2 ;
            if (mid * mid > num)   end = mid - 1 ; // Mid is greater than the squareroot of the number
            else if (mid * mid < num) start = mid + 1 ;  // Mid is less than our required number
            else  return true;     // we found our squareroot number
            }
        return false ;
    }

    public static void main(String args[]){
        int m;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number : ");
        m=sc.nextInt();      
       
        System.out.println("The given number is a perfect square: " + isPerfectSquare(m));
    }     
}
