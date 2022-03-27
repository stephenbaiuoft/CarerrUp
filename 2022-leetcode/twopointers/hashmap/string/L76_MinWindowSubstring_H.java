package twopointers.hashmap.string;

// https://leetcode.com/problems/minimum-window-substring/submissions/
public class L76_MinWindowSubstring_H {
    // 思路 2 pointer + string map
    // map[] 每一个index left 增加就+1
    // 每一个right index 就减1
    // 用SomeOperation ++ 来做最后执行 --> 去take out的时候 先读 后 写 ==  > 0
    // 用 ++SomeOperation先执行 后做 (恢复的时候) 先写 后读！！！   > 0


    public static void main(String[] args) {
       L76_MinWindowSubstring_H p = new L76_MinWindowSubstring_H();
       p.minWindow("ADOBECODEBANC", "ABC");

    }

    public String minWindow(String s, String t) {
        if(s == null || t == null || t.length() > s.length()) return "";
        int left = 0, right = 0, minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int missingCount = t.length();
        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) ] ++;
        }

        // right keeps going
        for (right = 0; right < s.length(); right++) {
            // -- decrease in the end
            if (map[s.charAt(right)]-- > 0) {
                missingCount -= 1;
            }

            // we may update left
            while (missingCount == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                // add the character back
                if (++map[s.charAt(left)] > 0){
                    missingCount += 1;
                }
                // slide left to the right
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE? "": s.substring(minStart, minStart + minLength);

    }
}
