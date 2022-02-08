package Leetcode;

import java.util.LinkedList;

public class L346_E {
    class MovingAverage {
        private LinkedList<Integer> q = null;
        private int capacity = 0;
        private int sum = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            q = new LinkedList<Integer>();
            capacity = size;
        }

        public double next(int val) {
            if (capacity == 0) return 0;
            else if (q.size() == capacity) {
                int removal = q.poll();
                sum -= removal;
            }
            q.add(val);
            sum += val;
            return (double) sum/q.size();
        }
    }
}
