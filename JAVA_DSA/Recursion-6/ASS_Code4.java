import java.util.*;
class Main{
    static void go(int n , int k , ArrayList<Integer>answer){ 
        if(k == 0){
            if(n == 0){
                for(Integer x:answer)System.out.print(x + " ");
                System.out.println();
                return;
            }
            return;
        }
        for(int i=0;i<=n;i++){
            answer.add(i);
            go(n - i , k - 1 , answer);
            answer.remove(answer.size() - 1);
    }
}

    public static void main(String[] args){
    	int n = 4;int k = 3;
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	go(n , k , arr);
    }
}

