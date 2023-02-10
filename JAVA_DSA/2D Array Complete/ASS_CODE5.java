import java.io.*;
import java.util.*;
public class Main{ 
    public static void main(String args[]){
    
        int m,n;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of rows : ");
        m=sc.nextInt();    
        
        int arr[][]=new int[m][m];
        
        int i,j;    
           
        System.out.println("enter the  matrix element : ");    
        for(i = 0 ; i < m ; i++){    
            for(j = 0 ; j < m ; j++){    
                arr[i][j]=sc.nextInt();  
            }    
        }  
        
        System.out.println("The elements  of the middle row and middle column are as follows : ");
        
         for(i = 0 ; i < m ; i++)System.out.print(arr[i][m/2] + "  ");    
         for(j = 0 ; j < m ; j++){
            if(j == m/2)continue;
            System.out.print(arr[m/2][j] + "  ");
        }
    }     
}
