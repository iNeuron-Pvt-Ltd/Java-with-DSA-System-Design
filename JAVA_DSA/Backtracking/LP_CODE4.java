import java.io.*;
 import java.util.*;

 public class RatInMaze {
     private static final int N = 5;

     //the maze problem
     private static int[][] maze = {
         {0,1,0,1,1},
         {0,0,0,0,0},
         {1,0,1,0,1},
         {0,0,1,0,0},
         {1,0,0,1,0}
     };

     //matrix to store the solution
     private static int[][] solution = new int[N][N];

     //function to print the solution matrix
     private static void printSolution() {
         for(int i=0;i<N;i++) {
             for(int j=0;j<N;j++) {
                 System.out.print(solution[i][j]+"\t");
             }
             System.out.print("\n\n");
         }
     }

     //function to solve the maze using backtracking
     private static boolean solveMaze(int r, int c) {
         //if destination is reached, maze is solved
         //destination is the last cell(maze[N-1][N-1])
         if((r==N-1) && (c==N-1)) {
             solution[r][c] = 1;
             return true;
         }
         //checking if we can visit in this cell or not
         //the indices of the cell must be in (0,N-1)
         //and solution[r][c] == 0 is making sure that the cell is not already visited
         //maze[r][c] == 0 is making sure that the cell is not blocked
         if(r>=0 && c>=0 && r<N && c<N && solution[r][c] == 0 && maze[r][c] == 0) {
             //if safe to visit then visit the cell
             solution[r][c] = 1;
             //going down
             if(solveMaze(r+1, c))
                 return true;
             //going right
             if(solveMaze(r, c+1))
                 return true;
             //going up
             if(solveMaze(r-1, c))
                 return true;
             //going left
             if(solveMaze(r, c-1))
                 return true;
             //backtracking
             solution[r][c] = 0;
             return false;
         }
         return false;

     }

     public static void main(String[] args) {
         if (solveMaze(0,0)){
             printSolution();
             System.out.println();
         }
         else
             System.out.println("No solution\n");
     }
 }
