import java.util.*;

class Node {
	public int data;
	public List<Node> children;
	public Node(int val) { data = val; children = new ArrayList<Node>(); }
}

public class Main {
	public static String dfs(Node root, Map<String, Integer> f) {
		// Base condition
		if (root == null) return "";
		String s = "(" + Integer.toString(root.data);
		// Dfs call for all children
		for (Node child : root.children) {
			s += dfs(child, f);
		}
		s += ')';
		f.put(s, f.getOrDefault(s, 0) + 1);
		return s;
	}

	public static int duplicateSubtreeNaryTree(Node root) {
		Map<String, Integer> f = new HashMap<>();
		dfs(root, f);
		int ans = 0;
		for (Map.Entry<String, Integer> entry : f.entrySet()) {
			if (entry.getValue() > 1) ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.children.add(new Node(2));
		root.children.add(new Node(2));
		root.children.add(new Node(3));
		root.children.get(0).children.add(new Node(4));
		root.children.get(1).children.add(new Node(4));
		root.children.get(1).children.add(new Node(4));
		root.children.get(1).children.add(new Node(3));

		System.out.println(duplicateSubtreeNaryTree(root));
	}
}