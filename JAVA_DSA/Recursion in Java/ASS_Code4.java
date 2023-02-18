import java.util.*;
import java.util.Scanner;
public class Main{
    public static int totalSum(int []arr , int idx){
        if(idx == 0)return arr[idx];
        
        return arr[idx] + totalSum(arr , idx - 1);
    }
    public static void main(String[] args){
        int arr[] = {92,23, 15, -20, 10};
        int n = arr.length;
        
        System.out.println("The sum of all elements of the array is : " + totalSum(arr , n - 1));
    }
}