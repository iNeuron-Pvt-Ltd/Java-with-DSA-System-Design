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
 
    // Iterative function to search in a given BST
    public static void searchIterative(Node root, int key)
    {
        // start with the root node
        Node curr = root;
 
        // pointer to store the parent of the current node
        Node parent = null;
 
        // traverse the tree and search for the key
        while (curr != null && curr.data != key)
        {
            // update the parent to the current node
            parent = curr;
 
            // if the given key is less than the current node, go to the left subtree;
            // otherwise, go to the right subtree
            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
 
        // if the key is not present in the key
        if (curr == null)
        {
            System.out.println("Key not found");
            return;
        }
 
        if (parent == null) {
            System.out.println("The node with key " + key + " is root node");
        }
        else if (key < parent.data)
        {
            System.out.println("The given key is the left node of the node with key "
                            + parent.data);
        }
        else {
            System.out.println("The given key is the right node of the node with key "
                            + parent.data);
        }
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        searchIterative(root, 25);
    }
}
