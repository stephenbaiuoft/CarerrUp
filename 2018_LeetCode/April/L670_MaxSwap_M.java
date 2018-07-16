package April;

public class L670_MaxSwap_M {
    /*
    * 你需要一个maxidx 和maxval 来记录 应该swap的值
    * 重点就是这个 然后 另外一个case 来确定什么时候需要swap
    * */
    public int maximumSwap(int num) {
        // convert num to string --> then to char array
        char[] digits = Integer.toString(num).toCharArray();

        // idea go from right to left and always find the maxInt and the swap index
        int lIdx = -1;
        int rIdx = -1;

        int maxIdx = -1;
        int maxVal = -1;

        // loop from right to the left
        for(int i = digits.length - 1; i > -1; i--) {
            if (digits[i] - '0' > maxVal) {
                maxVal = digits[i] - '0';
                maxIdx = i;
            }
            // leave out the equal case (ignore)
            else if (digits[i] - '0' < maxVal){
                // as i goes from right to left
                lIdx = i;
                rIdx = maxIdx;
            }
        }
        // case for swapping
        if (lIdx != -1) {
            digits[lIdx] ^= digits[rIdx];
            digits[rIdx] ^= digits[lIdx];
            digits[lIdx] ^= digits[rIdx];

            return Integer.valueOf(new String(digits));
        }
        else {
            // no swap --> return original number
            return num;
        }

    }
}
