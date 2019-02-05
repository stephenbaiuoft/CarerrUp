package treemap;

import java.util.Map;
import java.util.TreeMap;

/*
* Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.
*
* */

public class L846_HandOfStraights_M {

    class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            TreeMap<Integer, Integer> count = new TreeMap();
            for (int card: hand) {
                if (!count.containsKey(card))
                    count.put(card, 1);
                else
                    count.replace(card, count.get(card) + 1);
            }

            while (count.size() > 0) {
                int first = count.firstKey();
                for (int card = first; card < first + W; ++card) {
                    if (!count.containsKey(card)) return false;
                    int c = count.get(card);
                    if (c == 1) count.remove(card);

                    //这个replace还是用得蛮好的
                    else count.replace(card, c - 1);
                }
            }

            return true;
        }
    }

    public boolean isNStraightHand(int[] hand, int W) {
        //sanity check
        // variable init
        if (hand == null || W == 1)
            return true;
        // 5 can't be arranged to groups of 3 consecutive sets
        if (hand.length % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card: hand) {
            // each card with tot number for each value
            map.put(card, map.getOrDefault(card, 0)+1);
        }


        while (!map.isEmpty()) {
            // get the current smallest key
            int initV = map.firstKey() - 1;
            for (int i = 0; i < W; i++) {
                if (!update(map, initV + i)) {
                    return false;
                }
            }
        }
        // can be arrange in such a way
        return true;
    }

    // update given the curSmall
    private boolean update(TreeMap<Integer, Integer> map, int curSmall) {
        // get the strictly higher entry
        Map.Entry<Integer, Integer> hEntry = map.higherEntry(curSmall);
        // not existing or not consecutive
        if (hEntry == null || hEntry.getKey() != curSmall + 1)
            return false;

        // update treeMap
        map.put(hEntry.getKey(), hEntry.getValue()-1);
        // remove if it is 0
        if (map.get(hEntry.getKey()) == 0) {
            map.remove(hEntry.getKey());
        }

        return true;
    }
}
