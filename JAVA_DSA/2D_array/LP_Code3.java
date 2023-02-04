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
        
        int trans[][]=new int[m][n];
        
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                trans[i][j]=arr1[j][i];
            }
        }
        
        System.out.println("The transposed matrix is as follows : "); 
        
        //for printing result    
        for(i=0;i<m;i++){    
            for(j=0;j<n;j++){    
               System.out.print(trans[i][j] + " ");    
            }    
            System.out.println("");   
        }    
    } 
}
