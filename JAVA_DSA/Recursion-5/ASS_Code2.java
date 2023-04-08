import java.util.*;
public class Main {
    public static void generateSubstrings(String str, int n, int index, String curr) {
        if (index == n) {
            return;
        }
        System.out.println(curr);
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            generateSubstrings(str, n, i, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
        return;
    }
 
    public static String sort(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = sort(s);
        generateSubstrings(s, s.length(), -1, "");
    }
}
 