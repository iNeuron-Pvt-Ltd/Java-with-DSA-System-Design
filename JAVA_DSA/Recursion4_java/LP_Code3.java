import java.io.*;
import java.util.*;

public class Main{
    public static boolean isPalindrome(String str , int start , int end){
        if(start >= end)return true;
        if(str.charAt(start) != str.charAt(end))return false;
        return isPalindrome(str , start + 1 , end - 1);
    }
    public static void main(String[] args) {
        String str = "PWskillsslliksWP";
        System.out.println("Is the given string a palindrome : " + isPalindrome(str , 0 , 15));
    }
}