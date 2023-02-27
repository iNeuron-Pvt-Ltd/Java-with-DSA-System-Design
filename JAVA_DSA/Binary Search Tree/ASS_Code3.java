import java.util.HashSet;
import java.util.Set;
 
// A class to store a BST node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Recursive function to insert a key into a BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Function to find a pair with a given sum in the BST
    public static boolean findPair(Node root, int target, Set<Integer> set)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        // return true if pair is found in the left subtree; otherwise, continue
        // processing the node
        if (findPair(root.left, target, set)) {
            return true;
        }
 
        // if a pair is formed with the current node, print the pair and return true
        if (set.contains(target - root.data))
        {
            System.out.println("Pair found (" + (target - root.data) + ", "
                                    + root.data + ")");
            return true;
        }
 
        // insert the current node's value into the set
        else {
            set.add(root.data);
        }
 
        // search in the right subtree
        return findPair(root.right, target, set);
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        // find pair with the given sum
        int target = 28;
 
        // create an empty set
        Set<Integer> set = new HashSet<>();
 
        if (!findPair(root, target, set)) {
            System.out.println("Pair does not exist");
        }
    }
}
