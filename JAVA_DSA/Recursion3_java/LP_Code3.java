import java.io.*;
class Main {
	static public int kthGrammar(int N, int K) {
        if(N==1) return 0;
        if(K%2==0){
            if (kthGrammar(N-1,K/2)==0) return 1;
            else return 0;
        }
        else{
            if(kthGrammar(N-1,(K+1)/2)==0) return 0;
            else return 1;
        }
    }
	public static void main (String[] args) {
	    int n = 5 ; int k = 3;
		System.out.println(" The desired output is : " + kthGrammar(n , k));
	}
}