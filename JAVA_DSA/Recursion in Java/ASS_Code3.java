// Recursive java program to find maximum element in an array
// function to print maximum element using recursion
import java.io.*;
import java.util.*;
public class Main{
    public static int maxValue(int arr[], int n, int idx){
        if(idx == n - 1)
        return arr[n - 1];
        int maxOfLaterIndices = maxValue(arr, n,idx + 1);
        int maxVal = Math.max(arr[idx], maxOfLaterIndices);
        return maxVal;
    }
    public static void main(String[] args) {
        int[] arr={13,1,-3,22,5};
        int n=arr.length;
        System.out.println("The max value is : " + maxValue(arr,n,0));
    }
}