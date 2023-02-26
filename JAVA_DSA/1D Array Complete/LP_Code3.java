public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int n = 4;
        int sum = ((n + 1) * (n + 2)) / 2;
        for (int i = 0; i < n; i++) sum -= arr[i];

        System.out.println("The missing numer is : " + sum);
    }
}
