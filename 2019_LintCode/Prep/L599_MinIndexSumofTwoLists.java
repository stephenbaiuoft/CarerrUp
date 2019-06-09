package Prep;

import java.util.*;

public class L599_MinIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minCommon = Integer.MAX_VALUE;
        List<String> rez = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            String tmp = list2[i];
            if (map.containsKey(tmp)) {
                set.add(tmp); // exists to second set
                if (i+map.get(tmp) <=minCommon) {
                    minCommon = i + map.get(tmp);
                    // update the map
                    map.put(tmp, minCommon);
                } else { // need to remove it... because 1 element may have minValue for
/*
*
* put:
["dixyp","uq","q","KFC"]
["yl","fjugc","rlni","dixyp","uq","q","KFC"]
Output:
["dixyp","KFC"]
Expected:
["dixyp"]

* */
                    map.remove(tmp);
                }
            }
        }

        for (Map.Entry<String, Integer> e: map.entrySet()) {
            if (e.getValue() == minCommon && set.contains(e.getKey())) {
                rez.add(e.getKey());
            }
        }

        String[] array = rez.toArray(new String[rez.size()]);
        return array;

    }
}
