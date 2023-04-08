 
// A class to store a binary tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Test
{
    // Function to find the diameter of the binary tree. Note that the
    // function returns the height of the subtree rooted at a given node,
    // and the diameter is updated within the function as it is passed by
    // reference using the `AtomicInteger` class.

    public static int Maxdiameter = 0;
    public static int getDiameter(Node root, int diameter)
    {
        // base case: tree is empty
        if (root == null) {
            return 0;
        }
 
        // get heights of left and right subtrees
        int left_height = getDiameter(root.left, diameter);
        int right_height = getDiameter(root.right, diameter);
 
        // calculate diameter "through" the current node
        int max_diameter = left_height + right_height + 1;
 
        // update maximum diameter (note that diameter "excluding" the current
        // node in the subtree rooted at the current node is already updated
        // since we are doing postorder traversal)
        Maxdiameter = (Math.max(Maxdiameter, max_diameter));
 
        // it is important to return the height of the subtree rooted at the
        // current node
        return Math.max(left_height, right_height) + 1;
    }
 
    public static int getDiameter(Node root)
    {
        int diameter = 0;
        getDiameter(root, diameter);
 
        return Maxdiameter;
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        System.out.print("The diameter of the tree is " + getDiameter(root));
    }
}
