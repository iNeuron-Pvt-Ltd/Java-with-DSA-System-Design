import java.util.*;
import java.util.Scanner;
public class Main{
    
   public static boolean helper(int []arr , int []vis , int startIndex , int curr_sum , int target , int k)
    {
        if(k==1)return true;
        if(curr_sum>target) return false;
        if(curr_sum==target)return helper(arr,vis,0,0,target,k-1);

        for(int i=startIndex;i<arr.length;i++){
            if(vis[i]==-1){
                vis[i]=1;
                if(helper(arr,vis,i+1,curr_sum+arr[i],target,k) == true)return true;
                vis[i]=-1;
            }
        }
        return false;
    }
    public static boolean canPartition(int []arr, int k) {
        int n=arr.length;
        int []vis = new int[n];
        for(int i=0;i<n;i++)vis[i] = -1;
        int sum=0;
        for(int i=0;i<n;i++)sum+=arr[i];
       
        if(sum%k!=0)return false;
        return helper(arr,vis,0,0,sum/k,k);
    }
    public static void main(String[] args){
        int []arr = {1 , 2 , 2 , 3};
        int n = 4;
        int k = 2;
        
        if(canPartition(arr , k) == true){
            System.out.println("yes it is possible to partition the array.");
        }
        else System.out.println("no it is not possible to partition.");
    }
}
