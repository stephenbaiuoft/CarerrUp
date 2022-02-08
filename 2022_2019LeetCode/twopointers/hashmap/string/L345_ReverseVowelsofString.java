package twopointers.hashmap.string;

public class L345_ReverseVowelsofString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        // aeiou, AEIOU (so meaning these are all valid vowels)
        // we are reverse only the vowels left vs right
        // two pointers (left and right) and of course, stop when left !< right
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;

        char[] sAry = s.toCharArray();
        while(left < right) {
            while( left < right && vowels.indexOf(sAry[left]) < 0) {
                left++;
            }
            while (left < right && vowels.indexOf(sAry[right]) < 0) {
                right--;
            }
            // swap
            char tmp = sAry[left];
            sAry[left] = sAry[right];
            sAry[right] = tmp;

            // now update left and right
            left++;
            right--;
        }

        return String.valueOf(sAry);
    }
}
