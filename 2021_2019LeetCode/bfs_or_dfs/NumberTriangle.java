package bfs_or_dfs;

import common.helpermethods.Helper;

import java.util.*;

public class NumberTriangle {
    public NumberTriangle() {
        LinkedList<Integer> q = new LinkedList<>(Arrays.asList(4, 7, 3, 6, 7));
        List<List<Integer>> rez = new LinkedList<>();

        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> l = new LinkedList<>();
//            for (int i = 0; i + 1 < len; i++) {
//                q.add(q.get(i) + q.get(i+1));
//            }
//            for (int i = 0; i < len; i++) {
//                l.add(q.poll());
//            }
            for (int i = 0; i  < len; i++) {
                l.add(q.poll());
                if (i + 1 < len ) {
                    q.add(((LinkedList<Integer>) l).peek() + q.peek());
                }

            }


            rez.add(l);
        }

        Helper.printList(rez);
    }
}
