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

    public void delete(int key) {
        if (root.numKeys == 0) {
            return;
        }
        deleteKey(root, key);
        if (root.numKeys == 0 && !root.isLeaf) {
            root = root.children[0];
        }
    }

    private void deleteKey(BPlusTreeNode node, int key) {
        int index = findKeyIndex(node, key);

        if (index < node.numKeys && key == node.keys[index]) {
            if (node.isLeaf) {
                removeFromLeaf(node, index);
            } else {
                removeFromInternalNode(node, index);
            }
        } else {
            if (node.isLeaf) {
                return;
            }
            boolean isLastChild = (index == node.numKeys);
            if (node.children[index].numKeys < degree) {
                fillChild(node, index);
            }
            if (isLastChild && index > node.numKeys) {
                deleteKey(node.children[index - 1], key);
            } else {
                deleteKey(node.children[index], key);
            }
        }
    }

    private void removeFromLeaf(BPlusTreeNode node, int index) {
        for (int i = index + 1; i < node.numKeys; i++) {
            node.keys[i - 1] = node.keys[i];
        }
        node.numKeys--;
    }

    private void removeFromInternalNode(BPlusTreeNode node, int index) {
        int keyToDelete = node.keys[index];

        if (node.children[index].numKeys >= degree) {
            int predecessor = getPredecessor(node.children[index]);
            node.keys[index] = predecessor;
            deleteKey(node.children[index], predecessor);
        } else if (node.children[index + 1].numKeys >= degree) {
            int successor = getSuccessor(node.children[index + 1]);
            node.keys[index] = successor;
            deleteKey(node.children[index + 1], successor);
        } else {
            mergeNodes(node, index);
            deleteKey(node.children[index], keyToDelete);
        }
    }

    private int findKeyIndex(BPlusTreeNode node, int key) {
        int index = 0;
        while (index < node.numKeys && key > node.keys[index]) {
            index++;
        }
        return index;
    }

    private int getPredecessor(BPlusTreeNode node) {
        while (!node.isLeaf) {
            node = node.children[node.numKeys];
        }
        return node.keys[node.numKeys - 1];
    }

    private int getSuccessor(BPlusTreeNode node) {
        while (!node.isLeaf) {
            node = node.children[0];
        }
        return node.keys[0];
    }

    private void fillChild(BPlusTreeNode node, int childIndex) {
        if (childIndex != 0 && node.children[childIndex - 1].numKeys >= degree) {
            borrowFromPrevious(node, childIndex);
        } else if (childIndex != node.numKeys && node.children[childIndex + 1].numKeys >= degree) {
            borrowFromNext(node, childIndex);
        } else {
            if (childIndex != node.numKeys) {
                mergeNodes(node, childIndex);
            } else {
                mergeNodes(node, childIndex - 1);
            }
        }
    }

    private void borrowFromPrevious(BPlusTreeNode node, int childIndex) {
        BPlusTreeNode child = node.children[childIndex];
        BPlusTreeNode sibling = node.children[childIndex - 1];

        for (int i = child.numKeys - 1; i >= 0; i--) {
            child.keys[i + 1] = child.keys[i];
        }

        if (!child.isLeaf) {
            for (int i = child.numKeys; i >= 0; i--) {
                child.children[i + 1] = child.children[i];
            }
        }

        child.keys[0] = node.keys[childIndex - 1];
        if (!child.isLeaf) {
            child.children[0] = sibling.children[sibling.numKeys];
        }

        node.keys[childIndex - 1] = sibling.keys[sibling.numKeys - 1];

        child.numKeys++;
        sibling.numKeys--;
    }

    private void borrowFromNext(BPlusTreeNode node, int childIndex) {
        BPlusTreeNode child = node.children[childIndex];
        BPlusTreeNode sibling = node.children[childIndex + 1];

        child.keys[child.numKeys] = node.keys[childIndex];

        if (!child.isLeaf) {
            child.children[child.numKeys + 1] = sibling.children[0];
        }

        node.keys[childIndex] = sibling.keys[0];

        for (int i = 1; i < sibling.numKeys; i++) {
            sibling.keys[i - 1] = sibling.keys[i];
        }

        if (!sibling.isLeaf) {
            for (int i = 1; i <= sibling.numKeys; i++) {
                sibling.children[i - 1] = sibling.children[i];
            }
        }

        child.numKeys++;
        sibling.numKeys--;
    }

    private void mergeNodes(BPlusTreeNode node, int childIndex) {
        BPlusTreeNode child = node.children[childIndex];
        BPlusTreeNode sibling = node.children[childIndex + 1];

        child.keys[degree - 1] = node.keys[childIndex];

        for (int i = 0; i < sibling.numKeys; i++) {
            child.keys[i + degree] = sibling.keys[i];
        }

        if (!child.isLeaf) {
            for (int i = 0; i <= sibling.numKeys; i++) {
                child.children[i + degree] = sibling.children[i];
            }
        }

        for (int i = childIndex + 1; i < node.numKeys; i++) {
            node.keys[i - 1] = node.keys[i];
        }

        for (int i = childIndex + 2; i <= node.numKeys; i++) {
            node.children[i - 1] = node.children[i];
        }

        child.numKeys += sibling.numKeys + 1;
        node.numKeys--;

        if (sibling.isLeaf) {
            child.next = sibling.next;
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


    public static void main(String[] args) {
        BPlusTree bPlusTree = new BPlusTree(3);

        int[] keys = { 10, 20, 5, 6, 12, 30, 7, 17, 27 };

        for (int key : keys) {
            bPlusTree.insert(key);
        }

        System.out.println("B+ Tree structure before deletion:");
        bPlusTree.display();

        int keyToDelete = 12;
        bPlusTree.delete(keyToDelete);

        System.out.println("B+ Tree structure after deletion of key " + keyToDelete + ":");
        bPlusTree.display();
    }
}
