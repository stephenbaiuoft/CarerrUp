package stack_array_property;

import java.util.*;

public class L496_NextGreaterElement_E {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] rez = new int[nums1.length];

        for (int n2: nums2) {
            while (!stack.isEmpty() && stack.peek() < n2 ) {
                map.put(stack.pop(), n2);
            }
            stack.push(n2);
        }

        for (int i = 0; i < nums1.length;i ++) {
            rez[i] = map.getOrDefault(nums1[i], -1);
        }

        return rez;
    }
}
