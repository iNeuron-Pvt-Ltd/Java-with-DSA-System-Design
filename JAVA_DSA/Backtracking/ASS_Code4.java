import java.util.*;


public class Main {
   static int n;
   public static boolean findProduct(int n, int target, int a[], int i, int product) {
       if (i == n) return (product == target);
       boolean answer = false;

       product *= a[i];
       
       answer |= findProduct(n, target, a, i + 1, product);
       
       product /= a[i];
       
       answer |= findProduct(n, target, a, i + 1, product);

       return answer;
   }
   public static void main(String[] args) {
       
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number of elements you want and the value of target respectively : ");
       
       int n = sc.nextInt(), target = sc.nextInt();
       int a[] = new int[n];
       System.out.println("Enter the array elements");
       for (int i = 0; i < n; i++) {
           a[i] = sc.nextInt();
       }
       System.out.println((findProduct(n, target, a, 0, 1) ? "YES" : "NO"));
   }
}
