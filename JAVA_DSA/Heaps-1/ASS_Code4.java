import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
 
class Main{
    public static void transform(int[] input){
        Map<Integer, Integer> map = new TreeMap<>();
 
        // store (element, index) pair in `TreeMap`
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], i);
        }
        int rank = 1;
 
        // iterate through the map and replace each element with its rank
        for (var val: map.values()) {
            input[val] = rank++;
        }
    }
 
    public static void main(String[] args){
        int[] input = { 10, 8, 15, 12, 6, 20, 1 };
 
        // transform the array
        transform(input);
 
        // print the transformed array
        System.out.println(Arrays.toString(input));
    }
}
