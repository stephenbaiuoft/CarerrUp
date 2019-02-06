package bfs_or_dfs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Given n pairs of parentheses,
write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
* */

public class L22_GenerateParentheses_M {
    public List<String> generateParenthesis(int n) {
        // to store strings
        List<String> list = new LinkedList<>();
        dfs(list, "", 0, 0, n);

        return list;
    }

    // current string,
    private void dfs(List<String> list, String cur, int curLeft, int curRight, int n) {
        // add to list
        if (cur.length() == 2*n) {
            list.add(cur);
        }

        if (curLeft < n) {
            dfs(list, cur + "(", curLeft+1, curRight, n);
        }
        // use another if for the other option 这个就比较make sense了 朋友
        if (curRight < curLeft) { // must be strictly less than curLeft
            dfs(list, cur + ")", curLeft, curRight+1, n);
        }
    }
}
