package feb22prep.thirty;

import java.util.*;

public class L720_LongestWordDic_M {
    /**
     * https://leetcode.com/problems/longest-word-in-dictionary/
     *
     * Given an array of strings words representing an English Dictionary,
     * return the longest word in words that can be built one character at a time by other words in words.
     *
     * If there is more than one possible answer, return the longest word
     * with the smallest lexicographical order. If there is no answer, return the empty string.
     */


    class Node {
        HashMap<Character, Node> children;
        Character cur;
        int wordIndex;
        public Node(Character c) {
            this.cur = c;
            children = new HashMap<>();
        }
    }

    class Trie {
        // Head node
        Node root;
        String[] words;

        public Trie() {
            root = new Node('0');
        }

        public void setWords(String[] words) {
            this.words = words;
        }

        public void insert(String word, int index) {
            Node cur = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }

            // Update the last node as it's a word
            cur.wordIndex = index;
        }

        // DFS from root, use Stack to continue from 1 choice all the way
        public String dfs() {
            String ans = "";
            // Use stack - 因为stack肯定是 first in, last out, 所以相当于 你这个node 以及能遇到的 全部trace到底!!!
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                // This is the cause we can explore
                if (cur == root || cur.wordIndex > 0) {
                    if (cur != root) { //
                        String word = words[cur.wordIndex-1];
                        if (word.length() > ans.length()
                                ||
                                word.length() == ans.length() && word.compareTo(ans) < 0
                                )
                        {
                            ans = word;
                        }

                    }
                    // Continue going next, only towards if can be counted
                    for (Node neighbor: cur.children.values()) {
                        if (neighbor.wordIndex >0) {
                            stack.push(neighbor);
                        }
                    }

                }

            }

            return ans;
        }

    }

    public String longestWord(String[] words) {
        Trie tree = new Trie();
        tree.setWords(words);

        for (int i = 0; i < words.length; i++) {
            tree.insert(words[i], i+1);
        }

        return tree.dfs();
    }
}
