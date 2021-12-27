package bfs_or_dfs;

import java.util.*;

public class L127_WordLadder_M {
    public L127_WordLadder_M() {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println( ladderLengthTwoQueue(
                "hit", "cog", words));
    }

    // This uses 2 queues so it's faster to iterate bfs
    public int ladderLengthTwoQueue(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList == null || wordList.isEmpty()) {
            return 0;
        }

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        // curQueue points to the queue to perform bfs
        Queue<String> curQueue;
        Queue<String> otherQueue;
        String cur;

        q1.offer(beginWord);
        q2.offer(endWord);
        int depth = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // to reach the first bfs
            depth ++;

            // always choose the smaller queue
            if (q1.size() < q2.size()) {
                curQueue = q1;
                otherQueue = q2;
            } else {
                curQueue = q2;
                otherQueue = q1;
            }

            int size = curQueue.size();

            for (int i = 0; i < size; i++ ) {
                cur = curQueue.poll();
                for (String neighbor: expand(cur)) {
                    if (otherQueue.contains(neighbor)) {
                        return depth + 1;
                    }

                    if (dict.contains(neighbor)) {
                        curQueue.add(neighbor);
                        dict.remove(neighbor);
                    }
                }
            }

        }
        return 0;
    }

    // 2021 Refreshing memory
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList == null || wordList.isEmpty()) {
            return 0;
        }

        // BFS needs a queue
        Queue<String> q = new LinkedList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        // another sanity check
        if (!dict.contains(endWord)) return 0;

        int depth = 0;
        String cur = null;

        q.offer(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();

            // when out of the size sweep, it's size + 1 to reach next level
            depth++;
            // per level sweep
            for (int i = 0; i < size; i++ ) {
                cur = q.poll();
                for (String neighbor: expand(cur)) {
                    // if neighbor is the same as endWord,
                    // we can safely return depth + 1 as it's neighbor, which means 1 more level
                    if (neighbor.equals(endWord)) return depth + 1;

                    // otherwise, we'd add this to our queue, and begin our lovely next work
                    if (dict.contains(neighbor)) {
                        q.offer(neighbor);
                        // make sure we won't visit again using dict
                        dict.remove(neighbor);
                    }
                }
            }

        }

        // As queue is empty, we'd finish bfs everywhere, and return -1 as it cannot be found
        return 0;

    }

    // expand all possibilities
    private List<String> expand(String input) {
        char[] inputArr = input.toCharArray();
        List<String> neighbors = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == inputArr[i]) continue; // skip as it's the same letter
                // replace
                char old = inputArr[i];
                inputArr[i] = c;
                neighbors.add(String.valueOf(inputArr));

                // restore back
                inputArr[i] = old;
            }
        }

        return neighbors;
    }



    /**
     * The following is the standard answer from 2018. Need to refresh memories a bit
     *
     */
    public int ladderLength_2017(String beginWord, String endWord, List<String> wordList) {
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
