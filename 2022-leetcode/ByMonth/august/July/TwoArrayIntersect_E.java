package ByMonth.august.July;

import java.util.HashMap;
import java.util.LinkedList;

public class TwoArrayIntersect_E {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        LinkedList<Integer> l = new LinkedList<>();
        for (int num: nums2) {
            if (map.containsKey(num)) {
                l.add(num);
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        int[] t = new int[l.size()];

        // default is to copy every element in the linkedlist to
        // to a new int[l.size()] array!!!!!!!!!
        return t ;
    }
}
