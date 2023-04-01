import java.io.*;
import java.util.*;
public class Main{
    public static boolean exists(int []a , int n , int target , int index){
        if(index >= n)return false;
        if(a[index] == target)return true;
        return exists(a , n , target , index + 1);
    }
    public static void main(String[] args) {
        int[] arr={2,3,5,20,1};
        int n=arr.length;
        int target = 5;
        System.out.println("Is target present in the array :  " + exists(arr , n , target , 0));
    }
}