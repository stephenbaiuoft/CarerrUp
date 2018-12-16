package bfs_or_dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L127_WordLadder_M {
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
                            // memorization -> make sure it is not visited again
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
