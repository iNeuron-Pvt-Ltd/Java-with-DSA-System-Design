import java.io.*;
import java.util.*;
import java.util.Stack; 

class Test {
    public static void main(String[] args){

        // Default initialization of Stack
        Stack<Integer> stack1 = new Stack();

        // pushing the elements
        stack1.push(1);
        stack1.push(2);
        
        //popping the Element

        stack1.pop();
        
        System.out.println("The peek element of the stack is : " + stack1.peek());

        stack1.push(3);
        stack1.push(5);
        
        //printing the peek element
        System.out.println("The peek element of the stack is : " + stack1.peek());
        
        //popping the Element        
        
        
        stack1.pop();
        
        System.out.println("The peek element of the stack is : " + stack1.peek());
      
        
        
        // Printing the Stack Elements
        
        System.out.println("The stack elements are as follows : " + stack1);
    }
}
