import java.io.*;
import java.util.*;
public class Main{ 
  public static void main(String args[]){
    
    int m,n;
    Scanner sc=new Scanner(System.in);
    System.out.print("enter the number of rows : ");
    m=sc.nextInt();    
    System.out.print("enter the number of column : ");    
    n=sc.nextInt();
    int arr[][]=new int[m][n];
    
    int i,j;    
       
    System.out.println("enter the  matrix element : ");    
    for(i = 0 ; i < m ; i++){    
        for(j = 0 ; j < n ; j++){    
            arr[i][j]=sc.nextInt();  
        }    
    }  
    
    int maximum = -100000008;
     for(i = 0 ; i < m ; i++){    
        for(j = 0 ; j < n ; j++){    
            if(maximum < arr[i][j])maximum = arr[i][j];  
        }    
    }
    
    System.out.println("The maximum element in this matrix is : " + maximum);
    }     
}
