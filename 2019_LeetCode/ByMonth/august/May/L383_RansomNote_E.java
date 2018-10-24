package ByMonth.august.May;

public class L383_RansomNote_E {
    public boolean canConstruct(String ransomNote, String magazine) {
        // assuming only lower case characters
        int count = 0;
        int[] charSet = new int[26];
        for(char c: ransomNote.toCharArray()) {
            charSet[c-'a']++;
            count++;
        }

        for(char c: magazine.toCharArray()) {
            if(charSet[c-'a'] > 0) {
                charSet[c-'a']--;
                count--;
            }
        }

        return count == 0;
    }
}
