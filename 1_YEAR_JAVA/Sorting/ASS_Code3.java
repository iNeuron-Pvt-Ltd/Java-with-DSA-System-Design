import java.io.*;
import java.util.*;

public class Sort {
    // 0 based indexing used
    public static void selectionSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++)
        // i represents the current index
        {

            // Find the maximum element in unsorted part of the array
            int max_index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[max_index])
                    max_index = j;
            }

            // Swap the found maximum element with the current element
            if (max_index != i) {
                int temp = a[max_index];
                a[max_index] = a[i];
                a[i] = temp;
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
        selectionSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }


}
