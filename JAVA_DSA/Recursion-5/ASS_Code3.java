import java.util.*;
 
public class Main {
    public static void printNDigitNumber(int start, String out, int n) {
        if (n == 0) {
            System.out.print(out + " ");
            return;
        }
        for (int i = start; i <= 9; i++) {
            String str = out + Integer.toString(i);
            printNDigitNumber(i + 1, str, n - 1);
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        printNDigitNumber(0, " ", n);
    }
}
 