// 0-based indexing used here 

import java.io.*;
import java.util.*;

public class Sort {
    public static void insertionSort(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int j = i;

            // Insert a[i] into sorted left part 0..i-1
            while (j > 0 && a[j] < a[j - 1]) {

                // Swap a[j] and a[j-1]
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;

                // Decrement j by 1
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
