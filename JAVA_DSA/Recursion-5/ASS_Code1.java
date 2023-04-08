import java.util.*;
 
public class Main {
    public static int count(String s, int i, int j, int n) {
        if (n == 1) return 1;
        if (n <= 0) return 0;
 
        int answer = count(s, i + 1, j, n - 1) + count(s, i, j - 1, n - 1) - count(s, i + 1, j - 1, n - 2);
        if (s.charAt(i) == s.charAt(j)) answer++;
        return answer;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        System.out.println(count(s, 0, n - 1, n));
    }
}