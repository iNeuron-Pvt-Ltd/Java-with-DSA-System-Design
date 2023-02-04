import java.util.Scanner;
import java.io.*;
 
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no of rows : ");
        int row = sc.nextInt();
        System.out.println("Enter the number of columns : ");
        int col = sc.nextInt();
        int arr[][] = new int[row][col];
        int total = row * col;


        System.out.println("Please enter " + total + " elements nows.");

        // read array elements row wise.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
       
        int sum = 0;
       
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)sum += arr[i][j];
        }
       
        System.out.println("The sum of the matrix is " + sum);
    }
}
