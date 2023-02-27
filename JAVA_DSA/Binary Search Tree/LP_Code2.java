// A class to store a BST node
class Node
{
    int data;
    Node left, right;
 
    // Function to create a new binary tree node having a given key
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
 
class Main
{
    // Function to perform inorder traversal on the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Iterative function to insert a key into a BST
    public static Node insertIterative(Node root, int key)
    {
        // start with the root node
        Node curr = root;
 
        // pointer to store the parent of the current node
        Node parent = null;
 
        // if the tree is empty, create a new node and set it as root
        if (root == null) {
            return new Node(key);
        }
 
        // traverse the tree and find the parent node of the given key
        while (curr != null)
        {
            // update the parent to the current node
            parent = curr;
 
            // if the given key is less than the current node,
            // go to the left subtree; otherwise, go to the right subtree.
            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
 
        // construct a node and assign it to the appropriate parent pointer
        if (key < parent.data) {
            parent.left = new Node(key);
        }
        else {
            parent.right = new Node(key);
        }
 
        return root;
    }
 
    // Function to construct a BST from given keys
    public static Node constructBST(int[] keys)
    {
        Node root = null;
        for (int key: keys) {
            root = insertIterative(root, key);
        }
        return root;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = constructBST(keys);
        inorder(root);
    }
}
