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
        dfs(list, "", n, n);

        return list;
    }

    // current string,
    private void dfs(List<String> list, String cur, int leftCount, int rightCount) {
        // base case --> all used already
        if (leftCount == 0 && rightCount == 0) {
            list.add(cur);
            return;
        }
        else if (leftCount > 0) {
            dfs(list, cur + "(", leftCount - 1, rightCount);
            if (leftCount < rightCount) {
                // explore this as well
                dfs(list, cur + ")", leftCount, rightCount - 1);
            }
        }
        else { // leftCount == 0
            dfs(list, cur + ")", leftCount, rightCount - 1);
        }

    }
}
