import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
 
class Main{
    // Function to calculate the minimum cost to join `n` ropes into a single rope
    public static int findMinCost(List<Integer> prices)
    {
        // create a min-heap using `PriorityQueue` class from elements of the list
        PriorityQueue<Integer> pq = new PriorityQueue<>(prices);
 
        // keep track of the minimum cost so far
        int cost = 0;
 
        // repeat till heap size is reduced to one
        while (pq.size() > 1){
            // Extract the top two elements from the min-heap
            int x = pq.poll();
            int y = pq.poll();
 
            // calculate the cost of the extracted values
            int sum = x + y;
 
            // insert the cost back to the min-heap
            pq.add(sum);
 
            // update the minimum cost
            cost += sum;
        }
        return cost;
    }
 
    public static void main(String[] args){
        List<Integer> prices = Arrays.asList(5, 4, 2, 8);
        System.out.println("The minimum cost is " + findMinCost(prices));
    }
}