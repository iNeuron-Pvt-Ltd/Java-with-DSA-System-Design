import java.io.*;
import java.util.*;
public class Main{
    public static int total(int arr[], int n){
        if (n <= 0) return 0;
        return (total(arr, n - 1) + arr[n - 1]);
    }
    public static void main(String[] args) {
        int[] arr={2,3,5,20,1};
        int n=arr.length;
        System.out.println("The total sum is : " + total(arr,n));
    }
}