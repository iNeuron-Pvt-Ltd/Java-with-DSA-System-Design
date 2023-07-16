import java.util.*;
public class Main {

	static class Node {
		int data;
		Node next;

		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	static Node head = null;
	static class Linkedlist {
		void insert(int value)
		{
			Node newNode = new Node(value);
			if (head == null)
				head = newNode;
			else {
				newNode.next = head;
				head = newNode;
			}
		}
		public Node detectLoop(){
			Node slowPointer = head, fastPointer = head;

			while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
				if (slowPointer == fastPointer)	break;
			}

			// if no loop exists
			if (slowPointer != fastPointer)
				return null;

			slowPointer = head;
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}

			return slowPointer;
		}
	}

	public static void main(String[] args)
	{
		Linkedlist l1 = new Linkedlist();
		// inserting new values
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);

		// adding a loop for the sake of this example

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = head;

		Node loopStart = l1.detectLoop();
		if (loopStart == null)
			System.out.println("Loop does not exists");
		else {
			System.out.println("Loop does exists and starts from "+ loopStart.data);
		}
	}
}
