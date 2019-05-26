package ByMonth.august.april;

import java.util.LinkedList;
import java.util.List;

public class L282_ExpressionAddOp_H {
    private List<String> rez = new LinkedList<>();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) return rez;
        dfsHelper(num, 0, target, "", 0, 0);

        return rez;
    }

    // DFS helper s.t it will explore all possibilities
    private void dfsHelper(String num, int pos, int target, String expr, long prev, long curr) {
        // base case
        if (pos == num.length()) {
            if (prev == target) {
                // add expression to rez
                rez.add(expr);
            }
        }

        // other cases
        for(int i = pos; i < num.length(); i++) {
            // case of "105" with 5  ---->  "1*05" which is not allowed
            // so pos is 0 in this casee!!!
            if( i!= pos && num.charAt(pos) == '0') break;
            // parse out the long value first
            long val = Long.parseLong(num.substring(pos, i+1));
            String t = num.substring(pos, i+1);
            // case 1 where pos and we are just filling the value for prev and curr
            // note prev is the evaluation
            if(pos == 0) {
                dfsHelper(num, i+1, target, expr + t, val, val);
            }
            else {
                // add
                dfsHelper(num, i+1, target, expr + "+" + t, prev + val , val);
                // subtract
                dfsHelper(num, i+1, target, expr + "-" + t, prev - val , -val);
                // multiply!!!
                dfsHelper(num, i+1, target, expr + "*" + t, prev - curr + val * curr , val * curr);
            }
        }

    }

}
