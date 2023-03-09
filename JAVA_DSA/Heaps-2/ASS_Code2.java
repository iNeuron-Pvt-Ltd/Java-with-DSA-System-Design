import java.util.*;
class Main{
    public static void kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return ;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        for(int[] a : res){
            for(int b : a){
                System.out.printf(b + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
       int nums1[] = {1,2,5,6,8};
       int nums2[] = {4,5,16};
       
       int k = 4;
       System.out.println("The desired output is : ");
       kSmallestPairs(nums1 , nums2 , k);
    }
}
