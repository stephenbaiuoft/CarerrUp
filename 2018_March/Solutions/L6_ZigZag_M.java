package Solutions;

public class L6_ZigZag_M {
    public L6_ZigZag_M() {
        String s = "ABC";
        String rez = convert(s, 2);
    }

    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1) return s;

        // create StringBuilder array to store the string in order
        StringBuilder[] sbArray = new StringBuilder[numRows];
        int i = 0;

        int[] resultI = getIndex(numRows);
        // important!!! 0,1,2,3,4  ==> modulus 5 (count # of elements)
        // i % 5!!!
        int modu = 2 * numRows ;
        // incrementally loop through the string
        // and logically put into string buffer
        while(i < s.length()) {
            int rowIndex = resultI[ i % modu ];
            if(sbArray[rowIndex] == null) {
                sbArray[rowIndex] = new StringBuilder();
            }
            sbArray[rowIndex].append(s.charAt(i));

            // increment i;
            i++;
        }
        // loop through array to get everything together
        int r = 1;
        while(r < sbArray.length) {
            if (sbArray[r]!= null)
                sbArray[0].append(sbArray[r].toString());
            r++;
        }

        return sbArray[0].toString();
    }

    // build the rotational index for numRows
    // index of s.length() modulus 2n - 2 (peak and end)
    // to moduelus  i % ((2n-2) + 1)
    private int[] getIndex(int numRows) {
        // create # of numRows
        int[] resultI = new int[2*numRows - 2];

        // numRows = 3  (2*3-2 = 4)
        // (0,0) (1,1) (2,2) (3, 1)
        for(int i = 1; i < 2*numRows - 2; i++) {
            if(i < numRows) {
                resultI[i] = i;
            } else {
                resultI[i] = 2* numRows - 2 - i;
            }
        }
        return resultI;
    }
}
