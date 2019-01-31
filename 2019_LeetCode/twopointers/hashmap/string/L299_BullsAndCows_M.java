package twopointers.hashmap.string;

import java.util.HashMap;
import java.util.HashSet;

/*
* You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

* */


public class L299_BullsAndCows_M {
    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0 ) {
            return "";
        }

        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                //previously s value, and g values comes in
                if (nums[g] > 0) cows++;
                // previous guessed value, and s comes in
                if (nums[s] <0) cows++;
                // if s value comes in, add
                // if g value comes in, substract
                nums[s]++;
                nums[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
