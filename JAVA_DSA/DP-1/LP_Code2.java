public class Main{
    static void climbingStairs(int n){
        // Declare an array to store Fibonacci numbers. 
        int ways[] = new int[n+1]; 
        int i;
        ways[0] = 1;  //here ith index denotes i+1 that are i+1 stairs available
        ways[1] = 1; 
        
        for (i = 2; i <= n; i++){
        // Add the previous 2 numbers in the series and store it 
            ways[i] = ways[i-1] + ways[i-2];
        }
        
        System.out.println("The possible ways are : " + ways[n]);
    }
    
    public static void main (String args[]){
        int n = 5;
        climbingStairs(n);
    }
};

