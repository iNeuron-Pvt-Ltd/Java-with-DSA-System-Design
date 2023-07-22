import java.util.*;
class Main{
    static class Node {
    	int data;
    	Node []children;
    	int length;
    	Node() {
        	length = 0;
        	data = 0;
    	}
    	Node(int n, int data_){
        	children = new Node[n];
        	length = n;
        	data = data_;
    	}
    };
    static int sumReplacementNary(Node node) {
    	if (node == null)
    	return 0;
    	int total = node.length;
        for (int i = 0; i < total; i++) node.data += sumReplacementNary(node.children[i]);
    	return node.data;
    }
    static void preorderTraversal(Node node) {
    	if (node == null)
    	return;
    	int total = node.length;
    	System.out.print(node.data+ " ");
    	for (int i = 0; i < total - 1; i++)
    	preorderTraversal(node.children[i]);
    	preorderTraversal(node.children[total - 1]);
    }
    public static void main(String[] args) {
    	int N = 3;
    	Node root = new Node(N, 1);
    	root.children[0] = new Node(N, 2);
    	root.children[1] = new Node(N, 3);
    	root.children[2] = new Node(N, 4);
    	root.children[0].children[0] = new Node(N, 5);
    	root.children[0].children[1] = new Node(N, 6);
    	root.children[0].children[2] = new Node(N, 7);
    
    	System.out.print("Initial Pre-order Traversal: ");
    	preorderTraversal(root);
    	System.out.println();
    
    	System.out.print("Final Pre-order Traversal: ");
    	sumReplacementNary(root);
    	preorderTraversal(root);
    }
}
