import java.util.*;
class Main{
    static void printVector(ArrayList<Integer> arr){
    	if (arr.size() != 1){
    		for(int i = 0; i < arr.size(); i++){
    			System.out.print(arr.get(i) + " ");
    		}
    		System.out.println();
    	}
    }
    static void findWays(ArrayList<Integer> arr,int i, int n){
    	if (n == 0)
    		printVector(arr);
    
    	for(int j = i; j <= n; j++){
    		arr.add(j);
    		findWays(arr, j, n - j);
    		arr.remove(arr.size() - 1);
    	}
    }

    public static void main(String[] args){
    	int n = 4;
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	findWays(arr, 1, n);
    }
}

