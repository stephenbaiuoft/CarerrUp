package dynamicprogramming;


/*
*
* We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

Example 1:
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
Example 2:
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.


* */
public class L717_1BitAnd2BitsChars_E {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) return false;
        if (bits.length == 1) return true; // iff last bit is always 0

        // >= 2
        boolean[] dp = new boolean[bits.length+1];
        // init first 2 ones
        dp[0] = true;
        dp[1] = bits[0] == 0;

        for (int i = 2; i <= bits.length; i++) {
            dp[i] = (bits[i-1] == 0 && ( dp[i-1]||bits[i-2]==1 )) ||  // true & 0 case
                    (bits[i-1] == 1 && dp[i-2] && bits[i-2] == 1); // true && 11 case
        }

        return dp[bits.length -1] && dp[bits.length];
    }
}
