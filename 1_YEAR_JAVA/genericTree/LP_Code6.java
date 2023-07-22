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
    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> answer = new LinkedList<Integer>();
        if (root == null) return answer;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            answer.addFirst(current.key);
            for (Node ch : current.child) stack.push(ch);
        }
        return answer;
    }
    static void postorderTraversal(Node root) {
        List<Integer> v = new ArrayList<>();
        v = postorder(root);
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