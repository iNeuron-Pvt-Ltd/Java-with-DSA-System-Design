class LinkedList {
	Node head; // head of list
	Node slow_ptr, fast_ptr, second_half;

	class Node {
		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	boolean isPalindrome(Node head)	{
		slow_ptr = head;
		fast_ptr = head;
		Node prev_of_slow_ptr = head;
		Node midnode = null; // To handle odd size list
		boolean res = true; // initialize result

		if (head != null && head.next != null) {
		
			while (fast_ptr != null
				&& fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;
				prev_of_slow_ptr = slow_ptr;
				slow_ptr = slow_ptr.next;
			}

			if (fast_ptr != null) {
				midnode = slow_ptr;
				slow_ptr = slow_ptr.next;
			}
			second_half = slow_ptr;
			prev_of_slow_ptr.next = null; 
			reverse(); 
			res = compareLists(head , second_half); 
			reverse(); 

			if (midnode != null) {
				prev_of_slow_ptr.next = midnode;
				midnode.next = second_half;
			}
			else
				prev_of_slow_ptr.next = second_half;
		}
		return res;
	}
	void reverse(){
		Node prev = null;
		Node current = second_half;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		second_half = prev;
	}

	boolean compareLists(Node head1, Node head2)
	{
		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			else
				return false;
		}

		if (temp1 == null && temp2 == null)
			return true;
		return false;
	}

	public void push(int new_data){
	    Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
	}
	public static void main(String[] args){
		LinkedList llist = new LinkedList();

		int arr[] = { 1, 2, 4, 5, 4, 2, 1 };
		for (int i = 0; i < 7; i++) {
			llist.push(arr[i]);
		}
		if (llist.isPalindrome(llist.head) != false) {
			System.out.println("Is Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}
	}
}
