public class CODE12 {
    public static void main(String[] args) {
        int[] arr = { 10, 7, -5, 8, 9, 0, -4 };
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        System.out.print(max);

    }
}
