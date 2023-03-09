import java.util.*;
 
class Main{
   public static int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : A)
            pq.offer(a);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
    public static void main(String[] args){
        int[] input = {2,7,4,1,8,1};
        System.out.println("The desired output is : " + lastStoneWeight(input));
    }
}
