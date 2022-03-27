package twopointers.string;

public class L443_StringCompression_M {

    public int compress(char[] chars) {
        // constant space -> return resultant length of new array
        // overwrite on chars[]
        // count 10, 11, takes 2 char spaces
        // left, right, and writePos
        int left = 0, right = 0, writePos = 0;

        // always go right
        for (right = 1; right <= chars.length; right++) {
            // see a diff char
            if (right == chars.length || chars[right] != chars[right-1]) {
                // this is the case greater than 1
                if (right - left > 1) {
                    chars[writePos++] = chars[right-1];
                    char[] copy = String.valueOf(right - left).toCharArray();
                    for (int i = 0; i < copy.length; i++) {
                        chars[writePos++] = copy[i];
                    }

                } else { // = 1 case, update writePos, and copy
                    chars[writePos++] = chars[right-1];
                    // update left
                }
                // update left
                left = right;
            }
        }

        // [0, writePos), so # of total available
        return writePos;

    }
}
