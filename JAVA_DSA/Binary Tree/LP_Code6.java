import java.util.ArrayDeque;
import java.util.Queue;
 
// A class to store a binary tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class Main
{
    // Function to print level order traversal of a given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        Node curr;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in the queue and enqueue their
            // non-empty left and right child
            curr = queue.poll();
 
            System.out.print(curr.key + " ");
 
            if (curr.left != null) {
                queue.add(curr.left);
            }
 
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        levelOrderTraversal(root);
    }
}
