package ByMonth.august.May;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class L398_RandomPickIndex_M {
    private HashMap<Integer, LinkedList<Integer>> map = null;

    public L398_RandomPickIndex_M(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++ ) {
            if(!map.containsKey(nums[i])) {
                LinkedList<Integer> l = new LinkedList<>();
                map.put(nums[i], l);
            }
            // add it to map
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        LinkedList<Integer> l = map.get(target);
        return l.get(new Random().nextInt(l.size()));

    }
}
