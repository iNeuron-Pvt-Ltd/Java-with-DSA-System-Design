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

    /* Function to reverse the linked list usign recursion*/
    Node reverse(Node head)
    {
        if(head == null) {
            return head;
        }
  
        // last node or only one node
        if(head.next == null) {
            return head;
        }
  
        Node newHeadNode = reverse(head.next);
  
        // change references for middle chain
        head.next.next = head;
        head.next = null;
  
        // send back new head node in every recursion
        return newHeadNode;
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
