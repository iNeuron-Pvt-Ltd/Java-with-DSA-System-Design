import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the RansomNote String: ");  
        
        String ransomNote=sc.nextLine();

        System.out.print("Enter the Magazine String: ");  
        
        String magazine=sc.nextLine();


        HashMap<Character, Integer> ransomNoteHashMap = new HashMap<>();

        for(int i=0;i<ransomNote.length(); i++ ){
            if(ransomNoteHashMap.containsKey(ransomNote.charAt(i))) {
                ransomNoteHashMap.put(ransomNote.charAt(i), ransomNoteHashMap.get(ransomNote.charAt(i))+1);
            }
            else
                ransomNoteHashMap.put(ransomNote.charAt(i), 1);
        }     

        HashMap<Character, Integer> magazineHashMap = new HashMap<>();

        for(int i=0;i<magazine.length(); i++ ){
            if(magazineHashMap.containsKey(magazine.charAt(i))) {
                magazineHashMap.put(magazine.charAt(i), magazineHashMap.get(magazine.charAt(i))+1);
            }
            else
                magazineHashMap.put(magazine.charAt(i), 1);
        }     

        

        Integer answer = -1;
        for(Map.Entry<Character, Integer> e: ransomNoteHashMap.entrySet()) {

            if(e.getValue() > magazineHashMap.get(e.getKey())){

                System.out.println("false");
                answer = 1;
                break;
            }
        }
        if(answer == -1)
            System.out.println("True");

    }
}
