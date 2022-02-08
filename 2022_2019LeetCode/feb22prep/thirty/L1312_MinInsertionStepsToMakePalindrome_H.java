package feb22prep.thirty;

public class L1312_MinInsertionStepsToMakePalindrome_H {

    public static void main(String[] args) {
        L1312_MinInsertionStepsToMakePalindrome_H p = new L1312_MinInsertionStepsToMakePalindrome_H();
    }

    public L1312_MinInsertionStepsToMakePalindrome_H() {
        minInsertions("aaa");
    }

    /**
     * 思路
     *
     * Let visited[i][j] => the minimum you can add to S so that S becomes palindrome
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        if (s == null || s.length() < 2) return s.length();

        int[][] visited = new int[s.length()][s.length()];
        return dp(0, s.length() - 1, visited, s);

    }

    public int dp(int i, int j, int[][] visited, String s) {
        // Base condition
        if (i >= s.length() || j < 0 || i > j) {
            return 0;
        }

        if (i == j) return 0; // Base case, but it should be left out here
        if (visited[i][j] != 0) return visited[i][j];
        else {
            if (s.charAt(i) == s.charAt(j)) {
                // given s[i] == s[j], so it should be the same to insert as required
                visited[i][j] = dp(i+1, j -1, visited, s);
            } else { // not equal
                visited[i][j] = Math.min( // --> Note you use min here
                        dp(i, j-1, visited, s),
                        dp(i+1, j, visited, s)) + 1; // 1 to make it match
            }
        }

        return visited[i][j];

    }
}
