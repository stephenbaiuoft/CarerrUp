package March;

public class L14_LongestPrefix_E {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int l = strs[0].length();
        for(int i = 0; i < l; i++) {
            char tmp = strs[0].charAt(i);
            for(int j = 1; j <strs.length; j++) {
                if(i >= strs[j].length() || tmp != strs[j].charAt(i)) {
                    // return the index is already good enough
                    return strs[0].substring(0,i);
                }
            }
        }
        // default
        return strs[0];

    }
}
