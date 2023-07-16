import java.util.*;

class QueueNode {
    int val;
    QueueNode next;
    QueueNode(int data) {
        val = data;
        next = null;
    }
}


class Queue {
    QueueNode Front = null, Rear = null;
    int size = 0;

    boolean Empty() {
        return Front == null;
    }
    int Peek() {
        if (Empty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else
            return Front.val;
    }
    void Enqueue(int value) {
        QueueNode Temp;
        Temp = new QueueNode(value);
        if (Temp == null) //When heap exhausted 
            System.out.println("Queue is Full");
        else {
            if (Front == null) {
                Front = Temp;
                Rear = Temp;
            } else {
                Rear.next = Temp;
                Rear = Temp;
            }
            System.out.println(value + " Inserted into Queue ");
            size++;
        }
    }
    void Dequeue() {
        if (Front == null)
            System.out.println("Queue is Empty");
        else {
            System.out.println(Front.val + " Removed From Queue");
            QueueNode Temp = Front;
            Front = Front.next;
            size--;
        }
    }
    
    public static void main(String args[]) {
        Queue Q = new Queue();
        Q.Enqueue(10);
        Q.Enqueue(20);
        Q.Enqueue(30);
        Q.Enqueue(40);
        Q.Enqueue(50);
        Q.Dequeue();
        System.out.println("The size of the Queue is " + Q.size);
        System.out.println("The Peek element of the Queue is " + Q.Peek());
    }
}
