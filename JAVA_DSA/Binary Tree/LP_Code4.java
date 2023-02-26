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
    // Recursive function to calculate the height of a given binary tree
    public static int height(Node root)
    {
        // base case: empty tree has a height of 0
        if (root == null) {
            return 0;
        }
 
        // recur for the left and right subtree and consider maximum depth
        return 1 + Math.max(height(root.left), height(root.right));
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
 
        System.out.println("The height of the binary tree is " + height(root));
    }
}
