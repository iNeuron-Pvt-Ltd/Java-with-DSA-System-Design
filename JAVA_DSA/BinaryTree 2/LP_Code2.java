 // A class to store a binary tree node
 class Node {
     int data;
     Node left = null, right = null;

     Node(int data) {
         this.data = data;
     }
 }

 class Main {
     //Function to check is the tree is symmetric for left node and right node.
     static boolean checkSymmetric(Node leftNode, Node rightNode) {
         if (leftNode == null && rightNode == null) {
             return true;
         }
         if (leftNode == null || rightNode == null) {
             return false;
         }
         if (leftNode.data != rightNode.data) {
             return false;
         }
         return checkSymmetric(leftNode.left, rightNode.right) && checkSymmetric(leftNode.right, rightNode.left);

     }

     public static void main(String[] args) {
         /*

         1
       /   \
      /     \
      2      2
     / \    / \
    /   \  /   \
   4    5  5    4

        */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(2);
         root.left.right = new Node(5);
         root.left.left = new Node(4);
         root.right.right = new Node(4);
         root.right.left = new Node(5);
         
         if (root==null) {
             System.out.print("The given tree is Symmetric: ");
         }
         else {
             System.out.print("The given tree is Symmetric: " + checkSymmetric(root.left, root.right));
         }


     }
 }
