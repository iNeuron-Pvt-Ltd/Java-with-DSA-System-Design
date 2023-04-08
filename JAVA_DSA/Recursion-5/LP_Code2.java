import java.io.*;
import java.util.*;
 
public class Main{
    static void sumSubset(ArrayList<Integer>a , int n , int index , ArrayList<Integer>result , int sum){
        if(index >= n){
            result.add(sum);
            return;
        }
     
        sumSubset(a , n , index + 1 , result , sum);
        sumSubset(a , n , index + 1 , result , sum + a.get(index));
    }
 
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>(n);
        
        for(int i = 0 ; i < n ; i++){
            int temp=sc.nextInt();
            a.add(temp);
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int sum = 0;
        sumSubset(a , n , 0 , res , sum);
     
        for (int i = 0; i<res.size(); i++) System.out.print(res.get(i) + " ");
 
    }  
}