import java.util.Random;

class Node {
    int value;
    Node[] next;

    public Node(int value, int level) {
        this.value = value;
        this.next = new Node[level + 1];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 16; // Maximum number of levels in the skip list
    private static final double SKIP_PROBABILITY = 0.5; // Probability of promoting an element to a higher level

    private Node head;
    private int level;

    public SkipList() {
        this.head = new Node(Integer.MIN_VALUE, MAX_LEVEL);
        this.level = 0;
    }

    // Coin flip function to determine whether an element should be promoted to a higher level
    private boolean shouldPromote() {
        return Math.random() < SKIP_PROBABILITY;
    }

    public boolean search(int target) {
        Node current = head;

        // Start from the top layer and move down through the levels
        for (int i = level; i >= 0; i--) {
            // Move to the right in the current layer until the value is greater or equal to the target
            while (current.next[i] != null && current.next[i].value < target) {
                current = current.next[i];
            }

            // If the current element's value is equal to the target, we found the element
            if (current.next[i] != null && current.next[i].value == target) {
                return true;
            }
        }

        // If the target is not found at any level, it does not exist in the skip list
        return false;
    }

    public void insert(int value) {
        int newLevel = 0;
        while (shouldPromote() && newLevel < MAX_LEVEL) {
            newLevel++;
        }

        // If the new level is greater than the current level, update the head node and level
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                head.next[i] = null;
            }
            level = newLevel;
        }

        Node newNode = new Node(value, newLevel);
        Node current = head;

        // Start from the top layer and move down through the levels
        for (int i = level; i >= 0; i--) {
            // Move to the right in the current layer until the value is greater or equal to the target
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }

            // Insert the new node in this level
            newNode.next[i] = current.next[i];
            current.next[i] = newNode;
        }
    }

    // Helper method to print the skip list
    public void printSkipList() {
        for (int i = level; i >= 0; i--) {
            Node current = head.next[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        Random random = new Random();

        // Insert 10 random elements into the skip list
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(100);
            skipList.insert(value);
            System.out.println("Inserted: " + value);
        }

        skipList.printSkipList();

        // Perform a search for some values
        int[] searchValues = { 15, 30, 50 };
        for (int value : searchValues) {
            boolean found = skipList.search(value);
            System.out.println(value + " Found: " + found);
        }
    }
}
