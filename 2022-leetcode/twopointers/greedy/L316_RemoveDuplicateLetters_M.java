package twopointers.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class L316_RemoveDuplicateLetters_M {
    public static void main(String[] args) {
        L316_RemoveDuplicateLetters_M p = new L316_RemoveDuplicateLetters_M();
        p.removeDuplicateLettersStack("tzzbt");
    }

    // Smallest lexicographical letter
    // Condition 0: for j to be added
    // s[j] must be a new element!!!!

    // Condition 1: s[i], and s[i+1]
    // s[i] can be removed if s[i] > s[i+1] && there exists some j where s[i] = s[j], where j > i +1;
    // --> We can continue to pop the previous indices!!!!
    public String removeDuplicateLettersStack(String s) {
        Stack<Character> stack = new Stack<>();
        // per character, last occurence
        char[] array = s.toCharArray();
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            // always update the last
            lastOccurence.put(array[i], i);
        }
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            char cur = array[i];
            // only if not seen (skip duplicates)
            if (!seen.contains(cur)) {
                // stack.peek() exists a duplicate in the latter sequence
                // stack.peek() is larger than cur
                while (!stack.isEmpty() && cur < stack.peek()
                && lastOccurence.get(stack.peek()) > i) {
                    // get rid of stack && update seen
                    seen.remove(stack.pop());
                }
                // by the time here, update stack, and seen
                stack.add(cur);
                seen.add(cur);
            }

        }

        // stack -> char[] array
        // return the string
        StringBuilder sb = new StringBuilder();
        // traverse from the left?! wow
        for (char c: stack ) {
            sb.append(c);
        }

        return sb.toString();
    }

    public String smallestSubsequence(String s) {
        if (s.length() == 0) return "";

        int[] charMap = new int[26];
        char[] array = s.toCharArray();
        // cutPos, anything before cutPos is gone
        // cutPos character is unique and distinct
        int cutPos = 0;
        // charMap array that keeps count of s
        // to ensure suffix has enough for distinct elements of s, excluding pos character
        for (int i = 0; i < array.length; i++) {
            charMap[array[i] - 'a']++;
        }

        for (int i = 0; i < array.length; i++) {
            // found the character smaller than pos
            if (array[i] < array[cutPos]) {
                // update pos
                cutPos = i;
            }

            // we take i character out, and if it's 0, meaning we cannot advance i anymore at this point
            if (--charMap[array[i] - 'a'] == 0) {
                break;
            }
        }

        String cutString = s.substring(cutPos, cutPos+1);
        String next = s.substring(cutPos+1);
        next = next.replaceAll(cutString, "");


        return cutString + smallestSubsequence(next);
    }
}
