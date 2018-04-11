package March;

public class L242_ValidAnagram_E {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length()!= t.length()) return false;
        int[] map  = new int[26];

        for(char c: s.toCharArray()) {
            int i = c - 'a';
            map[i]++;
        }

        for(char c: t.toCharArray()) {
            int i = c - 'a';
            map[i]--;
            if( map[i] < 0) {
                return false;
            }
        }

        return true;

    }
}
