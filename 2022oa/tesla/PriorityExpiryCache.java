package tesla;/*
Your task is to implement a te.PriorityExpiryCache with a fixed capacity.

Eviction policy:
    When an item (key-value pair) is inserted into the cache at full capacity,
    the cache should evict the lowest priority item. If multiple items have
    the same priority, the LRU (least recently used) item should be evicted.

The cache should support these operations:
    Get:
        Get the value of the key if the key exists in the cache and is not
        expired.
    Set:
        Update or insert the value of the key with a given priority value and
        expiretime.
        Set should never allow more items than maxItems to be in the cache.
        Follow the eviction policy described above if the cache is full.
    Keys:
        Return all (non-expired) keys in the cache.
    SetMaxItems:
        Change the fixed size of the cache.
        Evict enough items to reduce the cache size if necessary, following the
        eviction policy.

Example:
p5 => priority 5
e10 => expires at 10 seconds since epoch

Simon Pouliot
spouliot@tesla.com

*/


import java.util.*;

class Node{
    public Node(String key, Object value, int p, long e) {
        this.key = key;
        this.value = value;
        this.priority = p;
        this.expire = e;
    }

    String key;
    Object value;
    int priority;
    long expire;

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", priority=" + priority +
                ", expirary=" + expire /1000 +
                '}';
    }
}

public class PriorityExpiryCache
{
    int maxItems;

    // TODO(interviewee): implement this
    // check if a given key exists
    HashMap<String, Node> map;
    // priority map, used to evict based on priority
    // linkedhashset keep track of the order of insertion -> LRU
    HashMap<Integer, LinkedHashSet<Node>> pMap;
    // a data structure to evict on expirary time
    // sort on te.Node.expirary
    Queue<Node> pq;
    // keep track of time info
    // curTimestamp (during insert, and compute the expirary time for that entry, and set
    // that value as expirary time of the te.Node

    // Added data structure for tracking curp
    // this sorts on node.priority
    // add a cleanup method for minPQueue for stale entries
    Queue<Node> minPQueue;

    public PriorityExpiryCache(int maxItems)
    {
        this.maxItems = maxItems;
        map = new HashMap<>();
        pMap = new HashMap<>();
        // pq sorting on expiry
        pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.expire));
        // minPQueue sorting on priority
        minPQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.priority));
    }

    public Object Get(String key)
    {
        // We don't want to provide expired data
        this.EvictItems();

        Node curNode = map.get(key);
        if (curNode == null)
            return null;

        // for pMap
        LinkedHashSet lSet = pMap.get(curNode.priority);
        if (lSet.size() > 1) { // Update LRU
            lSet.remove(curNode);
            lSet.add(curNode);
        }

        return curNode.value;
    }

    public void Set (String key, Object value, int priority, long expire)
    {
        Long curTime = System.currentTimeMillis();
        // insertion
        if (map.get(key) == null) {
            Node newNode = new Node(key, value, priority, expire * 1000 + curTime);
            // update our data structures
            map.put(key, newNode);
            pq.add(newNode);
            minPQueue.add(newNode);
            // update pMap
            pMap.putIfAbsent(priority, new LinkedHashSet<>());
            pMap.get(priority).add(newNode);
        }
        else { // update existing node value for pMap, pq, minPQueue
            Node curNode = map.get(key);
            // for pq
            curNode.expire = expire * 1000 + curTime;
            // for minPQueue, no op
            // for pMap
            LinkedHashSet lSet = pMap.get(curNode.priority);
            if (lSet.size() == 1) {
                pMap.remove(curNode.priority);
            } else { // remove curNode from lSet
                lSet.remove(curNode);
            }
            // update pMap with new priority
            curNode.priority = priority;
            pMap.putIfAbsent(priority, new LinkedHashSet<>());
            pMap.get(curNode.priority).add(curNode);
            // update curNode value
            curNode.value = value;

        }

        // keep data structures consistent
        this.EvictItems();

    }

    public void SetMaxItems(int maxItems)
    {
        this.maxItems = maxItems;
        this.EvictItems();
    }

    /**
     * evictsItems() evicts entries until
     * - size to equal to maxItems or
     * - expiry entries are gone
     */
    void EvictItems()
    {
        // 2 rules
        // time rule
        // always want to check to remove expired items
        long curTime = System.currentTimeMillis();
        // remove from pq entries that are smaller than curTime
        while (!pq.isEmpty()) {
            Node node = pq.peek();
            if (node.expire < curTime) {
                // evict form above data structure
                node = pq.poll();
                // get rid of expired entries
                if (node.expire == Long.MIN_VALUE) {
                    continue;
                }
                evictItemsHelper(node);
            } else {
                break;
            }
        }


        // priority rule
        // smallest pq, and least recently used
        //TODO(interviewee): implement this
        while (map.size() > maxItems) {
            // get current minimum priority
            Node curpNode = getFromMinPQueue();
            LinkedHashSet lSet = pMap.get(curpNode.priority);

            Iterator<Node> iterator = lSet.iterator();
            Node entry = iterator.next();
            evictItemsHelper(entry);
        }

    }

    // Note we may have stale entries in minPQueue
    // case-> expired nodes have high priority which takes up the queue
    // We'd allow x2 of current max size before doing the clean up of minPQueue
    void cleanupminPQueue() {
        if (minPQueue.size() >= maxItems * 2) {
            Queue copy = new PriorityQueue();
            Node cur;
            Long curTime = System.currentTimeMillis();
            while (!minPQueue.isEmpty()) {
                cur = minPQueue.poll();
                if (cur.expire > curTime) {
                    copy.offer(cur);
                }
            }

            // update minPQueue to copy
            minPQueue = copy;
        }

    }

    // get the min priority of the current minPQueue that has not expired
    Node getFromMinPQueue() {
        while (!minPQueue.isEmpty()) {
            Node cur = minPQueue.poll();
            if (cur.expire == Long.MIN_VALUE) { // expired entry
                // remove this from minPQueue
                continue;
            } else { // valid entry
                return cur;
            }
        }

        cleanupminPQueue();
        return null;
    }

    // this removes info from map. pmap, and minPQueue
    void evictItemsHelper(Node node) {
        // update for minPQueue by setting to Long.MIN_VALUE
        // we'd check this special case
        node.expire = Long.MIN_VALUE;

        // map, pMap, update curp, current size
        map.remove(node.key);
        LinkedHashSet lSet =  pMap.get(node.priority);
        if (lSet.size() == 1) {
            // we can remove from pMap
            pMap.remove(node.priority);
        } else {
            // remove the head as the head is the first one inserted, so LRU
            // correction: lSet removes a given node while maintaining its insertion order
            lSet.remove(node);
            // update the nexst smallest priority
        }
    }

    // used for debugging
    void showInternalState() {
        System.out.print("map data is: ");
        this.map.keySet().forEach(
            k -> System.out.print(k + ","));
        System.out.println("");

        // pMap priority
        System.out.print("pMap data is: ");
        pMap.keySet().forEach(
                k -> {
                    System.out.print(k + "-> ");
                    pMap.get(k).forEach(
                            node -> {
                                System.out.print( node.value + ",");
                            }
                    );
                    System.out.print("| ");
                }
        );
        System.out.println("");

        System.out.print("pq data is: ");
        pq.stream().forEach(
                node -> System.out.print(node.toString() + ",")
        );
        System.out.println("");

        System.out.print("minPQueue data is: ");
        minPQueue.stream().forEach(
                node -> System.out.print(node.toString() + ", ")
        );
        System.out.println("\n\n");
    }
}