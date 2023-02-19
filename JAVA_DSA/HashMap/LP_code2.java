import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        // HashMap in Java

        HashMap<Integer, String> hashmap = new HashMap<>();
  
        hashmap.put(4, "Anil");
        hashmap.put(2, "Athar");
        hashmap.put(3, "Ajay");
        hashmap.put(1, "Piyush");
        

        System.out.println("Value of HashMap is: "+ hashmap);


        // TreeMap in Java

        TreeMap<Integer, String> treemap = new TreeMap<>();
  
        treemap.put(4, "Anil");
        treemap.put(2, "Athar");
        treemap.put(3, "Ajay");
        treemap.put(1, "Piyush");
        

        System.out.println("Value of TreeMap is: "+ treemap);

        // LinkedHashMap in Java

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
  
        linkedHashMap.put(4, "Anil");
        linkedHashMap.put(2, "Athar");
        linkedHashMap.put(3, "Ajay");
        linkedHashMap.put(1, "Piyush");
        

        System.out.println("Value of LinkedHashMap is: "+ linkedHashMap);
        
        
    }
}
