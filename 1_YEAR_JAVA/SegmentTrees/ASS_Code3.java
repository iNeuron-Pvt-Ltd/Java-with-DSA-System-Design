import java.util.*;
 
class SegTreeNode {
    int min, max; // range [min, max]
    int count;
    SegTreeNode left, right;
    
    public int mid() {
        return ((max + 1 - min) / 2 + min);
    }
    
    public SegTreeNode(int min, int max) {
        this.min = min;
        this.max = max;
        count = 0;
    }
}
    
public class Main {
    public static void countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = min > i ? i : min;
            max = max < i ? i : max;
        }
        
        SegTreeNode root = new SegTreeNode(min, max);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(0, find(nums[i] - 1, root)); // minus 1, in case there will be a equal one
            add(nums[i], root);
        }
        
        for(Integer i:list)System.out.print(i + " , ");
        
        return ;
    }
    
    private static int find(int x, SegTreeNode root) {
        if (root == null) return 0;
        
        if (x >= root.max) {
            return root.count;
        } else {
            int mid = root.mid(); 
            if (x < mid) {
                return find(x, root.left);
            } else {
                return find(x, root.left) + find(x, root.right);
            }
        }
    }
    
    private static void add(int x, SegTreeNode root) {
        if (x < root.min || x > root.max) return;
       
        root.count++;
        if (root.max == root.min) return;
        
        int mid = root.mid();
        if (x < mid) {
            if (root.left == null) {
                root.left = new SegTreeNode(root.min, mid - 1);
            }
            add(x, root.left);
        } else {
            if (root.right == null) {
                root.right = new SegTreeNode(mid, root.max);
            }
            add(x, root.right);
        }
    }
    
    public static void main(String[] args) {
    
        int arr[] = {2,4,1,5,7,6,9};
        countSmaller(arr);
        
    }
}