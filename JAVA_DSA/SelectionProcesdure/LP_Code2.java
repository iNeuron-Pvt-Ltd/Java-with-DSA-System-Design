import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {

  private static int MergeCountInv(int[] arr, int left, int right) {

    int countInv = 0;

    if (left < right) {
      int mid = (left + right) / 2;

      countInv += MergeCountInv(arr, left, mid);

      countInv += MergeCountInv(arr, mid + 1, right);

      countInv += arrayCountInv(arr, left, mid, right);
    }
    return countInv;
  }

  private static int arrayCountInv(int[] arr, int l, int m, int r) {
    int[] left = Arrays.copyOfRange(arr, l, m + 1);

    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

    int i = 0, j = 0, k = l, swaps = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j])
        arr[k++] = left[i++];
      else {
        arr[k++] = right[j++];
        swaps += (m + 1) - (l + i);
      }
    }
    while (i < left.length)arr[k++] = left[i++];
    while (j < right.length)arr[k++] = right[j++];
    return swaps;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of Array:");
    int n = sc.nextInt();
    int arr[] = new int[n];

    System.out.println("Enter array elements :");
    for (int x = 0; x < n; x++)
      arr[x] = sc.nextInt();
    System.out.println("Inversion Count is : " +MergeCountInv(arr, 0, n - 1));
  }
}

