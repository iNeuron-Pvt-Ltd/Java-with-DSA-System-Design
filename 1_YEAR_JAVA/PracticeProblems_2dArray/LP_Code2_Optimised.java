import java.util.*;


public class Main {

    public static void stairCaseSearch(int[][] arr, int data) {
        int row = 0;
        int col = arr[0].length - 1;
        int m = arr.length;
        while (row < m && col >= 0) {
            if (arr[row][col] == data) {
                System.out.println("Element " + data + " found at " + row + ", " + col);

                return;
            }
            if (arr[row][col] > data) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Element " + data + " not found");
    }

    public static void main(String[] args) throws Exception {

        int[][] arr = {
            {
                1,
                2,
                3
            },
            {
                4,
                5,
                6
            },
            {
                7,
                8,
                9
            }
        };
        stairCaseSearch(arr, 4);
        stairCaseSearch(arr, 10);

    }
}
