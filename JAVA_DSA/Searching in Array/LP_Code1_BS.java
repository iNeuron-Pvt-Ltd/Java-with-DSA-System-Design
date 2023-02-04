import java.io.*;
import java.util.*;
public class Main{ 
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
        
        int flag = 0;
        
         for(i = 0 ; i < m ; i++){
             if(arr[i] == target){
                 System.out.println("True");
                 flag = 1;
                 break;
             }
         }
         
         if(flag == 0)System.out.println("False");
    }     
}
