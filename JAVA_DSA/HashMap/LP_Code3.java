import java.util.*;
import java.util.Map;
import java.io.*;
  
public class Test {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");  
        //reading the number of elements from the that we want to enter  
        int n=sc.nextInt();  
        //creates an array in the memory of length 10  
        int[] array = new int[10];  
        System.out.println("Enter the elements of the array: ");  
        for(int i=0; i<n; i++) {  
            //reading array elements from the user   
            array[i]=sc.nextInt();  
        }  

        System.out.println("Enter the target element of the array: ");  

        //Enter target element
        int target = sc.nextInt();


        HashMap<Integer, Integer> hm= new HashMap<>();

        //Store every element in Map

        for(int i=0;i<n;i++){
            hm.put(array[i], i);
        } 

        int[] answer = new int[2];

        for(int i=0; i<n ;i++){

        
            //if we check the difference is present in map
            if(hm.containsKey(target - array[i])){
                if(hm.get(target - array[i]) > i){
                    //THis case is to check for same elements case. array[i] == target - array[i]
                    answer[0] = i;
                    answer[1] = hm.get(target - array[i]);
                    break;
                }
            }
        }

        System.out.println("The output array is: ["+ answer[0]+ "," + answer[1] + "]");
        
        
    }
}
