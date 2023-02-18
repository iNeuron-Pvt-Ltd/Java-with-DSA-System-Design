       
import java.io.*;
import java.util.*;
 
public class Main{
    static int power(int a , int b){
        if(b == 0)return 1;
        return (a * power( a , b - 1));
    }
	public static void main(String[] args) {
	   int a = 3, b = 4;
	   int answer = power(a , b);
	   System.out.println("Required answer is " + answer );
	}
}
 