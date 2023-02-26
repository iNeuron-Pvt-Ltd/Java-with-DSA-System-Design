import java.io.*;
import java.util.*;

public class Main{
    public static int partition (int arr[], int first, int last)  {  
        // To introduce randomness in selecting pivot element.
        int randomIndex = first + (int) Math.random() % (last - first + 1);
        int tem = arr[randomIndex];
        arr[randomIndex] = arr[last];
        arr[last] = tem;
     
        int pivot = arr[last]; // pivot element  
        int i = (first - 1);  
     
        for (int j = first; j <= last - 1; j++)  
        {  
            // If current element is smaller than the pivot  
            if (arr[j] < pivot)  
            {  
                i++; // increment index of smaller element  
                int temp = arr[i];  
                arr[i] = arr[j];  
                arr[j] = temp;  
            }  
        }  
           int temp = arr[i+1];  
            arr[i+1] = arr[last];  
            arr[last] = temp;  
        return (i + 1);  
    }  
 
    public static void quickSort(int arr[], int first, int last){  
        if (first < last)  {  
            int p = partition(arr, first, last);  //p is partitioning index  
            quickSort(arr, first, p - 1);  
            quickSort(arr, p + 1, last);  
        }  
    }  
 
	public static void main(String[] args) {
	    int arr[] = {2 , 1 , 5 , 3 , 8 , 9};
        int n = arr.length;
        quickSort(arr, 0, n-1);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
	}
}
