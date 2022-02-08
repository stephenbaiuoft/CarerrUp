package ByMonth.august.May;

import java.util.LinkedList;
import java.util.List;

public class L500_FindWords_E {
    public L500_FindWords_E() {
        String[] input = new String[] {
                "asdfghjkl","qwertyuiop","zxcvbnm"
        };
        String[] rez = findWords(input);

    }
    public String[] findWords(String[] words) {

        if(words == null || words.length == 0) return new String[]{};
        List<String> list = new LinkedList<>();
        String[] rows = new String[]{
                "qwertyuiopQWERTYUIOP",
                "asdfghjklASDFGHJKL",
                "zxcvbnmZXCVBNM"
        };

        for(String word: words){
            int index = 0;
            for(int i = 0; i < 3; i++) {
                if(word.length() > 0 && rows[i].indexOf(word.charAt(0)) > -1) {
                    // found
                    index = i;
                    // break out of the loop
                    break;
                }
            }

            int j = 1;
            for(j = 1; j < word.length(); j++) {
                if(rows[index].indexOf(word.charAt(j)) == -1) {
                    break;
                }
            }

            if (j == word.length()) {
                list.add(word);
            }
        }

        // return the end result
        return list.toArray(new String[list.size()]);

    }
}
