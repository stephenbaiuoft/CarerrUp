package recursion_subproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L301_RemoveDuplicates_H {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0 ;
        // do this check
        // compute left, right outstanding
        for(char c: s.toCharArray()) {
            if (c == '(') left ++;
            if (c == ')') {
                if (left == 0) right++;
                else {
                    left--;
                }
            }
        }

        HashSet<String> answer = new HashSet<>();
        dfs(answer, 0, s, left, right);
        List<String> l = new ArrayList<>(answer);

        return l;
    }

    // any ) # of preceeding pairs should be found
    private boolean isValid(String s) {
        // keep  left ( for ou
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left ++;
            }
            else if (c == ')') { // the case for ')'
                left --;
            }

            if (left < 0 ) return false;
        }

        return left == 0;
    }

    // dfs conditions
    // start of subString (之前的index肯定已经被explore过了)
    // subString ->这样才能很快的keep track string的 状态
    // substring s = s1 +  ( + s2  ==> s1所有的可能 都会被dfs所遍历到 所以用start来标识
    //
    protected void dfs(HashSet<String> answer, int start,  String subString, int left, int right) {
        if (left == 0 && right == 0 && isValid(subString)) {
            answer.add(subString);
            return;
        }

        // explore
        for (int i = start; i < subString.length(); i++) {
            char cur = subString.charAt(i);
            // skip duplicates
            if (i > 0 && subString.charAt(i-1) == subString.charAt(i)) {
                continue;
            }

            if (left > 0 && cur == '(') {
                dfs(answer, i, subString.substring(0, i) + subString.substring(i+1),
                        left -1, right);

            } else if (right > 0 && cur == ')') {
                dfs(answer, i, subString.substring(0, i) + subString.substring(i+1),
                        left, right-1);
            }
        }
    }
}
