import java.io.*;
import java.util.*;
public class Main{ 

    public static void main(String args[]){
    
        int m;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements you want to add : ");
        m=sc.nextInt();      
        
        int []arr = new int[m];
        
        System.out.print("Enter the elements of the array: ");
        
        for(int i=0;i<m;i++){
            arr[i] = sc.nextInt();
        }

        int element;
        System.out.print("Enter the elements to be searched in array");
        element = sc.nextInt();
        

        int idx = -1;
        for(int i=0;i<m;i++){
            if(arr[i]==element){
                idx = i;
                break;
            }
        }

        if(idx!=-1){
            System.out.println(idx);
        }
        else{
            System.out.println("Element not found in array");
        }
    }     
}
