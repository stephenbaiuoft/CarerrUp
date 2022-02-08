package feb22prep.thirty;

import java.util.*;

public class L146_LRU_M {
    // type psvm in intellij
    public static void main(String args[]) {
        L146_LRU_M c = new L146_LRU_M(2);
        c.put(1,1);
        c.put(2,2);
        c.get(1);
        c.put(3,3);
        c.get(2);
        c.put(4,4);
        c.get(1);
        c.get(3);
        c.get(4);

    }

    /**
     * Mistakes made
     * - tail once updated, you should know it's state
     * - Remember put case 4
     *  - Existing node already
     *   - update and return
     *  - New value
     *   - Capacity full case
     *    - niche case where capacity = 1
     *    - update capacity
     *   - Capacity not full
     *    - New value for the first time of insertion!!!
     *     - do the set up
     *    - Not new value, and do what you want
     */

    //https://leetcode.com/problems/lru-cache/

    class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node prev;
        Node next;
        int value;
        int key;
    }

    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    private int capacity;

    public L146_LRU_M(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    // update a node to the head
    private void update(Node node) {
        // If already head do nothing
        if (head == node) return;

        else if (node == tail) {
            // update tail
            tail = tail.prev;
            // updated tail here already
            tail.next = null;

        } else { // in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // update to head
        head.prev = node;
        node.next = head;
        head = node;
    }

    public int get(int key) {
        if (map.get(key) == null) return -1;
        else {
            Node node = map.get(key);
            update(node);
            return node.value;
        }
    }

    /**
     * Update case
     * Capacity full case
     *
     * Write new case for first time
     * Write new case non first time
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // key may exist
        Node node = map.get(key); //
        if (node != null) { // exist, update and return
            node.value = value;
            // update node to head
            update(node);
        } else { // Evict step policy
            if (map.size() == this.capacity ){
                if (1 == this.capacity) {
                    map.clear();
                }
                else { // need to remove tail
                    // Update map first before losing that info
                    map.remove(tail.key);

                    tail = tail.prev;
                    tail.next = null;

                }
            }

            // We have capacity here now
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            // First entry, init head and tail
            if (head == null && tail == null ) {
                head = newNode;
                tail = newNode;
                return;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

        }
    }


}
