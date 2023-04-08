import java.io.*;
import java.util.*;
 
public class Main{
    static int numberOfPaths(int m , int n , int i , int j){
      if(i >= m || j >= n)return 0; //if the current parameters have crossed the grid boundaries.
      if(i == m - 1 && j == n - 1)return 1; // if we have successfully rreached the ending point we can return 1 as we have already found one valid path
     
      int down = numberOfPaths(m , n , i + 1 , j); // moving down
      int right = numberOfPaths(m , n , i , j + 1); // moving right
      return down + right;
    }
    public static void main(String[] args){
        int n;
        System.out.println("Enter the first dimension : ");
        Scanner sc1 = new Scanner(System.in);
        n=sc1.nextInt();
        
        int m;
        System.out.println("Enter the second dimension : ");
        Scanner sc2 = new Scanner(System.in);
        m=sc2.nextInt();
        
        System.out.println("The number of possible paths are : " + numberOfPaths(n , m , 0 , 0));
    }  
}