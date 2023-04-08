import java.util.*;
 
public class Main {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }
    
    public static void main(String[] args) {
        int n = 5 , k = 3;
        List<List<Integer>>answer;
        
        answer = combine(n , k);
        
        for(List<Integer> x:answer){
            for(Integer y:x)System.out.print(y + " ");
            System.out.println();
        }
    }
}
 