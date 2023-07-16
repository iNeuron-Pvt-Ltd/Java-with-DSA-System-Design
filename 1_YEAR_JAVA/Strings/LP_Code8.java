import java.util.*;

public class Main{ 
    public static void main(String args[]){ 
        StringBuffer s1 = new StringBuffer(); 
        System.out.println(s1.capacity());//default 16 
        s1.append("Physics"); 
        System.out.println(s1.capacity());//now 16 
        s1.append("Wallah channel"); 
       // now (16*2)+2=34 i.e (oldcapacity*2)+2
        System.out.println(s1.capacity());
    }
}





