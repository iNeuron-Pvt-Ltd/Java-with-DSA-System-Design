import java.util.*;


public class Main {  
    
       public static void main(String[] args) {  
        StringBuilder sb1 = new StringBuilder("Physics Wallah");  
        System.out.println("string = "+sb1);  
        String subseq1= sb1.substring(6);  
        String subseq2= sb1.substring(6,10);
        //subsequence from start index 6  
        System.out.println("subsequence from index 6= "+subseq1);  
          System.out.println("subsequence from index 6= "+subseq2); 
   }
}
