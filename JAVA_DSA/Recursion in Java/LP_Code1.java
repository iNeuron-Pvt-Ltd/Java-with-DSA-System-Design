import java.util.Scanner; 
public class Main
{
    public static int factorial(int n) {
	if(n == 1) 
		return 1;
	int fact = n * factorial(n - 1);
	return fact;
    }
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);    
        System.out.print("Enter the number : ");  
        int n = sc.nextInt();  
        
        System.out.print("The factorial is : " + factorial(n));  
	}
}
