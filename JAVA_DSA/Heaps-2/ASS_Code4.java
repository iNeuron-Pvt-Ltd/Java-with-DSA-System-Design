import java.util.*;
class Main{
   public static int kthSmallest(int[][] mat, int k) {
    	int col = Math.min(mat[0].length, k);
    
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	pq.add(0);
    	for (int[] row : mat) {
    		// max priority queue for the i-th row
    		PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
    		for (int i : pq) {
    			for (int c = 0; c < col; c++) {
    				nextPq.add(i + row[c]);
    				// keep pq size <= k
    				if (nextPq.size() > k) {
    					nextPq.poll();
    				}
    			}
    		}
    		pq = nextPq;
    	}
    	return pq.poll();
    }
    public static void main(String[] args){
       int [][]input = {{1,3,11} , {2,4,6}};
       int k = 5;
       
       System.out.println("The desired output is : " + kthSmallest(input , k));
    }
}
