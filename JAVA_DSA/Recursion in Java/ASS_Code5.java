import java.util.*;
import java.util.Scanner;
public class Main{
        public static void main(String[] args){
                Scanner scn = new Scanner(System.in);
                System.out.println("Enter the number n: ");
                int n = scn.nextInt();
                int digits = 0;
                int temp = n;
                while(temp > 0){
                        digits++;
                        temp/=10;
                }
                if(n == isArmstrong(n , digits))
                        System.out.println("yes");
                else
                        System.out.println("no");
        }
        public static int power(int a, int b){
                if(b == 0)return 1;
                if(b%2 == 0)return power(a , b/2) * power(a , b/2);
                return a * power(a  , b/2) * power(a , b/2);
        }
        public static int isArmstrong(int n , int digits){
                if(n == 0)return 0;
                return power(n%10 , digits) + isArmstrong(n/10 , digits);
        }
}