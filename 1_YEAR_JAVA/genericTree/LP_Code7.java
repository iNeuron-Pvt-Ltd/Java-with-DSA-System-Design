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
    public static void postorder(Node root, List<Integer> answer) {
        if (root == null)
            return;
        for (Node ch : root.child) 
            postorder(ch, answer);
        answer.add(root.key);
    }
    static void postorderTraversal(Node root) {
        List<Integer> v = new ArrayList<>();
        postorder(root , v);
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
		
		postorderTraversal(root);
	}
}