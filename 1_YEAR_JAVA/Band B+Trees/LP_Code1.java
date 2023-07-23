class BTreeNode {
    int[] keys;
    int degree;
    BTreeNode[] children;
    int numKeys;
    boolean isLeaf;

    public BTreeNode(int degree, boolean isLeaf) {
        this.degree = degree;
        this.isLeaf = isLeaf;
        keys = new int[2 * degree - 1];
        children = new BTreeNode[2 * degree];
        numKeys = 0;
    }
}

public class BTree {
    private BTreeNode root;
    private int degree;

    public BTree(int degree) {
        this.degree = degree;
        root = new BTreeNode(degree, true);
    }

    public void insert(int key) {
        if (root.numKeys == 2 * degree - 1) {
            BTreeNode newRoot = new BTreeNode(degree, false);
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, key);
    }

    private void insertNonFull(BTreeNode node, int key) {
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

    private void splitChild(BTreeNode parent, int childIndex) {
        BTreeNode child = parent.children[childIndex];
        BTreeNode newNode = new BTreeNode(degree, child.isLeaf);
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
    }

    public void display() {
        display(root, "");
    }

    private void display(BTreeNode node, String prefix) {
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
        BTree bTree = new BTree(3);

        int[] keys = { 10, 20, 5, 6, 12, 30, 7, 17, 27 };

        for (int key : keys) {
            bTree.insert(key);
            System.out.println("Inserted key: " + key);
        }

        System.out.println("B-Tree structure:");
        bTree.display();
    }
}
