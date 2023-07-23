class SkipListImpl {

    // Class to implement node
    static class Node {
        int key;

        // Array to hold pointers to node of different level
        Node forward[];

        Node(int key, int level) {
            this.key = key;

            // Allocate memory to forward
            forward = new Node[level + 1];
        }
    };

    // Class for Skip list
    static class SkipList {
        // Maximum level for this skip list
        int MAXLVL;

        // P is the fraction of the nodes with level
        // i pointers also having level i+1 pointers
        float P;

        // current level of skip list
        int level;

        // pointer to header node
        Node header;

        SkipList(int MAXLVL, float P) {
            this.MAXLVL = MAXLVL;
            this.P = P;
            level = 0;

            // create header node and initialize key to -1
            header = new Node(-1, MAXLVL);
        }

        int randomLevel() {
            float r = (float) Math.random();
            int lvl = 0;
            while (r < P && lvl < MAXLVL) {
                lvl++;
                r = (float) Math.random();
            }
            return lvl;
        }

        Node createNode(int key, int level) {
            Node n = new Node(key, level);
            return n;
        }
        // Delete in Skip List

        void deleteElement(int key) {
            Node current = header;
            // create update array and initialize it
            Node[] update = new Node[MAXLVL + 1];

            /* start from highest level of skip list
                    move the current pointer forward while
            key is greater than key of node next to
            current Otherwise inserted current in update
            and move one level down and continue search
            */
            for (int i = level; i >= 0; i--) {
                while (current.forward[i] != null && current.forward[i].key < key)
                    current = current.forward[i];
                update[i] = current;
            }

            /* reached level 0 and forward pointer to
            right, which is desired position to
            delete key.
            */
            current = current.forward[0];

            if (current != null && current.key == key) {

                // delete node by rearranging pointers
                for (int i = 0; i < level; i++) {
                    if (update[i].forward[i] != current)
                        break;
                    update[i].forward[i] = current.forward[i];
                }

                //if it was the only node in that level and you deleted it, delete the level
                while (level > 0 && header.forward[level] == null) {
                    level--;
                }
                System.out.println("Successfully deleted key " + key);
            }

        }

        // Insert given key in skip list

        void insertElement(int key) {
            Node current = header;

            // create update array and initialize it
            Node update[] = new Node[MAXLVL + 1];

            /* start from highest level of skip list
                    move the current pointer forward while
            key is greater than key of node next to
            current Otherwise inserted current in update
            and move one level down and continue search
            */
            for (int i = level; i >= 0; i--) {
                while (current.forward[i] != null &&
                    current.forward[i].key < key)
                    current = current.forward[i];
                update[i] = current;
            }

            /* reached level 0 and forward pointer to
            right, which is desired position to
            insert key.
            */
            current = current.forward[0];

            /* if current is NULL that means we have reached
            to end of the level or current's key is not
            equal to key to insert that means we have to
            insert node between update[0] and current node
        */
            if (current == null || current.key != key) {
                // Generate a random level for node
                int rlevel = randomLevel();

                // If random level is greater than list's
                // current level (node with highest level
                // inserted in list so far), initialize
                // update value with pointer to header for
                // further use
                if (rlevel > level) {
                    for (int i = level + 1; i < rlevel + 1; i++)
                        update[i] = header;

                    // Update the list current level
                    level = rlevel;
                }

                // create new node with random level
                // generated
                Node n = createNode(key, rlevel);

                // insert node by rearranging pointers
                for (int i = 0; i <= rlevel; i++) {
                    n.forward[i] = update[i].forward[i];
                    update[i].forward[i] = n;
                }
                System.out.println(
                    "Successfully Inserted key " + key);
            }
        }

        // Display skip list level wise
        void displayList() {
            System.out.println("\n*****Skip List*****");
            for (int i = 0; i <= level; i++) {
                Node node = header.forward[i];
                System.out.print("Level " + i + ": ");
                while (node != null) {
                    System.out.print(node.key + " ");
                    node = node.forward[i];
                }
                System.out.println();
            }
        }

        void Search(int key) {

            Node current = header;

            /* start from highest level of skip list
                    move the current pointer forward while
            key is greater than key of node next to
            current    and move one level down and continue search
            */
            for (int i = level; i >= 0; i--) {
                while (current.forward[i] != null && current.forward[i].key < key) {
                    current = current.forward[i];
                }
            }
            current = current.forward[0];
            // current has to be the key if it is present 
            if (current != null && current.key == key) {
                System.out.println("Key found");

            } else {
                System.out.println("Key not found");
            }

        }

        int getHeight() {
             return level + 1;
        }
    }

    // Driver to test above code
    public static void main(String[] args) {
        // create SkipList object with MAXLVL and P
        SkipList lst = new SkipList(3, 0.5f);

        lst.insertElement(3);
        lst.insertElement(6);
        lst.insertElement(7);
        lst.insertElement(9);
        lst.insertElement(12);
        lst.insertElement(19);
        lst.insertElement(17);
        lst.insertElement(26);
        lst.insertElement(21);
        lst.insertElement(25);
        lst.displayList();
        lst.Search(9);
        lst.deleteElement(9);
        lst.displayList();

        System.out.println("Height of Skip List: " + lst.getHeight());

    }
}
