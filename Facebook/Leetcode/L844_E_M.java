package Leetcode;

/*
* Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

    Example 1:

    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".
    Example 2:

    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".
    Example 3:

    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".
    Example 4:

    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".
    Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.
    Follow up:

    Can you solve it in O(N) time and O(1) space?
* */

/*
* O(1)的space的trick在于
* 用offset从后面开始运算
* */
public class L844_E_M {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;

        while (true) {
            // 通过backOffset来存有多少个 #， 然后再去 LINK 让 i变少
            for (int backOffset = 0; i >= 0 && (backOffset > 0 || S.charAt(i) == '#'); i--) {
                // if not backspace, then you may safely -1
                backOffset += S.charAt(i) == '#'? 1: -1;
            }

            for (int backOffset = 0; j >= 0 && (backOffset > 0 || T.charAt(j) == '#'); j--) {
                // if not backspace, then you may safely -1
                backOffset += T.charAt(j) == '#'? 1: -1;
            }

            // base condition --> both reached the end of the string
            if (i == -1 && j == -1) return true;
                // now we can compare j and j character
            else if ( i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }

//        while (true) {
//            for (int backOffset = 0; i >= 0 && (backOffset > 0 || S.charAt(i) == '#'); i--)
//                backOffset += S.charAt(i) == '#' ? 1 : -1;
//
//            for (int backOffset = 0; j >= 0 && (backOffset > 0 || T.charAt(j) == '#'); j--)
//                backOffset += T.charAt(j) == '#' ? 1 : -1;
//
//            // base condition --> both reached the end of the string
//            if (i == -1 && j == -1) return true;
//
//            else if (i < 0 || j < 0 ||S.charAt(i) != T.charAt(j)) {
//                return false;
//            }
//            i--;
//            j--;
//        }

    }


}
