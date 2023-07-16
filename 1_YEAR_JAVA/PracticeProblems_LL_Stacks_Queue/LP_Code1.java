import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class Main {
    Node head;
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]) {
        Main head1 = new Main();
        Main head2 = new Main();

        head1.addToTheLast(new Node(1));
        head1.addToTheLast(new Node(2));
        head1.addToTheLast(new Node(4));
        head1.addToTheLast(new Node(6));
        head1.addToTheLast(new Node(9));

        System.out.println("Original List 1: " );
        head1.printList();


        head2.addToTheLast(new Node(3));
        head2.addToTheLast(new Node(5));
        head2.addToTheLast(new Node(7));
        head2.addToTheLast(new Node(8));

        System.out.println("Original List 2: ");
        head2.printList();

        Main mergedHead = new Main();
        mergedHead.head = new Mergesortedlists().MergeSortedLists(head1.head, head2.head);
        System.out.println("Merged List : ");
        mergedHead.printList();

    }
}

class Mergesortedlists {
    public Node MergeSortedLists(Node head1, Node head2) {

        Node result = new Node(0);
        Node lastptr = result;
        while (true) {
            if (head1 == null) {
                lastptr.next = head2;
                break;
            }
            if (head2 == null) {
                lastptr.next = head1;
                break;
            }

            if (head1.data <= head2.data) {
                lastptr.next = head1;
                head1 = head1.next;
            } else {
                lastptr.next = head2;
                head2 = head2.next;
            }

            lastptr = lastptr.next;
        }
        return result.next;
    }
}
