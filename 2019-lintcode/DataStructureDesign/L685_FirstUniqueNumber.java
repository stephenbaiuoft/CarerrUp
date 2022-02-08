package DataStructureDesign;

import java.util.*;

public class L685_FirstUniqueNumber {
    class DataStream {
//        private Node dummyHead = new Node(2019);
//        private Node dummyTail = dummyHead;
//        HashMap<Integer, Node> map = new HashMap<>();
//        HashSet<Integer> duplicateSet = new HashSet<>();
//
//        private void add(int num) {
//            // duplicateSet contains it
//            if (duplicateSet.contains(num)) {
//                return;
//            }
//            //
//            if (!map.containsKey(num)) {
//                Node node = new Node(num);
//                map.put(num, node);
//                add(node);
//            }
//
//        }

    }

    class Node {
        public int value;
        public int count;
        public Node next;
        public Node(int v) {
            this.value = v;
        }
    }

    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        HashSet<Integer> duplicateSet = new HashSet<>();
        boolean toBreak = false;

        for (int i = 0; i < nums.length; i++) {
            if (toBreak) break; // break out of the loop
            if (nums[i] == number) toBreak = true; // next loop exit
            // duplicateSet
            if (duplicateSet.contains(nums[i])) {
                continue; // skip this entry
            } else { // duplicate does not contain
                // 2 cases
                // case 1: brand new --> even set does not contain
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                } else { // set does contain it
                    duplicateSet.add(nums[i]); // move this element to duplicateSet
                    set.remove(nums[i]);
                }
                // case 2: second time showing
            }

        }
        if (!duplicateSet.contains(number) && !set.contains(number)) {
            return -1;
        }

        Iterator<Integer> itr=  set.iterator();
        if (itr.hasNext()) {
            return itr.next();
        }
        return -1;
    }

}
