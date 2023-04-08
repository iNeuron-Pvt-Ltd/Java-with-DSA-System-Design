import java.io.*;
import java.util.*;
 
public class Main{
    static void subsequences(String s , int i ,  ArrayList<String>answer , String res){
         if(i >= s.length()){
            answer.add(res);
            return;
        }
        subsequences(s , i + 1 , answer , res);
        subsequences(s , i + 1 , answer , res + s.charAt(i));    
    }
 
    public static void main(String[] args){   
        String s;
        Scanner sc = new Scanner(System.in);
        s=sc.nextLine();
        ArrayList<String> answer = new ArrayList<String>();
        subsequences(s,0,answer,"");
        for(int i = 0; i < answer.size(); i++)System.out.print(answer.get(i) + " ");
    }  
}