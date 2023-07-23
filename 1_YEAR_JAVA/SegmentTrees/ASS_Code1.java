import java.util.*;
 
class SegmentTree {
    private List<Integer> arr;
    private List<Integer> tree;
 
    // Recursive function to build the segment tree
    private void buildTree(int node, int start, int end) {
        if (start == end) { // Leaf node
            tree.set(node, arr.get(start));
        } else {
            int mid = (start + end) / 2;
            buildTree(2 * node + 1, start, mid);
            buildTree(2 * node + 2, mid + 1, end);
            tree.set(node, tree.get(2 * node + 1) + tree.get(2 * node + 2));
        }
    }
 
    // Recursive function to query the segment tree
    private int queryRange(int node, int start, int end, int left, int right) {
        if (start > right || end < left) { // No overlap
            return 0;
        }
        if (left <= start && right >= end) { // Complete overlap
            return tree.get(node);
        }
        int mid = (start + end) / 2; // Partial overlap
        int leftSum = queryRange(2 * node + 1, start, mid, left, right);
        int rightSum = queryRange(2 * node + 2, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
 
    public SegmentTree(List<Integer> input) {
        arr = input;
        int n = arr.size();
        tree = new ArrayList<>(Collections.nCopies(4 * n, 0));
        buildTree(0, 0, n - 1);
    }
 
    public int query(int left, int right) {
        return queryRange(0, 0, arr.size() - 1, left, right);
    }
}
 
class Main {
    public static List<Integer> computeSumQueries(List<Integer> arr, List<Map.Entry<Integer, Integer>> queries) {
        int n = arr.size();
        int q = queries.size();
        List<Integer> sums = new ArrayList<>(Collections.nCopies(q, 0));
 
        SegmentTree segmentTree = new SegmentTree(new ArrayList<>(arr));
 
        for (int i = 0; i < q; i++) {
            int l = queries.get(i).getKey();
            int r = queries.get(i).getValue();
 
            // Perform bounds checking on indices
            if (l < 0 || l >= n || r < 0 || r >= n || l > r) {
                sums.set(i, 0);  // Invalid indices, set sum to 0
                continue;
            }
 
            // Query the segment tree for the sum between indices l and r
            sums.set(i, segmentTree.query(l, r));
        }
 
        return sums;
    }
 
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        List<Map.Entry<Integer, Integer>> queries = Arrays.asList(
                new AbstractMap.SimpleEntry<>(0, 2),
                new AbstractMap.SimpleEntry<>(1, 3),
                new AbstractMap.SimpleEntry<>(2, 4)
        );
 
        List<Integer> sums = computeSumQueries(arr, queries);
 
        // Print the sums for each query
        for (int i = 0; i < sums.size(); i++) {
            System.out.println("Sum for query " + (i + 1) + ": " + sums.get(i));
        }
    }
}