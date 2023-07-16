import java.util.*;


public class Main{ 
    public static void main(String args[]){ 
        StringBuffer s1=new StringBuffer("Physics "); 
        s1.replace(1,4,"Wallah");                     
        //now original string is changed 
        System.out.println(s1);               
    }
}



