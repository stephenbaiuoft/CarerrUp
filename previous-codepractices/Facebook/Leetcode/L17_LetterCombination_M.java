package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class L17_LetterCombination_M {

    public ArrayList<String> rez = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null ) {
            return rez;
        }

        String[] dic = new String[] {
                "", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        helper("", 0, dic, digits);

        return rez;

    }

    private void helper(String s, int i, String[] dic, String digits) {
        if (s.length() == digits.length()) {
            rez.add(s);
        }
        else{
            int dic_i = digits.charAt(i) - '0';
            String tmp = dic[dic_i];
            for (int j = 0; j < tmp.length(); j++) {
                helper(s+ tmp.substring(j,j+1), i+1, dic, digits);
            }
        }
    }
}
