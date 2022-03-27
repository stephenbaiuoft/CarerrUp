package javamethods;

import sun.awt.image.ImageWatched;

import java.sql.Array;
import java.util.*;

public class ListDiff {

    // https://qccs.me/classes/cs313/fried/website/list_comparison.html

    /**
     * Sometimes it is difficult to predict which one is best without testing, but here are a few tips:
     * Use an ArrayList if you need to access elements by index and you only need to insert/delete at the end.
     * Use an ArrayDeque as a stack, queue, or deque.
     * Use a LinkedList if you need to insert/delete while iterating through the list, or if you need insertion at the ends to be worst-case O(1).
     */

    public void compareLLALAD() {
        // LinkedList (faster to insert, slow to query)
        // ArrayList (faster to query, slow to insert)
        // ArrayDeque (faster to insert both ends, slow to query)


        LinkedList<String> l = new LinkedList<>();
        l.get(123); // get value of an index

        l.add("abc");// add to the end
        l.addFirst("addtohead"); // add to head
        l.indexOf("abc"); // -1 or non-exist
        // remove the rightmost element
        l.remove(); // same as removeLast()
        l.remove("someobject"); //
        // remove the first element in the list
        l.pop(); // same as removeFirst()
        //
        l.peek(); // first element
        l.peekLast(); // last element


        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addFirst("addToHeadLeft");
        deque.add("always to the end");
        deque.peek(); //leftmost
        deque.peekLast(); // rightMost
        deque.remove("nonexist"); //


    }
}
