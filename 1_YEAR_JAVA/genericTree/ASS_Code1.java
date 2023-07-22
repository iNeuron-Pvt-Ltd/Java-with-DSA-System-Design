import java.util.*;
class Main{
    static class Node{
    	int key;
    	Vector<Node> child = new Vector<>();
    };
    static Node maximum = null;
    static Node newNode(int key) {
    	Node temp = new Node();
    	temp.key = key;
    	return temp;
    }
    
    static void findlargest(Node root){
    	if (root == null) return;
    	if ((maximum) == null) maximum = root;
    	else if (root.key > (maximum).key)	maximum = root;
    	for(int i = 0;i < root.child.size(); i++) findlargest(root.child.get(i));
    }
    
    public static void main(String[] args){
    	Node root = newNode(11);
    	(root.child).add(newNode(21));
    	(root.child).add(newNode(29));
    	(root.child).add(newNode(90));
    	(root.child.get(0).child).add(newNode(18));
    	(root.child.get(1).child).add(newNode(10));
    	(root.child.get(1).child).add(newNode(12));
    	(root.child.get(2).child).add(newNode(77));
    
    	findlargest(root);
    	System.out.print(maximum.key);
    }
}
