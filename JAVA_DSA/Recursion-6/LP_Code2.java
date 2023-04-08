import java.util.*;
 
public class Main {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
 
    public static void printAllPalindromicPartitions(String s, ArrayList<String> ans, int start) {
        if (start == s.length()) {
            System.out.println(ans);
            return;
        }
        String curr = "";
        for (int end = start; end < s.length(); end++) {
            curr += s.charAt(end);
            if (isPalindrome(curr)) {
                ans.add(curr);
                printAllPalindromicPartitions(s, ans, end + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> ans = new ArrayList<>();
        printAllPalindromicPartitions(s, ans, 0);
    }
}
 