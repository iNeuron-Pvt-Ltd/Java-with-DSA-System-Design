import java.io.*;
import java.util.*;
public class Main{ 
    
  public static void transpose(int A[][] , int N)
    {
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
    }
 
    public static void main(String args[]){
        
        int m;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of rows : ");
        m=sc.nextInt();    
        
        int arr[][]=new int[m][m];
        
        int i,j;    
           
        System.out.println("enter the  matrix element : ");    
        for(i=0;i<m;i++){    
            for(j=0;j<m;j++){    
                arr[i][j]=sc.nextInt();  
            }    
        }     
        
        transpose(arr , m);
        
        System.out.println("The transposed matrix is as follows : ");
        
        for(i=0;i<m;i++){    
            for(j=0;j<m;j++){    
                System.out.print(arr[i][j] + "  ");  
            }    
            System.out.println("");
        }
    }     
}