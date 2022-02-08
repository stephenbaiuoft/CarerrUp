package Leetcode;

import java.util.Stack;

/*
* Idea: to use a stack to keep pushing
*       bars that are incrementing i.e   1,2,2,3...,5
*
* Then: when the next incoming bar is strictly smaller, do the computation
*       O(n)
* */
public class L84_LargestRectangle_H {

    public int largestRectangleArea(int[] heights) {
        if(heights ==null || heights.length ==0) return 0;

        int rez = 0;
        int curHeight = 0;
        int h = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i <= heights.length; i ++) {
            // get the curHeight
            curHeight = i == heights.length ? 0: heights[i];
            // now the condition
            while(!stack.isEmpty()&&heights[stack.peek()]>curHeight) {
                // get the head index of the heights
                h = heights[stack.pop()];
                // the previous index before the heights
                // Reason: you pop current, but the prev relatively
                //         is still there!!!!!!!! ( so prev is Accurate!)
                start = stack.isEmpty()? -1: stack.peek();
                rez = Math.max(rez, (i - start - 1) * h);
            }
            //push the index
            stack.push(i);
        }

        return rez;
    }
}
