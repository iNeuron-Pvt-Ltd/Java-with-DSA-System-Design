import java.util.*;
 
class NumArray {
    private int[] nums;
    private int[] tree;
 
    // Build the segment tree
    private void buildTree(int node, int start, int end) {
        if (start == end) { // Leaf node
            tree[node] = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            buildTree(2 * node + 1, start, mid);
            buildTree(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
 
    // Update a value in the segment tree
    private void updateValue(int node, int start, int end, int index, int val) {
        if (start == end) { // Leaf node
            nums[index] = val;
            tree[node] = val;
        } else {
            int mid = start + (end - start) / 2;
            if (index >= start && index <= mid) {
                updateValue(2 * node + 1, start, mid, index, val);
            } else {
                updateValue(2 * node + 2, mid + 1, end, index, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
 
    // Calculate the sum in a given range
    private int queryRange(int node, int start, int end, int left, int right) {
        if (start > right || end < left) { // No overlap
            return 0;
        }
        if (left <= start && right >= end) { // Complete overlap
            return tree[node];
        }
        int mid = start + (end - start) / 2; // Partial overlap
        int leftSum = queryRange(2 * node + 1, start, mid, left, right);
        int rightSum = queryRange(2 * node + 2, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
 
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        tree = new int[4 * n];
        buildTree(0, 0, n - 1);
    }
 
    public void update(int index, int val) {
        updateValue(0, 0, nums.length - 1, index, val);
    }
 
    public int sumRange(int left, int right) {
        return queryRange(0, 0, nums.length - 1, left, right);
    }
}
 
public class Main {
    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 3, 5, 7, 9, 11};
        NumArray numArray = new NumArray(nums);
 
        // Update the value at index 2 to 6
        numArray.update(2, 6);
 
        // Calculate the sum of elements between indices 1 and 4
        int sum = numArray.sumRange(1, 4);
        System.out.println("Sum of elements between indices 1 and 4: " + sum);
    }
}