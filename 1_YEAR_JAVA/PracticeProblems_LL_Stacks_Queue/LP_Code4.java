// Java program to sort a linked list
// using the merge sort algorithm.
public class Main{
    // Node class
    static class Node{
        int val;
        // Pointer to its next node
        Node next;

        // Constructor
        Node(int val){
            this.val = val;
        }
    }

    // Function to print the list
    static void printList(Node head){
        // Iterating while head is not null.
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    // Function to find the middle 
    // node of the linked list.
    static Node findMiddle(Node head){
        // Base condition.
        if (head == null)
            return head;
        
        // Slow and fast pointers to 
        // iterate over the list.
        // Fast pointer will take 2 steps
        // at a time while slow pointer will
        // take 1 step at a time.
        Node slow = head, fast = head;
        
        // Iterating while we have reached 
        // last or second last node of the list.
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // Node pointed by the slow pointer is the middle
        // node of the list.
        return slow;
    }

    // Function to merge two already sorted lists.
    static Node mergeSorted(Node left, Node right){
        // Base cases to check if either of
        // the list provided is empty.
        if (left == null)
            return right;
        if (right == null)
            return left;

        // Dummy node to hold the answer.
        Node dummy = new Node(-1);
        // Declaring another variable 'node'
        // to iterate further
        Node node = dummy;

        // Iterating while both pointers
        // are not null
        while (left != null && right != null){
            // If left's val is smaller than or 
            // equal to right's val.
            if (left.val <= right.val){
                // Assign left to node's next.
                node.next = left;

                // Move left to its next node.
                left = left.next;
            }
            // Otherwise left's val is greater 
            // than right's val. 
            else{
                // Assign right to node's next. 
                node.next = right;

                // Move right to its next.
                right = right.next;
            }
            // Moving node to its next node. 
            node = node.next;
        }

        // Iterating while left is not null.
        while (left != null){
            // Assign left to node's next.
            node.next = left;

            // Move left to its next node.
            left = left.next;

            // Moving node to its next node. 
            node = node.next;
        }

        // Iterating while right is not null.
        while (right != null){
            // Assign right to node's next. 
            node.next = right;

            // Move right to its next.
            right = right.next;

            // Moving node to its next node. 
            node = node.next;
        }

        // Returning dummy's next as our answer.
        return dummy.next;
    }
    // Function to sort the list.
    static Node mergeSort(Node head){
        // Base condition to check if the head
        // itself is null or the list consists of 
        // only a single node. 
        if (head == null || head.next == null){
            return head;
        }

        // Finding the middle node of the list.
        Node mid = findMiddle(head);

        // Finding the next node of the middle node.
        Node nextToMid = mid.next;

        // Breaking the list into two halves.
        mid.next = null;

        // Recurring for the left and the right
        // halves obtained.
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMid);

        // Merging the already sorted left 
        // and right part of the linked list.
        Node res = mergeSorted(left, right);

        // Returning the result.
        return res;
    }
    public static void main(String args[]){
        // Constructing the following linked list.
        // 4 --> 3 --> 2 --> 5 --> 1 --> null
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        // Printing the list before sorting.
        System.out.println("List before sorting - ");
        printList(head);

        // Calling the function to sort the list.
        head = mergeSort(head);

        // Printing the list after sorting. 
        System.out.println("List after sorting -");
        printList(head);
    }
}
