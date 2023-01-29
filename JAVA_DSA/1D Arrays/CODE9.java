public class CODE9 {
    public static void main(String[] args) {
        String[] states = {"Agra", "Chandigarh", " Pune", "Maharashtra" };

        int max_len = 0, idx = 0;
        for (int i = 0; i < states.length; i++) {
            if (states[i].length() > max_len) {
                max_len = states[i].length();
                idx = i;
            }
        }
        System.out.println(idx);

    }
}
