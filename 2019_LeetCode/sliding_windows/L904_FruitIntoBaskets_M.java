package sliding_windows;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

/*
题目
In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?



Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.


Note:

1 <= tree.length <= 40000
0 <= tree[i] < tree.length

* 解题思路
*
*
* 这个是一道sliding window的题目
* 1。 需要一个subarray, 只存在2种element
* 2. hashmap 存每一个value 和每一个value的count
* 3。 这样的话， 当hashmap的value count >= 3的时候意味着 之前的element需要删除
* 3。1  所以 startIndex是从头开始的index， 然后每次 increment by 1， 把与其对应value的count再减少一次
* 3。2 这样 当startIndex所在的value的count变成0的时候， 那么意味着 startIndex之后的所有的都只能是1个element
* 3。3 所以 maxL的算饭就是 i (当前的index） - startIndex (从这个index开始只有一个element) + 1 （ offset 是因为问的是总共多少个)
* */
public class L904_FruitIntoBaskets_M {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length < 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        int maxL = 0;
        for (int i = 0; i< tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            // case if it's >= 3 elements, need to handle this condition
            if (map.size() >= 3) {
                int cur = 0;
                while (map.size() >= 3) {
                    // decrement the cur count
                    cur = tree[startIndex];
                    map.put(cur, map.get(cur) - 1);
                    // remove this element
                    if (map.get(cur) == 0) {
                        map.remove(cur);
                    }
                    startIndex ++;
                }
            }
            maxL = Math.max(maxL, i - startIndex + 1);
        }
        return maxL;
    }

    public int totalFruitSet(int[] tree) {
        HashSet<Integer> set = new HashSet<>();
        int start = -1;
        int end = 0;
        int maxL = 1;

        for (int i = 0; i < tree.length; i++) {
            if ( set.contains(tree[i])) {
                maxL = Math.max(maxL, i - start);
            } else { // not containing
                set.add(tree[i]);
                // add to q
                if (set.size() == 3) {
                    start = i - 1;
                    // v is the adjacent value, regardless
                    int v = tree[start];
                    while (start > -1) {
                        if (tree[start] != v) {
                            set.remove(tree[start]); // remove this element
                            // found the element
                            break;
                        }
                        start --;
                    }
                }
                // update maxL
                maxL = Math.max(maxL, i - start);
            }
        }
        return maxL;
    }
}
