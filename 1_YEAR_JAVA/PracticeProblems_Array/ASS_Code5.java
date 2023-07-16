import java.util.Scanner;
public class Main{
        public static void main(String[] args){
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter the length of the array: ");
            int n = scn.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements of the array: ");
            for(int i = 0; i < n; i++){
                    arr[i] = scn.nextInt();
            }
            //insertion sort
            for (int i = 1; i < arr.length; i++) {
                int j = i;
                // Insert a[i] into sorted left part 0..i-1
                while (j > 0 && arr[j] < arr[j - 1]) {
                    // Swap a[j] and a[j-1]
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    // Decrement j by 1
                    j--;
                }
            }
            int a = 0;
            int b = 0;
            for(int i = 0; i < arr.length; i++){
                if(i % 2 == 0){
                        a = a * 10 + arr[i];
                }else{
                        b = b * 10 + arr[i];
                }
            }
            System.out.println(a + b);
        }
}
