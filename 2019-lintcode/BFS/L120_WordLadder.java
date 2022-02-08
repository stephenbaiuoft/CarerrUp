package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class L120_WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);

        int count = 1; // itself
        while (!q.isEmpty()) {
            count++; // first level
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                List<String> choices = getChoices(cur, dict);
                for (String choice: choices) {
                    if (choice.equals(end)) {
                        return count;
                    }

                    if (!visited.contains(choice)) {
                        visited.add(choice);
                        q.offer(choice);
                    }
                }
            }

        }

        return -1; // unreachable

    }

    // return a list of all possible choices for s
    private List<String> getChoices(String s, Set<String> dict) {
        char[] chars = s.toCharArray();
        ArrayList<String> choices = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (int j = 0; j < 26; j++) {
                // ignore itself
                if (c != ('a' + j) ) {
                    // replace this value
                    chars[i] = (char) ('a' + j);
                    String tmp = String.valueOf(chars);
                    if (dict.contains(tmp)) {
                        choices.add(tmp);
                    }
                }
            }
            chars[i] = c;
        }

        return choices;
    }
}
