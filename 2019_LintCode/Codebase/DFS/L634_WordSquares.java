package Codebase.DFS;

import java.util.*;

public class L634_WordSquares {

    // builds the prefix, and all possible choices for any given prefix
    private void buildMap(String[] words, Map<String, List<String>> map) {
        map.put("", new ArrayList<>());
        for (String word: words) {
            map.get("").add(word);

            String prefix = "";
            for (char c: word.toCharArray()) {
                prefix += c;
                map.putIfAbsent(prefix, new ArrayList<>());
                map.get(prefix).add(word);
            }
        }

    }


    // curLen also means the
    // [0, curLen+1]
    // [1, curLen+1]
    // ...
    // would give you the prefix for next word
    private boolean checkPrefix(int curLen, String nextWord, int wordLen,
                       Map<String, List<String>> map, List<String> squareList) {
        for (int j = curLen + 1; j < wordLen; j++) {// checking for remaining
            String prefix = "";
            // build the prefix so far given the squareList
            for (int i = 0; i < curLen; i++) {
                prefix += squareList.get(i).charAt(j); // j = curLen + 1
            }

            // try the nextWord
            prefix += nextWord.charAt(j);
            if (!map.containsKey(prefix)) {
                return false;
            }
        }

        // isValid for the curLen
        return true;
    }

    private void dfs(int curLen, int wordLen, Map<String, List<String>> map,
                     List<String> squareList, List<List<String>> result) {
        if (curLen == wordLen) {
            result.add(new ArrayList<>(squareList));
            return;
        }

        String prefix = "";
        for (int i = 0; i < curLen; i++) {
            prefix += squareList.get(i).charAt(curLen);
        }

        // explore all possibilities
        for (String word: map.get(prefix)) {
            if (!checkPrefix(curLen, word, wordLen, map, squareList)) {
                continue;
            }

            squareList.add(word);
            dfs(curLen+1, wordLen, map, squareList, result);
            squareList.remove(squareList.size()-1);
        }

    }

    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        buildMap(words, map);

        dfs(0, words[0].length(), map, new ArrayList<>(), result);
        return result;

    }
}
