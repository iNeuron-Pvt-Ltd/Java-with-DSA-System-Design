import java.io.*;
import java.util.*;

class Main {
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        remove(sb, 0);
        return sb.toString();
    }
    
    private static void remove(StringBuilder answer, int start) {
        for(int i = start; i < answer.length() - 1; i++) {
            char c = answer.charAt(i);
            char c2 = answer.charAt(i + 1);
            if(c == c2) {
                answer.deleteCharAt(i);
                if(i - 1 >= 0) remove(answer, i - 1); 
                else remove(answer, i);
            }
        }
    }
	public static void main(String args[]){
		String str = "pppwwsskillssss";
		System.out.println("The desired output is : " + removeDuplicates(str));

	}
}
