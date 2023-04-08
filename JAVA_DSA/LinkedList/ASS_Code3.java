//node structure
class Node {
    int data;
    Node next;
};

class LinkedList {
    static Node head;

    LinkedList() {
        head = null;
    }

    //Add new element at the end of the list
    void push_back(int newElement) {
        Node newNode = new Node();
        newNode.data = newElement;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node temp = new Node();
            temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    static void deleteDuplicates() {
        if (head == null || head.next == null)
            return;
        Node curr = head;

        while (curr != null && curr.next != null) {

            if (curr.data == curr.next.data) {
                Node temp = curr.next;
                curr.next = curr.next.next;
                delete
            } else {
                curr = curr.next;
            }
        }
        return;
    }
    //display the content of the list
    void PrintList() {
        Node temp = new Node();
        temp = this.head;
        if (temp != null) {
            System.out.print("The list contains: ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("The list is empty.");
        }
    }

    public static void main(String[] args) {
        LinkedList MyList = new LinkedList();

        //Add three elements at the end of the list.
        MyList.push_back(3);
        MyList.push_back(3);
        MyList.push_back(5);
        MyList.push_back(6);
        MyList.push_back(6);
        MyList.push_back(7);
        MyList.PrintList();

        deleteDuplicates();

        MyList.PrintList();

    }
}
