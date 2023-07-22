import java.util.*;
public class Main {
	static class Node {
		int key;
		ArrayList<Node> child;
		Node(int val) {
			key = val;
			child = new ArrayList<>();
		}
	};
	static void fun(Node root, List<Integer> v){
        if (root == null) return;
        v.add(root.key);
        for (int i = 0; i < root.child.size(); i++) fun(root.child.get(i), v);
    }
    static void preorderTraversal(Node root) {
        List<Integer> v = new ArrayList<>();
        fun(root, v);
        for (int i : v) System.out.print(i + " ");
    }
	public static void main(String[] args){
		Node root = new Node(1);
		root.child.add(new Node(2));
		root.child.add(new Node(3));
		root.child.add(new Node(4));
		root.child.get(0).child.add(new Node(5));
		root.child.get(0).child.get(0).child.add(new Node(10));
		root.child.get(0).child.add(new Node(6));
		root.child.get(0).child.get(1).child.add(new Node(11));
		root.child.get(0).child.get(1).child.add(new Node(12));
		root.child.get(0).child.get(1).child.add(new Node(13));
		root.child.get(2).child.add(new Node(7));
		root.child.get(2).child.add(new Node(8));
		root.child.get(2).child.add(new Node(9));
		
		preorderTraversal(root);
	}
}