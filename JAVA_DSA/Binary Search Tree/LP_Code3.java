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
 
    // Recursive function to search in a given BST
    public static void search(Node root, int key, Node parent)
    {
        // if the key is not present in the key
        if (root == null)
        {
            System.out.println("Key not found");
            return;
        }
 
        // if the key is found
        if (root.data == key)
        {
            if (parent == null) {
                System.out.println("The node with key " + key + " is root node");
            }
 
            else if (key < parent.data)
            {
                System.out.println("The given key is the left node of the node " +
                            "with key " + parent.data);
            }
            else {
                System.out.println("The given key is the right node of the node " +
                            "with key " + parent.data);
            }
 
            return;
        }
 
        // if the given key is less than the root node, recur for the left subtree;
        // otherwise, recur for the right subtree
 
        if (key < root.data) {
            search(root.left, key, root);
        }
        else {
            search(root.right, key, root);
        }
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        search(root, 25, null);
    }
}
