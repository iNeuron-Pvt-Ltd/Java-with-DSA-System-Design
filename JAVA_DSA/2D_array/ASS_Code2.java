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
    for(i=0;i<m;i++){    
        for(j=0;j<n;j++){    
            arr[i][j]=sc.nextInt();  
        }    
    }     
    
    int l1 , r1 , l2  , r2;
    
    Scanner sc1=new Scanner(System.in);
    System.out.print("enter the value of l1 coordinate :");
    l1=sc1.nextInt();
    
    Scanner sc2=new Scanner(System.in);
    System.out.print("enter the value of r1 coordinate :");
    r1=sc2.nextInt();
    
    Scanner sc3=new Scanner(System.in);
    System.out.print("enter the value of l2 coordinate :");
    l2=sc3.nextInt();
    
    Scanner sc4=new Scanner(System.in);
    System.out.print("enter the value of r2 coordinate :");
    r2=sc4.nextInt();
    
    int sum = 0;
    for(i = l1 ; i <= l2 ; i++){
        for(j = r1 ; j <= r2 ; j++){
            sum += arr[i][j];
        }   
    } 
   
   System.out.println("The sum of the elements of given rectangle is : " + sum);
   
    }     
}
