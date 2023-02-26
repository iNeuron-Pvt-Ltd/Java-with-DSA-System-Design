import java.util.*;
public class Main{
    public static void partition(int[] arr, int s, int e){
        int pIndex= s;
        for (int j = s; j <= e; j++) {
            if (arr[j] < 0){    // pivot is 0
                int temp = arr[j];
                arr[j] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = { 9, 20, -7, -4, 13, -11, -15, 3 };
        int n = arr.length;
        partition(arr, 0, n - 1);
        for (int i : arr) {
               System.out.print(i + " ");
        }
    }
}