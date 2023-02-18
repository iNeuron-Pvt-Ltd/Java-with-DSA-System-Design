import java.io.*;
import java.util.*;

public class Main{
    static int power(int a , int b){
        if(b == 0) //Base Condition
            return 1;
        if(b%2 == 0){
            int result = power(a,b/2);
            return result*result;
        }
        else{
            int result = power(a,(b-1)/2);
            return a*result*result; 
        }
    }
	public static void main(String[] args) {
	   int a = 3, b = 4;
	   System.out.println("Required power is " + power(a, b));
	}
}

 


 
