import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char element : chars) {
            if (element == '(' || element == '[' || element == '{') {
                stack.push(element);
                continue;
            } else if (stack.empty()) {
                return false;
            }
            char top = stack.pop();
            if (top == '(' && element != ')') {
                return false;
            } 
            else if (top == '[' && element != ']') {
                return false;
            }
            else if (top == '{' && element != '}') {
                return false;
            }
        }
        return (stack.empty() == true);
    }
    
	public static void main(String[] args){
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter the string: ");  
        String str= sc.nextLine();   
	
	    System.out.println("The given string is valid ? " + isValid(str));
	}
}
