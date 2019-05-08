package Codebase.stringrelated;

public class L54_StringToIntegerAtoi_M {
    public int atoi(String str) {
        if(str.length() == 0) return 0;
        // get rid of any leading and trailing white spaces
        String s = str.trim();

        int index = 0, rez = 0, sign = 1, tmp = 0;

        // check sign
        if( s.charAt(index) == '-' || s.charAt(index) == '+') {
            sign = s.charAt(index) == '-' ? -1: 1;
            index ++;
        }

        while(index < s.length()) {
            tmp = s.charAt(index) - '0';
            // sanity check
            if (tmp < 0 || tmp > 9) break;
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < rez || Integer.MAX_VALUE/10 == rez
                    && Integer.MAX_VALUE %10 < tmp){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // update rez
            rez = rez * 10 + tmp;
            index++;
        }

        //return final result
        return rez * sign;
    }
}
