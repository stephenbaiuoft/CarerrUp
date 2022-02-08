package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

//Idea:

// one to store input
// another to store current_min up to that point

// 3,2,1,5,4 stack
// 3,2,1,1,1 minStack



public class L155_MinStack_E {
    /** initialize your data structure here. */

        private Deque<Integer> stack;
        private Deque<Integer> minStack;
        private int minValue;

        public L155_MinStack_E() {
             stack = new ArrayDeque<>();
             minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.size() > 0 ){
                minValue = Integer.min(x, minStack.peek());
            } else {
                minValue = Integer.min(x, Integer.MAX_VALUE);
            }
            minStack.push(minValue);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            // reset minValue
            if (minStack.size() == 0 ){
                minValue = Integer.MAX_VALUE;
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

}
