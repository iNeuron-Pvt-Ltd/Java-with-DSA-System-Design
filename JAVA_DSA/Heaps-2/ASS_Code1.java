import java.util.*;
class Main{
     public static String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap();
        for(char ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> previousEntry = null;
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            if(previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue()-1);
            previousEntry = currentEntry;
        }
        
        return sb.toString().length() == S.length() ? sb.toString() : "";
    }
    public static void main(String[] args){
        String S = "physicsWallahaappwskillls";
        System.out.println("The desired output is : " + reorganizeString(S));
    }
}
