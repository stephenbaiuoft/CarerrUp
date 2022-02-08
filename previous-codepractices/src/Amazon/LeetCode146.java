package Amazon;

import Google.Leetcode17;

import java.util.HashMap;
import java.util.Queue;

/**
 * Created by stephen on 7/19/17.
 */

//LRU: least recently used Cache

// HashMap to have get(key) under o(1)
// Double linkedlist so we can re-arrange the order
public class LeetCode146 {
    public LRUCache cache;

    public LeetCode146( int n ){
        this.cache = new LRUCache(n);
    }

    public int get(int key){
        return cache.get(key);
    }
    public void put(int key, int value){
        cache.put(key, value);
    }
}


class LRUCache{
    class Node{
        public int value;
        public int key;
        public Node previous;
        public Node next;

        public Node(int key, int value){
            this.previous = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Node nodeHead;
    private Node nodeTail;


    private void addNode(Node node){
        if(nodeHead == null){
            nodeHead = node;
            nodeTail = node;
        }
        else{
            node.next = nodeHead;
            nodeHead.previous = node;

            nodeHead = node;
        }
    }

    // updates the node
    private void updateNode(Node node){
        // if already the top node
        if(nodeHead == node){
            return;
        }
        // if the tailNode
        if(nodeTail == node){
            nodeTail = node.previous;
        }

        Node P = node.previous;
        Node N = node.next;
        P.next = N;
        if(N !=null) {
            N.previous = P;
        }

        node.next = nodeHead;
        nodeHead.previous = node;

        node.previous = null;

        nodeHead = node;
    }

    private int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            updateNode(node);
            return node.value;
            // re-arrange
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            updateNode(node);
        }
        else{
            if (map.size() == this.capacity ){
                if(this.capacity == 1){
                    map.clear();
                }
                else{
                    // updateNodeTail
                    //remove from the map
                    Node removal = map.remove(nodeTail.key);

                    nodeTail = removal.previous;
                    nodeTail.next = null;
                }
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
        }
    }
}
