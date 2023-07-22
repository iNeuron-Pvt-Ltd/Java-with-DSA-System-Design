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
