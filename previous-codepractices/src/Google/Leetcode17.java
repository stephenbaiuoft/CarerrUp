package Google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stephen on 7/18/17.
 */
public class Leetcode17 {


    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits.length() == 0) return result;

        result.add("");
        String[] mapping = new String[]{
                "not used", "not used", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"
        };

        int digitValue;
        for(int i = 0; i < digits.length(); i++){
            digitValue = Character.getNumericValue(digits.charAt(i));

            while(result.peekFirst().length() < i + 1){
                String add = result.removeFirst();
                for (char s : mapping[digitValue].toCharArray()){
                    result.add(add + s);
                }
            }
        }
        return result;
    }
}
