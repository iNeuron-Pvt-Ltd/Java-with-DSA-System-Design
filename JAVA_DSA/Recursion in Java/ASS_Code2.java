import java.io.*;
import java.util.*;

public class Main
{   static int go(int lastNaturalNumber  , int index){
    if(index == lastNaturalNumber + 1)return 0;
    if(index % 2 == 0)return go(lastNaturalNumber , index + 1) - i;
    else return go(lastNaturalNumber , index + 1) + i;
}
	public static void main(String[] args) {
	   
        Scanner sc = new Scanner(System.in);
        int lastNaturalNumber = sc.nextInt();
        System.out.println(go(lastNaturalNumber,1));
   

	}
}
