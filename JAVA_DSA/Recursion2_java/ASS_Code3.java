import java.io.*;
import java.util.*;

public class Main{
    static void go(int n  , int i){
        if(i == n + 1)return;
        System.out.print(i*i + " ");
        go(n , i + 1);
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        go(n,1);
	}
}