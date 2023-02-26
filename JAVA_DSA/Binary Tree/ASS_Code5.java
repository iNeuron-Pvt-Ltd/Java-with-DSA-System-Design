// A class to store a binary tree node
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
    // Function to perform preorder traversal on a given binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Utility function to swap left subtree with right subtree
    public static void swap(Node root)
    {
        if (root == null) {
            return;
        }
 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
 
    // Function to convert a given binary tree into its mirror
    public static void convertToMirror(Node root)
    {
        // base case: if the tree is empty
        if (root == null) {
            return;
        }
 
        // convert left subtree
        convertToMirror(root.left);
 
        // convert right subtree
        convertToMirror(root.right);
 
        // swap left subtree with right subtree
        swap(root);
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        convertToMirror(root);
        preorder(root);
    }
}
