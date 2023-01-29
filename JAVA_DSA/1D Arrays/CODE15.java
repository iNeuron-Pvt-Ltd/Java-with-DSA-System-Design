public class CODE15 {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 5, 4, 3, 2, 1 };

        int[] sum = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            sum[i] = arr1[i] + arr2[i];
            System.out.print(sum[i] + ", ");
        }

    }
}
