import java.util.*;
class Main{
    private static int dis(int[] p) { 
        return p[0] * p[0] + p[1] * p[1];
    }
    public static void kClosest(int[][] points, int K) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
        return dis(points[i2]) - dis(points[i1]);
      });
      for(int i = 0; i < points.length; ++i) {
        pq.add(i);
        if(pq.size() > K){
            pq.remove();
        }
      }
      
      int[][] result = new int[K][];
      for (int i = 0; i < K; ++i) {
        int idx = pq.remove();
        result[i] = points[idx]; // can be returned in any order
      }
      
      for(int i=0;i<K;i++){
        for(int j=0;j<result[i].length;j++)System.out.print(result[i][j] + " ");
        System.out.println();
      }
    }
    public static void main(String[] args){
        int[][]points = {{2,3} , {4,1} , {1,2} , {5,4} , {9,8}};
        int k = 3;
        System.out.println("The desired output is : ");
        kClosest(points , k);
    }
}
