class Main {
	static Node head;
	static class Node {
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}

	/* Function to reverse the linked list */
	Node reverse(Node node)
	{
		Node previous = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		node = previous;
		return node;
	}

	// prints content of linked list
	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	public static void main(String[] args)
	{
		Main list = new Main();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);

		System.out.println("Given linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}
}

