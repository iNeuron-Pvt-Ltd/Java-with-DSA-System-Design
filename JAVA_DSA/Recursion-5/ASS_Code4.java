import java.util.*;
 
public class Main {
    public static void printStringsOfLengthK(Character[] chars, int remainingChars, String ans) {
        if (remainingChars == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < chars.length; i++)
            printStringsOfLengthK(chars, remainingChars - 1, ans + Character.toString(chars[i]));
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Character[] chars = new Character[n];
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
        }
        int k = sc.nextInt();
        printStringsOfLengthK(chars, k, "");
    }
}
 