import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the RansomNote String: ");  
        
        String s=sc.nextLine();

        System.out.print("Enter the Magazine String: ");  
        
        String r=sc.nextLine();


        HashMap<Character, Integer> hm1 = new HashMap<>();

        for(int i=0;i<s.length(); i++ ){
            if(hm1.containsKey(s.charAt(i))) {
                hm1.put(s.charAt(i), hm1.get(s.charAt(i))+1);
            }
            else
                hm1.put(s.charAt(i), 1);
        }     

        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(int i=0;i<r.length(); i++ ){
            if(hm2.containsKey(r.charAt(i))) {
                hm2.put(r.charAt(i), hm2.get(r.charAt(i))+1);
            }
            else
                hm2.put(r.charAt(i), 1);
        }     

        

        Integer answer = -1;
        for(Map.Entry<Character, Integer> e: hm1.entrySet()) {

            if(e.getValue() > hm2.get(e.getKey())){

                System.out.println("false");
                answer = 1;
                break;
            }
        }
        if(answer == -1)
            System.out.println("True");

    }
}
