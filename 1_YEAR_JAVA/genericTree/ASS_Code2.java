import java.util.*;
public class Main {
	static class Node {
		
		public int data;
		public Vector<Node> childs = new Vector<Node>();
	}
	
	static Node newNode(int data) {
    	Node temp = new Node();
    	temp.data = data;
    	return temp;
	}
	static int largestELe = Integer.MIN_VALUE;

	static void largestEleUnderRange(Node root, int data){
		if (root.data < data) largestELe = Math.max(root.data, largestELe);
    	for (int child = 0; child < root.childs.size(); child++) largestEleUnderRange(root.childs.get(child), data);
	}
	
	static void KthLargestElement(Node root, int K) {
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < K; i++) {
			largestEleUnderRange(root, ans);
			ans = largestELe;
			largestELe = Integer.MIN_VALUE;
		}
		System.out.print(ans);
	}
	
	public static void main(String[] args) {
		Node root = newNode(10);
		(root.childs).add(newNode(2));
		(root.childs).add(newNode(34));
		(root.childs).add(newNode(56));
		(root.childs).add(newNode(100));
		(root.childs.get(0).childs).add(newNode(77));
		(root.childs.get(0).childs).add(newNode(88));
		(root.childs.get(2).childs).add(newNode(1));
		(root.childs.get(3).childs).add(newNode(7));
		(root.childs.get(3).childs).add(newNode(8));
		(root.childs.get(3).childs).add(newNode(9));
	
		int K = 3;
		KthLargestElement(root, K);
	}
}
