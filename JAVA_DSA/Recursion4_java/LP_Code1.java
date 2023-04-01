import java.io.*;
import java.util.*;

public class Main{
    public static int maxValue(int arr[], int n, int idx){
        if(idx == n - 1) return arr[n - 1];
        int maxOfLaterIndices = maxValue(arr, n, idx + 1);
        int maxVal = Math.max(arr[idx], maxOfLaterIndices);
        return maxVal;
    }
    public static void main(String[] args) {
        int[] arr={3,10,13,12,5};
        int n=arr.length;
        System.out.println("The maximum value is : " + maxValue(arr,n,0));
    }
}