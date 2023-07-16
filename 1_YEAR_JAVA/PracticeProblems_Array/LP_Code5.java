import java.util.Scanner;  
public class Main {  
    public static void main(String[] args) {  
        double number = 0, sqrt=0;  
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter a number: ");  
        number = sc.nextDouble();  
        sqrt = squareRoot(number);  
        System.out.println("The square root of "+ number + " is " + sqrt);  
    }  
    private static double squareRoot(double number) {  
        int i = 1;  
        while(true) {  
            if(i*i == number) return i;  
            else if(i*i > number) return decimalSqrt(number,i-1,i);  
            i++;  
        }  
    }  
    private static double decimalSqrt(double number, double i, double j) {  
        double midvalue = (i+j)/2;  
        double square = midvalue * midvalue;  
        if(square==number||Math.abs(square-number)<0.0000001) return midvalue;   
        else if(square>number) return decimalSqrt(number, i, midvalue);  
        else return decimalSqrt(number, midvalue, j);  
    }  
}  
