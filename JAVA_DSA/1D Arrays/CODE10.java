public class CODE10 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
   	 int i = 0, sum = 0;
     while (i < arr.length) {
         sum += arr[i];
         i += 2;
     }
     System.out.println(sum);
    }
}
