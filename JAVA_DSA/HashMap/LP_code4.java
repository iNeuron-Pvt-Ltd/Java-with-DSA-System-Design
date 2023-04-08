import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");  
        
        String s=sc.nextLine();


        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0;i<s.length(); i++ ){
            int frequencyOfElement = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), frequencyOfElement+1);
        }       

        //Now we will check first character whose frequency is 1

        Integer answer = -1;
        for(int i=0;i<s.length(); i++) {

            if(hm.get(s.charAt(i)) == 1){

                System.out.println("The first non repeating character index is: "+ (i));
                answer = 1;
                break;
            }
        }
        if(answer == -1)
            System.out.println("No character is found: -1");

    }
}
