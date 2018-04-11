package April;

import java.util.*;

public class L347_TopKFrequent_M {

    public List<Integer> topKFrequent(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        if(nums == null || k < 1) return list;

        // treemap with freq as key and list as value
        TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for(int num: nums) {
            // default value if not exists
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> e: hMap.entrySet()) {
            if(!tMap.containsKey(e.getValue())) {
                LinkedList<Integer> l = new LinkedList<>();
                tMap.put(e.getValue(), l);
            }
            tMap.get(e.getValue()).add(e.getKey());
        }

        while(list.size()< k) {
            // pollLast starts from the highest!!!!!!
            List<Integer> l = tMap.pollLastEntry().getValue();
            // add l to list
            list.addAll(l);
        }

        return list;
    }
}
