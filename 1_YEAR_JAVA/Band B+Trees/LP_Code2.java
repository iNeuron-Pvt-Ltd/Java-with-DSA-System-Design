class BPlusTreeNode {
    int[] keys;
    BPlusTreeNode[] children;
    int numKeys;
    boolean isLeaf;
    BPlusTreeNode next;

    public BPlusTreeNode(int degree, boolean isLeaf) {
        keys = new int[2 * degree - 1];
        children = new BPlusTreeNode[2 * degree];
        numKeys = 0;
        this.isLeaf = isLeaf;
        next = null;
    }
}

public class BPlusTree {
    private BPlusTreeNode root;
    private int degree;

    public BPlusTree(int degree) {
        this.degree = degree;
        root = new BPlusTreeNode(degree, true);
    }

    public void insert(int key) {
        if (root.numKeys == 2 * degree - 1) {
            BPlusTreeNode newRoot = new BPlusTreeNode(degree, false);
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, key);
    }

    private void insertNonFull(BPlusTreeNode node, int key) {
        int i = node.numKeys - 1;
        if (node.isLeaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numKeys++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            i++;
            if (node.children[i].numKeys == 2 * degree - 1) {
                splitChild(node, i);
                if (key > node.keys[i]) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(BPlusTreeNode parent, int childIndex) {
        BPlusTreeNode child = parent.children[childIndex];
        BPlusTreeNode newNode = new BPlusTreeNode(degree, child.isLeaf);
        parent.numKeys++;

        for (int j = parent.numKeys - 1; j > childIndex; j--) {
            parent.keys[j] = parent.keys[j - 1];
            parent.children[j + 1] = parent.children[j];
        }
        parent.keys[childIndex] = child.keys[degree - 1];
        parent.children[childIndex + 1] = newNode;

        for (int j = 0; j < degree - 1; j++) {
            newNode.keys[j] = child.keys[j + degree];
        }
        if (!child.isLeaf) {
            for (int j = 0; j < degree; j++) {
                newNode.children[j] = child.children[j + degree];
            }
        }

        child.numKeys = degree - 1;
        newNode.numKeys = degree - 1;

        if (child.isLeaf) {
            newNode.next = child.next;
            child.next = newNode;
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(BPlusTreeNode node, String prefix) {
        System.out.print(prefix);
        for (int i = 0; i < node.numKeys; i++) {
            System.out.print(node.keys[i] + " ");
        }
        System.out.println();

        if (!node.isLeaf) {
            for (int i = 0; i <= node.numKeys; i++) {
                display(node.children[i], prefix + "   ");
            }
        }
    }

    public static void main(String[] args) {
        BPlusTree bPlusTree = new BPlusTree(3);

        int[] keys = { 10, 20, 5, 6, 12, 30, 7, 17, 27 };

        for (int key : keys) {
            bPlusTree.insert(key);
        }

        System.out.println("B+ Tree structure:");
        bPlusTree.display();
    }
}
