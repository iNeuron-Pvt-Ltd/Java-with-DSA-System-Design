public class Test {
    public static void main(String[] args) {
        String[] states = {
            "Delhi",
            "Chandigarh",
            "Pune"
        };
        // print elements to the console:
        for (int i = 0; i < states.length; i++)
            System.out.print(states[i] + ", ");
        
        // printing using for-each loop
        for (String s: states) {
             System.out.print(s + ", ");
        }
    }
}
