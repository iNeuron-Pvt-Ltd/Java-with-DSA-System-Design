import java.util.*;

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length; 
        int m = matrix[0].length; 
        int hi = (n * m) - 1;
        
        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }

   public static void main(String args[]) {
      int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};   

      System.out.println("Is element 4 present: " + searchMatrix(matrix, 4));

      System.out.println("Is element 10 present: " + searchMatrix(matrix, 10));
   }
}
