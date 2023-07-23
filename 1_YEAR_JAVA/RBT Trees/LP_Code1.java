
class Node {
    int key;
    Node left;
    Node right;
    boolean isRed; // Indicates whether the node is red or black

    public Node(int key) {
        this.key = key;
        this.isRed = true; // New nodes are always inserted as red
    }
}

public class RedBlackTree {
    private Node root;
    public Node search(int key) {
        return searchRecursive(root, key);
    }

    private Node searchRecursive(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
        root.isRed = false; // The root node must always be black
    }

    private Node insertRecursive(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key);
        } else {
            // Key already exists in the tree
            return node;
        }

        // Perform rotations and color adjustments to maintain Red-Black Tree properties
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private void flipColors(Node node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
        if (root != null) {
            root.isRed = false; // The root node must always be black
        }
    }

    private Node deleteRecursive(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // Node to be deleted found
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // Node has two children, find the successor (smallest node in the right subtree)
                Node successor = findMin(node.right);
                node.key = successor.key;
                node.right = deleteRecursive(node.right, successor.key);
            }
        }

        // Perform rotations and color adjustments to maintain Red-Black Tree properties
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // Insert nodes into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Search for a node
        int targetValue = 30;
        Node result = tree.search(targetValue);
        if (result != null) {
            System.out.println("Node with key " + targetValue + " found.");
        } else {
            System.out.println("Node with key " + targetValue + " not found.");
        }

        // Delete a node
        int deleteValue = 50;
        tree.delete(deleteValue);
        result = tree.search(deleteValue);
        if (result == null) {
            System.out.println("Node with key " + deleteValue + " deleted.");
        } else {
            System.out.println("Deletion failed for node with key " + deleteValue + ".");
        }
    }
}
