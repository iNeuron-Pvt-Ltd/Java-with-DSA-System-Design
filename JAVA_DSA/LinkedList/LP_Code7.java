
import java.io.*;

class Main {
	static Node head; // head of list

	static class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

    static void middleNode() {
        
       Node slow = head, fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("The value of middle element is : " + slow.data);
    }
	static void print()	{
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static void push(int data)
	{
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}
	public static void main(String args[]){
		push(1);
		push(2);
		push(3);
		push(4);

		System.out.println("Given linked list");
	    print();
	    middleNode();
	}
}
