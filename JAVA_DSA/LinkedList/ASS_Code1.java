
class LinkedList {
    class Node {
    	int data;
    	Node next;
	    Node(int d)	{
		data = d;
		next = null;
	    }
    }

	Node head; 

	// Inserts a new node at the front of the list
	public void push(int new_data)	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	// Checks whether the value x is present in linked list
	public boolean search(Node head, int x)
	{
		Node current = head; 
		while (current != null) {
			if (current.data == x)
				return true; // data found
			current = current.next;
		}
		return false; // data not found
	}
	public static void main(String args[]){
		LinkedList llist = new LinkedList();

		llist.push(21);
		llist.push(22);
		llist.push(11);
		llist.push(43);
		llist.push(23);

		if (llist.search(llist.head, 21))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

