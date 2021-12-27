package ByMonth.august.March;

public class L66_PlusOne_E {

    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[0];

        int sum = 0;
        int carry = 1;

        for(int i = digits.length - 1; i > -1; i--) {
            sum = digits[i] + carry;
            if (sum <= 9) {
                // update that index
                digits[i] = sum;
                // early return --> enough!! important
                return digits;
            } else {
                // note the next loop will again add carry
                digits[i] = 0 ;
            }
        }

        int [] rez = new int[digits.length+1];
        rez[0] = 1;

        return rez;

    }
}
