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
    // Function to perform inorder traversal on the BST
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Helper function to find minimum value node in the subtree rooted at `curr`
    public static Node getMinimumKey(Node curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
 
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
 
    // Function to delete a node from a BST
    public static Node deleteNode(Node root, int key)
    {
        // pointer to store the parent of the current node
        Node parent = null;
 
        // start with the root node
        Node curr = root;
 
        // search key in the BST and set its parent pointer
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
 
        // return if the key is not found in the tree
        if (curr == null) {
            return root;
        }
 
        // Case 1: node to be deleted has no children, i.e., it is a leaf node
        if (curr.left == null && curr.right == null)
        {
            // if the node to be deleted is not a root node, then set its
            // parent left/right child to null
            if (curr != root)
            {
                if (parent.left == curr) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            // if the tree has only a root node, set it to null
            else {
                root = null;
            }
        }
 
        // Case 2: node to be deleted has two children
        else if (curr.left != null && curr.right != null)
        {
            // find its inorder successor node
            Node successor = getMinimumKey(curr.right);
 
            // store successor value
            int val = successor.data;
 
            // recursively delete the successor. Note that the successor
            // will have at most one child (right child)
            deleteNode(root, successor.data);
 
            // copy value of the successor to the current node
            curr.data = val;
        }
 
        // Case 3: node to be deleted has only one child
        else {
            // choose a child node
            Node child = (curr.left != null)? curr.left: curr.right;
 
            // if the node to be deleted is not a root node, set its parent
            // to its child
            if (curr != root)
            {
                if (curr == parent.left) {
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }
            }
 
            // if the node to be deleted is a root node, then set the root to the child
            else {
                root = child;
            }
        }
 
        return root;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16 };
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        root = deleteNode(root, 16);
        inorder(root);
    }
}
