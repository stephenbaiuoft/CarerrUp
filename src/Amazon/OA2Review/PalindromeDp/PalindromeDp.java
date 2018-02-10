package Amazon.OA2Review.PalindromeDp;

public class PalindromeDp {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] result = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        // initialize true table
        for(int i = 0; i < n; i++) {
            if( i + 1 < n && s.charAt(i) == s.charAt(i+1) ){
                result[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
            result[i][i] = true;
        }


        for(int i = 0; i < n; i++ ) {
            // try largest substring length
            for(int l = 3; i + l <= n; l ++ ) {
                int end = i + l - 1;
                if (result[i+1][end-1] && s.charAt(i) == s.charAt(end)) {
                    result[i][end] = true;
                    if(maxLength < l) {
                        start = i;
                        maxLength = l;
                    }

                }

            }
        }



        String p = s.substring(start, start + maxLength);
        System.out.println(p);
        System.out.print("\n\n\n");
        showMatrix(result);
        return p;
    }

    public void showMatrix(boolean[][] m){
        for(int i = 0; i < m.length; i++) {
            for(int j = i; j < m[0].length; j++){
                System.out.print(m[i][j] + ",");
            }

            System.out.println("");
        }

    }

}
