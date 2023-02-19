import java.util.HashMap;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {

        HashMap<Integer, String> hashmap = new HashMap<>();
  
        // Add elements using put method
        hashmap.put(1, "Piyush");
        hashmap.put(2, "Athar");
        hashmap.put(3, "Ajay");
        hashmap.put(4, "Anil");

        System.out.println("Value of Map is: "+ hashmap);

        //updating the value of key

        hashmap.put(1, "Rajesh");

        System.out.println("Value of Map is: "+ hashmap);

        String result = hashmap.get(3);

        System.out.println("Value of key = 3 is: "+ result);

        // removing the element from map.

        hashmap.remove(2);
        System.out.println("Value of Map is: "+ hashmap);


        // Iterate the map using
        // for-each loop
        for (Map.Entry<Integer, String> e : hashmap.entrySet())
            System.out.println("Key: " + e.getKey()
                               + " Value: " + e.getValue());
    }
}
