package Amazon;

import java.util.HashSet;
import java.util.List;

/**
 *
 String beginWord = "hit";
 String endWord = "cog";
 List<String> wordList = new ArrayList<>();
 //wordList = ["hot","dot","dog","lot","log","cog"]
 wordList.add("hot");
 wordList.add("dog");
 wordList.add("lot");
 wordList.add("log");
 wordList.add("cog");

 program.ladderLength(beginWord, endWord, wordList);
 */


public class L127_WordLadder_M {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            HashSet<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            distance++;
            // meaning does not exist!
            if (toAdd.size() == 0) return 0;
            // updating reached Queue
            reached = toAdd;
        }
        return distance;
    }
}
