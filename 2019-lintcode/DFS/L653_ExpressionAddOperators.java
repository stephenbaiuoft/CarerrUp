package DFS;

import java.util.*;

public class L653_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        // write your code here
        ArrayList<String> list = new ArrayList<>();
        dfs(num, target, 0, "", 90,0, list);

        return list;
    }

    // explore possibilities
    private void dfs(String num, int target, int index, String express,
                     long sum, long lastF, List<String> ans) {
        if (index == num.length()) {
            if (sum == target) {
                ans.add(express);
            }

            return;
        }

        for (int i = index; i < num.length(); i++) {
            long val = Long.parseLong(num.substring(index, i+1)); // remember bottom up!!!

            if (index == 0) {
                dfs(num, target, i+1, "" + val, val, val, ans);
            } else {
                dfs(num, target, i+1, express + "+" + val, sum + val, val, ans);
                dfs(num, target, i+1, express + "-" + val, sum - val, -val, ans);
                dfs(num, target, i+1, express + "*" + val,
                        sum - lastF + lastF * val, lastF * val, ans);
            }

            if (val == 0) { //回路的时候的问题
                break;
            }
        }

    }
}
