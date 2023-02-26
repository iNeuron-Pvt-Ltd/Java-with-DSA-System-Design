import java.util.*;
public class Main{
    public static void partition(int[] num, int[] temp, int l, int h){
        if (h <= l) {
            return;
        }
        // find midpoint
        int mid = (l + ((h - l) >> 1));

        partition(num, temp, l, mid);          // split/merge left half
        partition(num, temp, mid + 1, h);     // split/merge right half

        merge(num, temp , l, mid, h);        // join the two half runs
        }
        
        public static void merge(int[] num, int[] temp, int l, int mid, int h){
            int k = l;
            // copy negative elements from the left subarray
            for (int i = l; i <= mid; i++) {
                    if (num[i] < 0) {
                            temp[k++] = num[i];
                    }
            }
            // copy negative elements from the right subarray
            for (int j = mid + 1; j <= h; j++) {
                    if (num[j] < 0) {
                            temp[k++] = num[j];
                    }
            }
            // copy positive elements from the left subarray
            for (int i = l; i <= mid; i++) {
                    if (num[i] >= 0) {
                            temp[k++] = num[i];
                    }
            }
            // copy positive elements from the right subarray
            for (int j = mid + 1; j <= h; j++) {
                    if (num[j] >= 0) {
                            temp[k++] = num[j];
                    }
            }
            // copy back to the original array to reflect the relative order
            for (int i = l; i <= h; i++) {
                    num[i] = temp[i];
            }
        }
        public static void main(String[] args){
            int[] num = { 19, -20, 7, -4, -13 , 11 , -5 , 3};
            int n = num.length;
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                    temp[i] = num[i];
            }
            partition(num, temp, 0, n - 1);
            for (int i = 0; i < n; i++) {
                    System.out.print(num[i] + " ");
            }
        }
}