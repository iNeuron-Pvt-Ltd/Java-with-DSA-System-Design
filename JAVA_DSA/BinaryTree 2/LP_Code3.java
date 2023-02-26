import java.util.concurrent.atomic.AtomicInteger;
 
// A class to store a binary tree node
class Node
{
    int data;
    Node left, right;
 
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}
 
class Main
{
    // Recursive function to find the maximum path sum "starting" from the
    // given node in the binary tree.
    public static int findMaxPathSum(Node node, AtomicInteger result)
    {
        // base case: empty tree
        if (node == null) {
            return 0;
        }
 
        // find maximum path sum "starting" from the left child
        int left = findMaxPathSum(node.left, result);
 
        // find maximum path sum "starting" from the right child
        int right = findMaxPathSum(node.right, result);
 
        // Try all possible combinations to get the optimal result
        int max = result.get();
        max = Integer.max(max, node.data);
        max = Integer.max(max, node.data + left);
        max = Integer.max(max, node.data + right);
        max = Integer.max(max, node.data + left + right);
        result.set(max);
 
        // return the maximum path sum "starting" from the given node
        return Integer.max(node.data, node.data + Integer.max(left, right));
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                1
              /   \
             /     \
            2      10
           / \    /  \
         -1  -4  -5   -6
             /   / \
            3   7   4
                 \
                 -2
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(-1);
        root.left.right = new Node(-4);
        root.right.left = new Node(-5);
        root.right.right = new Node(-6);
        root.left.right.left = new Node(4);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(4);
        root.right.left.left.right = new Node(-2);
 
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        findMaxPathSum(root, result);
        System.out.println("The maximum path sum is " + result);
    }
}
