import java.io.*;
import java.util.*;

public class Main{
    public static int minValue(int arr[], int n, int idx){
        if(idx == n - 1) return arr[n - 1];
        int minOfLaterIndices = minValue(arr, n, idx + 1);
        int minVal = Math.min(arr[idx], minOfLaterIndices);
        return minVal;
    }
    public static void main(String[] args) {
        int[] arr={3,10,13,12,5};
        int n=arr.length;
        System.out.println("The minimum value is : " + minValue(arr,n,0));
    }
}