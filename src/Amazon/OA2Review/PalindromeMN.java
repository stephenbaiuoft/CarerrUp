package Amazon.OA2Review;
import java.util.*;

public class PalindromeMN {
    public String longestPalindrome(String s) {
        char[] ary = s.toCharArray();
        // 2 is for beginning and end char, and 1 for
        char[] modified = new char[s.length()*2 + 1 + 2];
        // initially is 2 because of $#
        modified[0] = '$';
        modified[1] = '#';
        int mi = 2;
        for(int i = 0; i < s.length(); i++){
            modified[mi] = ary[i];
            mi += 1;
            modified[mi] = '#';
            mi ++;
        }
        // appending ending character
        modified[mi] = '@';

        //System.out.println("Output modified is: " +  new String(modified) );

        // initialize record to be 0 btw;
        int[] record = new int[s.length()*2 + 3];

        int centre = 1;
        // right index (with centre offset)
        int rightBoundary = 0;
        int mirror = 0;

        // MN's algorithm ==> try to find next center, and shift center to i if found
        for(int i = 1; i < modified.length - 1; i ++ ) {
            mirror = 2 * i - centre;

            if( i < rightBoundary) {
                record[i] = Math.min(record[mirror], rightBoundary - i);
            }

            while(modified[i + (1 + record[i])] == modified[ i - (1 + record[i])]) {
                record[i] ++;
            }

            if(i + record[i] > rightBoundary ){
                // found a larger centre
                centre = i;
                rightBoundary = i + record[i];
            }
        }

        // get the maxLen of the palindrome
        int maxLen = record[centre];
        int left = 0;
        int right = 0;
        int pcentre = 0;
        if ( centre%2 == 0) {
            pcentre = centre / 2  - 1;
            left = pcentre - maxLen;
            right = pcentre + maxLen;
        } else {
            left = (pcentre - maxLen)/2 - 1;
            right = (pcentre + maxLen)/2 - 1;
        }

        String tmp = s.substring(left, right );

        System.out.println("the palindrome is: " + tmp);
        return tmp;
    }
}
