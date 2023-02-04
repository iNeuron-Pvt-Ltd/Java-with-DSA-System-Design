
import java.io.*;
import java.util.*;
public class Main{ 
    public static void main(String args[]){
    
        int m,n;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of rows=");
        m=sc.nextInt();    
        System.out.print("enter the number of column=");    
        n=sc.nextInt();
        int arr1[][]=new int[m][n];
        
        int i,j;    
           
        System.out.println("enter the  matrix element=\n");    
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){  
                arr1[i][j]=sc.nextInt();  
            }    
        }     
        System.out.println("The elements that lie above the primary diagonal are as follows: ");
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(i < j)System.out.println(arr1[i][j]);
            }
        }
    }
}
