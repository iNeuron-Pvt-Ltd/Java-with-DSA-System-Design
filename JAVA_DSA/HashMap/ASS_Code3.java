import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements of array: ");  
        
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter the elements of array: ");  
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> tm = new HashMap<>();
        int answer = 0;
        for(int i=0;i<n;i++){
            if(tm.containsKey(arr[i])){
                System.out.println("Yes");
                answer =1;
                break;
            }
            tm.put(arr[i], 1);
        }

        if(answer == 0)
            System.out.println("No");

    }
}
