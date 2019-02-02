package brain_teaser;

/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
a move consists of either replacing one occurrence of "XL" with "LX",
or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end,
 return True if and only if there exists a sequence of moves to transform one string to the other.

Example:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: True
Explanation:
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
* */

/*
* //https://leetcode.com/problems/swap-adjacent-in-lr-string/solution/
*
* 思路
* 1. 找规律
* 2. induction 总结！
* */
public class L777_SwapAdjacentInLRString_M {


    public boolean canTransform(String start, String end) {
        // L and R cannot change their relative positions based on the given two transformation
        if (!start.replaceAll("X", "").
                equals(end.replaceAll("X", "")))
            return false;

        int eIdx = 0;
        for (int i = 0; i < start.length(); i++) {
            // this also works because --> LR order has been checked already
            // so this means the while-loop latter won't ever run out of the boundary
            if (start.charAt(i) == 'L') {
                // find L
                while (end.charAt(eIdx) != 'L') {
                    eIdx++;
                }
                if (i < eIdx) {
                    return false;
                }
                // update eIdx
                eIdx++;
            }
            else if (start.charAt(i) == 'R') {
                while (end.charAt(eIdx) != 'R') {
                    eIdx++;
                }
                if (eIdx < i) {
                    return false;
                }
                eIdx++;
            }
        }

        return true;
    }

}
