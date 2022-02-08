package Amazon;

// Decided to use DP approach
public class L5_LongestPalindrome_M {

    /*
    *
    public String longestPalindrome(String s) {
        if( (s == null)||(s.length()==0) ) return s;
        String max = "";
        for(int i = 0; i < s.length(); i++ ){
            String tmp = expandLeftRight(s, i, i);
            if (tmp.length() > max.length()){
                max = tmp;
            }
            tmp = expandLeftRight(s, i, i+1);
            if(tmp.length() > max.length()){
                max = tmp;
            }
        }
        return max;
    }

    // return longest str @ this index
    public String expandLeftRight(String s,int left, int right){
        while(left>=0 && right < s.length()){
            if ( s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }

        return s.substring(left+1, right);
    }
    *
    *
    *
    *
    * */


    // The following is not correct as of 2021-12-28th
    // this is Topdown??
    int[][] dpTable = null;

    public String longestPalindrome(String s) {
        int n = s.length();
        dpTable = new int [n][n];
        String palinedrome = s.substring(0, 1);
        int max = 1;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if (isPalindrome(s, i, j) && j - i > max) {
                    max = j - i;
                    palinedrome = s.substring(i, j + 1);
                }
            }
        }
        return palinedrome;
    }

    // -1 nope, 1 yes, 0 not marked
    private Boolean isPalindrome(String s, int i, int j) {

        if (dpTable[i][j] != 0) {
            return dpTable[i][j] == 1;
        } else {
            // base case?
            if ( i == j) {
                dpTable[i][j] = 1;
                return true;
            } else if (i == j - 1) {
                if( s.charAt(i) == s.charAt(j) ){
                    dpTable[i][j] = 1;
                    return true;
                } else{
                    dpTable[i][j] = -1;
                    return false;
                }

            } else {
                if ( s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j -1)  ){
                    dpTable[i][j] = 1;
                    return true;
                } else {
                    dpTable[i][j] = -1;
                    return false;
                }
            }

        }

    }
}
