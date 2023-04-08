import java.util.*;
 
public class Main {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return helper(obstacleGrid,0,0,m,n);
    }
    public static int helper(int[][] grid,int r,int c,int m,int n){
        if(r == m || c == n || grid[r][c] == 1)return 0;
        if(r == m-1 && c == n-1){
            if(grid[r][c] == 1)return 0;
            return 1;
        }
        return helper(grid,r+1,c,m,n) + helper(grid,r,c+1,m,n);
    }
    
    public static void main(String[] args) {
        int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("The desired output is : " + uniquePathsWithObstacles(obstacleGrid));
    }
}
 