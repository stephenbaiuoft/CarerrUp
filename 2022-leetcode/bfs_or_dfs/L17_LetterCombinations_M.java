package bfs_or_dfs;

import java.util.LinkedList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
* */

/*
* 思路: backtrack
* choose,
* explore
* unchoose
*
* 只不过这里 --> 你用了string 然后每一次其实都是一个copy
* */
public class L17_LetterCombinations_M {
    public static void main(String[] args) {
        L17_LetterCombinations_M p = new L17_LetterCombinations_M();
        p.letterCombinations("23");
     }

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) return list;
        String[] map = new String[] {
                "", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"
        };

        dfs(list, digits, "", map);

        return list;
    }

    private void dfs(List<String> list, String digits, String cur, String[] map) {
        if (cur.length() == digits.length()) {
            list.add(cur);
            return; // terminate
        }

        int index = digits.charAt(cur.length()) - '0';
        String s = map[index];
        for (int i = 0; i < s.length(); i++) {
            // explore every possibility
            dfs(list, digits, cur + s.substring(i, i +1), map);
        }
    }

    // 用stringbuilder来做 就少一create一些memory
    public List<String> letterCombinationsStringBuffer(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) return list;
        String[] map = new String[] {
                "","","abc","def","ghi","jkl","mno",
                "pqrs", "tuv", "wxyz"
        };

        StringBuilder sb = new StringBuilder();
        dfs(digits, sb, list, map);
        return list;
    }

    private void dfs(String digits, StringBuilder sb, List<String> list, String[] map){
        // base case
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }

        int dIdx = sb.length(); // get sb's current length
        int mIdx = digits.charAt(dIdx) - '0';
        char[] set = map[mIdx].toCharArray();
        for (char c: set) {
            dfs(digits, sb.append(c), list, map);
            // remove last character
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
