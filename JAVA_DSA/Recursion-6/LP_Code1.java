import java.io.*;
import java.util.*;
 
public class Main{
    static void combination(String s , ArrayList<String>v , ArrayList<String>ans , int idx , String res){
        if(idx >= s.length()){
            ans.add(res);
            return;
      }
      int digit = s.charAt(idx) - '0';
      if(digit <= 1)combination(s , v , ans , idx + 1 , res);
      for(int j = 0 ; j < v.get(digit).length() ; j++){
            combination(s , v , ans , idx + 1 , res + v.get(digit).charAt(j));
        }
    }
 
	public static void main(String[] args) {
		String s;
        Scanner sc = new Scanner(System.in);
        s=sc.nextLine();
        ArrayList<String> v = new ArrayList<String>(9);;
        //v = {"","","abc","def","ghi","jkl","mno","pqr","stuv","wxyz"};
        v.add("");
        v.add("");
        v.add("abc");
        v.add("def");
        v.add("ghi");
        v.add("jkl");
        v.add("mno");
        v.add("pqr");
        v.add("stuv");
        v.add("wxyz");
        ArrayList<String> answer = new ArrayList<String>();
        combination(s,v,answer,0,"");
        for (int i = 0; i < answer.size(); i++)
                System.out.print(answer.get(i) + " ");
    }
}