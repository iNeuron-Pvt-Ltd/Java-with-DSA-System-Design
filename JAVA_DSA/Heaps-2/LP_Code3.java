
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int key)
	{
		data = key;
		next = null;
	}
}

// Class implements Comparator to compare Node data
class NodeComparator implements Comparator<Node> {

	public int compare(Node k1, Node k2){
		if (k1.data > k2.data)
			return 1;
		else if (k1.data < k2.data)
			return -1;
		return 0;
	}
}
class Main {
	// Function to merge k sorted linked lists
	static Node mergeKList(Node[] arr, int K){
		// Priority_queue 'queue' implemented as min heap with the help of 'compare' function
		PriorityQueue<Node> queue
			= new PriorityQueue<>(new NodeComparator());
		Node at[] = new Node[K];
		Node head = new Node(0);
		Node last = head;
		// Push the head nodes of all the k lists in 'queue'
		for (int i = 0; i < K; i++) {
			if (arr[i] != null) {
				queue.add(arr[i]);
			}
		}
		// Handles the case when k = 0 or lists have no elements in them
		if (queue.isEmpty())
			return null;
		// Loop till 'queue' is not empty
		while (!queue.isEmpty()) {
			// Get the top element of 'queue'
			Node curr = queue.poll();

			// Add the top element of 'queue' to the resultant merged list
			last.next = curr;
			last = last.next;
			// Check if there is a node next to the 'top' node in the list of which 'top' node is a member
			if (curr.next != null) {
				// Push the next node of top node in 'queue'
				queue.add(curr.next);
			}
		}
		return head.next;
	}
	// Print linked list
	public static void printList(Node node){
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args){
		int N = 3;
	
		// array to store head of linkedlist
		Node[] a = new Node[N];
	
		// Linkedlist1
		Node head1 = new Node(1);
		a[0] = head1;
		head1.next = new Node(3);
		head1.next.next = new Node(5);
		head1.next.next.next = new Node(7);
	
		// Limkedlist2
		Node head2 = new Node(2);
		a[1] = head2;
		head2.next = new Node(4);
		head2.next.next = new Node(6);
		head2.next.next.next = new Node(8);
	
		// Linkedlist3
		Node head3 = new Node(0);
		a[2] = head3;
		head3.next = new Node(9);
		head3.next.next = new Node(10);
		head3.next.next.next = new Node(11);

		Node res = mergeKList(a, N);

		if (res != null)
			printList(res);
		System.out.println();
	}
}
