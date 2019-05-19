package Codebase.dfs;

import java.util.*;

public class L136_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();

        dfs(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(String s, int index, ArrayList<String> path, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
        }

        String cur = null;
        for (int i = index; i < s.length(); i++) {
            // explore all possibilities
            cur = s.substring(index, i+1);
            if (!isPalindrome(cur)) {
                continue;
            }

            path.add(cur);
            dfs(s, i+1, path, result);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        // valid
        return true;
    }
}
