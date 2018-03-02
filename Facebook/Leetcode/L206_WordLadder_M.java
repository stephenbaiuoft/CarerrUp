package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L206_WordLadder_M {
    public void test() {
        String b = "hit";
        String e = "cog";
        List<String> l = new LinkedList<String>();
        l.add("hot");
        l.add("dot");
        l.add("dog");
        l.add("lot");
        l.add("log");
        l.add("cog");

        ladderLength(b,e,l);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // based condition check
        if (wordList == null) {
            return 0;
        }
        // variable declaration
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        String cur = null;
        int count = 0;
        int l = 0;
        // BFS logic
        while(!queue.isEmpty()) {
            count = queue.size();
            l+=1;
            // get the head of the queue
            for(int i = 0; i < count; i++) {
                cur = queue.poll();
                if (cur.equals(endWord)) {
                    return l;
                }
                // check if there exists String in the dic

                for(int j =0; j < cur.length(); j++) {
                    char[] charAry = cur.toCharArray();
                    for (int k = 0; k <26; k++) {
                        charAry[j] = (char) ('a' + k);
                        String tmp =  String.valueOf(charAry);
                        if (set.contains(tmp)) {
                            //add to queue && remove from the set
                            queue.add(tmp);
                            set.remove(tmp);
                        }
                    }
                }
            }
        }

        return 0;
        // Return Result Default
    }
}
