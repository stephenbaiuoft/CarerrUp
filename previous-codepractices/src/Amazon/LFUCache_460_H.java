package Amazon;

import java.util.*;

/**
 * Created by stephen on 7/20/17.
 */

//LeetCode 460
public class LFUCache_460_H {


    public LFUCache_460_H(int capacity) {
        valueHash = new HashMap<>(capacity);
        keyFrequency = new HashMap<>(capacity);
        nodeHash = new HashMap<>(capacity);
        this.capacity = capacity;

    }

    private HashMap<Integer, Integer> valueHash;
    private HashMap<Integer, Integer> keyFrequency;
    private HashMap<Integer, freqNode > nodeHash;

    private freqNode nodeHead;
    private int capacity;


    private Boolean DEBUG = false;

     class freqNode{
        public int count;
        public LinkedList<Integer> keys;
        public freqNode previous;
        public freqNode next;


         public freqNode(int key, int count){
             this.previous = null;
             this.next = null;
             this.keys = new LinkedList<Integer>();
             this.keys.add(key);
             this.count = count;
         }
    }



    // update current node with respect to rest of the freqNodeList
    // removes headNode in cases: so check headNode is null afterwards!!!!!!
    private void updateNode(freqNode node){
        if(node.keys.size()==0){

            // removes the nodeHash
            nodeHash.remove(node.count, node);

            if(node != nodeHead){
                if(DEBUG){
                    System.out.println("not headNode");
                }
                // connection Problem!!!
                freqNode previous = node.previous;
                freqNode next = node.next;

                previous.next = next;
                if(next!=null) {
                    next.previous = previous;
                }
                return;
            }
            // case: this is the headNode being removed
            else if(node == nodeHead){

                if(DEBUG){
                    System.out.println(" headNode");
                }

                this.nodeHead = node.next;


            }
        }

    }


    // updates freqNodeList if necessary;
    private void updateFreqNodeList(){
         if( valueHash.size() == this.capacity){

            int keyRemoval = nodeHead.keys.remove();
            valueHash.remove(keyRemoval);
            keyFrequency.remove(keyRemoval, nodeHead.count);

            updateNode(nodeHead);

        }
    }

    // valid key: all 3 tables contains it!!!
    private void increFrequency( int key, int value){
        // get freq from keyFrequency hash && update keyFrequency
        int freq = keyFrequency.get(key);
        keyFrequency.put(key, freq+1);
        // update valueHash
        valueHash.put(key, value);

        // get that freq's corresponding node
        freqNode node = nodeHash.get(freq);

        // if there is one to be added
        if(nodeHash.containsKey(freq+1)){

            freqNode higherNode = nodeHash.get(freq+1);
            node.keys.remove( (Object) key);
            higherNode.keys.add(key);

            //nodeHash.put(higherNode.count, higherNode);
        }
        // need to create new Node, after currentNode
        else{

            freqNode newNode = new freqNode(key , freq + 1);

            nodeHash.put(freq+1, newNode);
            node.keys.remove( (Object) key);

            if(node.next != null)
            {
                // node <-->A <--->|

                // newNode --> A
                newNode.next = node.next;
                // newNode <--> A
                newNode.next.previous = newNode;
                // node --> newNode <--> A
                node.next = newNode;
                // node <--> newNode <--> a
                newNode.previous = node;

            }
            // node -->|
            else{
                //node <--> newNode;
                node.next = newNode;
                newNode.previous = node;
            }
        }
        if(DEBUG){
            System.out.println("Before updateNode node?");


        }
        updateNode(node);


        // valueHash: not required
        // freqNode: update if possible

    }



    public int get(int key) {
        if(DEBUG)
        {
            printHeadNodeKeys();
        }
        if(this.capacity == 0) return -1;
        if (valueHash.containsKey(key)){
            increFrequency(key, valueHash.get(key));

            if(DEBUG)
            {
                printAfterHeadNodeKeys();
            }
            return valueHash.get(key);
        }
        return -1;
    }

    // add to freqListTop if necessary or otherwise
    // this is new element so, frequency is by default 0!!!!

    // update keyFrequency List, valueHash
    private void addTop(int key, int value){
        freqNode node;
        valueHash.put(key, value);
        // if there is one to be added
        if(nodeHash.containsKey(0)){
            node = nodeHash.get(0);
            // updates corresponding tables
            node.keys.add(key);

            keyFrequency.put(key, node.count);
        }
        // build the new node
        else{
            node = new freqNode(key, 0);

            nodeHead.previous = node;
            node.next = nodeHead;
            nodeHead = node;


            keyFrequency.put(key, 0);
            // put frequency, node
            nodeHash.put(0, nodeHead);
        }
    }

    public void put(int key, int value) {
        if(DEBUG)
        {
            printHeadNodeKeys();
        }
        // default do nothing?
        if(this.capacity == 0)
            return;

        if (valueHash.containsKey(key)){
            if(DEBUG){
                System.out.println("<<<<<<<<<<<<<<<<<<<key:" + key + "    Exists!!!");
            }
            increFrequency(key, value);
        }
        else{
            updateFreqNodeList();
            if (nodeHead!=null ){
                // removeOld if necessary
               addTop(key, value);

            }
            // headNode is null
            else{

                freqNode node = new freqNode(key, 0);
                nodeHead = node;
                valueHash.put(key, value);
                keyFrequency.put(key, 0);
                // put frequency, node
                nodeHash.put(0, node);
            }

        }
        if(DEBUG)
        {
            printAfterHeadNodeKeys();
        }


    }

    private void printHeadNodeKeys(){
        if(nodeHead!=null){
            System.out.print("-------freq:"+ nodeHead.count +"|||" +
                    "#ofkeys:" + nodeHead.keys.size() +
                    "-----\n");
            if (nodeHead.keys.size() ==0){
                System.out.println("Stopped here as nodeHead has no keys!!!");

                System.exit(1);
            }
            for(Integer key: nodeHead.keys){
                System.out.print("key: " + key + ";");
            }
        }
        System.out.println("\n*****************");
    }

    private void printAfterHeadNodeKeys(){
        if(nodeHead!=null){
            System.out.print("-------freq:"+ nodeHead.count +"|||" +
                    "#ofkeys:" + nodeHead.keys.size() +
                    "-----\n");
            if (nodeHead.keys.size() ==0){
                System.out.println("Stopped here as nodeHead has no keys!!!");

                System.exit(1);
            }
            for(Integer key: nodeHead.keys){
                System.out.print("key: " + key + ";");
            }
        }
        System.out.println("\n******END Iteration*****");
    }


}
// Mark Main Test Files

/*
        int t = 4;
        if(t ==0) {
            String input = "[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2]," +
                    "[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30]," +
                    "[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4]," +
                    "[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7]," +
                    "[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4]," +
                    "[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8]," +
                    "[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19]," +
                    "[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]";
            Pattern pattern = Pattern.compile("([\\d]+[,\\d]*)");

            List<int[]> numInput = new LinkedList<>();

            Matcher match = pattern.matcher(input);

            String tmp;
            String[] ary;

            LFUCache_460_H program = new LFUCache_460_H(10);

            int index = 0;
            int pI = 0;
            while (match.find()) {
                tmp = match.group();
                ary = tmp.split(",");


                System.out.print("\n\nindex value:" + index + "   ");


                if (ary.length > 1) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>putting key:" + ary[0]
                            + "  value:" + ary[1]
                    );

                    program.put(Integer.parseInt(ary[0]), Integer.parseInt(ary[1]));
                    pI += 1;

                } else if (ary.length == 1) {
                    System.out.println("==============================================getting key:" + ary[0]);
                    System.out.println(program.get(Integer.parseInt(ary[0])));
                }
                index += 1;
            }
        }




//        ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
//
        else if (t ==1){
        LFUCache_460_H program = new LFUCache_460_H(2);
        program.put(1,1);
        program.put(2,2);
        System.out.println(program.get(1));
        program.put(3,3);
        System.out.println(program.get(2));
        System.out.println(program.get(3));
        program.put(4,4);
        System.out.println(program.get(1));
        System.out.println(program.get(3));
        System.out.println(program.get(4));
        }

        else if(t ==2) {
            LFUCache_460_H program = new LFUCache_460_H(2);
            program.put(2, 1);
            program.put(2, 2);
            program.get(2);
            program.put(1, 1);
            program.put(4, 1);
            program.get(2);
        }


        else if (t ==3){
        LFUCache_460_H program = new LFUCache_460_H(1);
        program.put(2,1);
        program.get(2);
        program.put(3,2);
        program.get(2);
        program.get(3);
        }

        else if (t== 4){
            LFUCache_460_H program = new LFUCache_460_H(2);
            program.put(3,1);
            program.put(2,1);
            program.put(2,2);
            program.put(4,4);
            System.out.println( program.get(2) ) ;


        }

        // 1,-1,3,-1,3,4
        else {
            LFUCache_460_H program = new LFUCache_460_H(2);
            program.put(100, 1);
            program.put(200, 2);
            System.out.println(program.get(100));       // returns 1
            program.put(300, 3);    // evicts key 2

            System.out.println(program.get(200));       // returns -1 (not found)
            System.out.println(program.get(300));
            // returns 3.
            program.put(400, 4);    // evicts key 1.
            System.out.println(program.get(100));       // returns -1 (not found)
            System.out.println(program.get(300));       // returns 3
            System.out.println(program.get(400));       // returns 4
        }

* */
