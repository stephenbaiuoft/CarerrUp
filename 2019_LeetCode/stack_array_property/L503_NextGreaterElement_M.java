package stack_array_property;

import java.util.*;

public class L503_NextGreaterElement_M {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) return null;
        Stack<Integer> iStack = new Stack<>(); // to store index
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] rez = new int[nums.length];

        int num = 0;
        for (int i = 0; i < nums.length*2; i++) {
            num = nums[i%nums.length];
            while (!iStack.isEmpty() && nums[iStack.peek()] < num ) {
                // iStack.pop() is the index
                map.put(iStack.pop(), num);
            }
            // keep the i as the index only to stack with limiting range 这里是我没有考虑好的
            if (i < nums.length) iStack.push(i);
        }

        for (int i = 0; i < rez.length; i++) {
            rez[i] = map.getOrDefault(i, -1);
        }
        return rez;
    }

}
