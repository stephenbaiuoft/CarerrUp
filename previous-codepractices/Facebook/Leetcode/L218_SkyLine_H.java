package Leetcode;


import java.util.*;

public class L218_SkyLine_H {
    //[Li, Ri, Hi]
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new LinkedList<>();
        }

        // store arrays
        List<int[]> rez = new ArrayList<>();
        List<int[]> heightList = new ArrayList<>();
        // lambda syntax for PriorityQueue (maxQueue)
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->(b-a));
        // treeset with ordering
        TreeSet<Integer> tq = new TreeSet<>((a,b) ->(b-a));
//        Comparator<Integer[]> c = new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return 0;
//            }
//        };

        for (int[] b: buildings) {
            // inverse arising points
            heightList.add(new int[] {b[0], -b[2]});
            heightList.add(new int[] {b[1], b[2]});
        }
        Collections.sort(heightList, (l1, l2) ->{
            if(l1[0] == l2[0])
                // note this is ascending order
                // but given rising is * -1, so
                // this makes sense!!!!!
                // 最开始到时候： -10， -1， 1， 10 （这样子） -10， -1 是进入到时候
                // 1， 10 是离开到时候  所以正好是你想要到高度 (如果都是一个x-axis的值）
                return l1[1] - l2[1];
            // ascending order
            return l1[0] - l2[0];
        } );

        int prev = 0;
        int cur = 0;
        // init height of 0
        queue.add(0);
        for (int[] h: heightList) {
            // ascending order
            if (h[1] < 0) {
                // flip sign and add to queue
                queue.add(-h[1]);
            }else {
                // end of that particular height: take it out
                queue.remove(h[1]);
            }
            // get the max that @ point ( so prev != cur would avoid duplicates @ the same axis)
            cur = queue.peek();
            // 这行代码很重要哦
            if (prev != cur)
            {
                rez.add(new int[]{h[0],cur});
                prev = cur;
            }
        }

        return rez;
    }
}
