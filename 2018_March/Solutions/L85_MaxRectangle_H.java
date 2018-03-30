package Solutions;

import java.util.Arrays;

public class L85_MaxRectangle_H {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 ) return 0;

        int colSize = matrix[0].length;
        // left (keep track of furthest left index)
        int[] left = new int[colSize];
        // right (keep track of furthest right index)
        int[] right = new int[colSize];
        // set right to be matrix index
        Arrays.fill(right, colSize);
        // height -->each level keep track
        int[] height = new int[colSize];

        int maxVal = 0;

        for(int i = 0; i < matrix.length; i++) {
            // curRight is colSize ==> because then we can safely do right[j] - left[j] WITHOUT + 1 offset
            int curLeft = 0, curRight = colSize;
            for(int j = 0; j < colSize; j++) {
                if(matrix[i][j] =='1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for(int j = 0; j < colSize; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    // need to set this to be 0!!!!! ( otherwise, could be storing some prev value)
                    left[j] = 0;
                    // curLeft is set to j + 1 index
                    // reason: j is 0 in the else statement
                    curLeft = j + 1;
                }
            }

            for(int j = colSize -1; j > -1; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    // need to set this to be colSize!!!!! ( otherwise, could be storing some prev value)
                    right[j] = colSize;
                    // curRight is j
                    curRight = j ;
                }
            }

            for(int j = 0; j < colSize; j++) {

                int rez = (right[j] - left[j] ) *height[j];
                maxVal = Math.max(maxVal, rez);

            }
        }

        return maxVal;

    }
}
