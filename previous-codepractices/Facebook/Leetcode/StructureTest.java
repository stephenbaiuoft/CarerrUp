package Leetcode;

import java.util.*;

public class StructureTest {

    public void Loop_Iterator() {
        HashMap<String, String> map = new HashMap<>();
        // Looping through the dictionary!!!!!
        for (Map.Entry<String, String> ssEntry : map.entrySet()) {
            ssEntry.getKey();
            ssEntry.getValue();
        }


        Iterator<Map.Entry<String, String>> mi = map.entrySet().iterator();
        while(mi.hasNext()){
            Map.Entry<String,String> tmp = mi.next();
            tmp.getValue();
            tmp.getKey();
        }

        Deque<String> deque = new ArrayDeque<>();
        Iterator<String> i = deque.iterator();
        while(i.hasNext()) {
            String val = i.next();
        }
    }

//
    public void List_Methods() {
        List<String> l1 = new LinkedList<>();
        int index = 0;
        String s1 = "value";

        // set method
        l1.set(index, s1);
        // remove based on index
        l1.remove(index);
        // remove based on object
        l1.remove(s1);

        List<String> list = new ArrayList<>();
        list.add(0, "adding to index 0");
        list.add("adding to the end of the list");
        // getting the index @ 0
        list.get(0);
        list.contains("if this value is contained in the list");
        list.indexOf("getting index of the value object");
        list.remove("an object value");
        // remove the index @ a particular object!
        list.remove( (int) 0);

    }

    public void Queue_Methods() {
        // use linkedlist as queue or arraylist
        Queue<String> q1 = new LinkedList<>();
        ArrayDeque<String> q2 = new ArrayDeque<>();

        q1.add("arg1");
        //removes head of the list FIFO --> QUEUE
        q1.poll();
        // remove last
        q1.remove();

        q2.add("arg2");
        // --> use offer instead of add
        q2.offerFirst("add to head");
        q2.offerLast("add to end");

        q2.addFirst("add to head");
        q2.addLast("add to end");

        // --> use poll instead of remove
        q2.pollFirst();
        q2.pollLast();
        q2.removeFirst();
        q2.removeLast();
        q2.isEmpty();

        StringBuilder s = new StringBuilder();
        s.append("blablabla");
    }



    public void Stack_Methds() {
        Stack<Integer> stack = new Stack<Integer>();
        // removes the tail of the list FILO --> Stack
        stack.pop();
        stack.push(5);
        stack.isEmpty();
    }


    public void HashMap_Methods(){
        HashMap<Character[], ArrayList<String>> map = new HashMap<>();
        map.keySet();
        map.values();

        Character[] key1 = new Character[0];
        map.containsKey(key1);
        map.containsValue(new ArrayList<Integer>(1));

    }

}
