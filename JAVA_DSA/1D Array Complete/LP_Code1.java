public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        int n = 5;
        int flag = 0;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - i - 1]) {
                flag = 1;
                System.out.println("The given array is not a palindrome.");
                break;
            }
        }

        if (flag == 0) System.out.println("The given array is a palindrome.");

    }
}
