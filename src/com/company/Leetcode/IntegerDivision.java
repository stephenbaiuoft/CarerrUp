package com.company.Leetcode;

/**
 * Created by stephen on 1/14/17.
 */

// Leetcode 29
// https://leetcode.com/problems/divide-two-integers/
public class IntegerDivision {
    public IntegerDivision(int a, int b){
        System.out.print ( "Result is " + getDivision(a, b) );
    }

    // returns result for division
    public int getDivision( int dividend, int divisor){

        // Since we use abs values, so -1 is MAX after abs, MAX V
        //
        boolean sign = ( dividend > 0) ^ (divisor  > 0);

        if ( divisor == 0 ||(
                dividend == Integer.MIN_VALUE && divisor == -1
                ) ) return Integer.MAX_VALUE;
        if (divisor == 1 || divisor == -1){
            if (sign) return dividend;
            return -1 * dividend;
        }






        int result = 0;
        // count is to keep track
        int count = 0;
        long ldivisor = Math.abs( (long) divisor);
        long ldividend = Math.abs( (long) dividend);

        long tDivisor = ldivisor;
        if ( ldividend > tDivisor){
            count = 1;
            while( ldividend > (tDivisor <<1) ){
                count  = count << 1;
                tDivisor = tDivisor << 1;
            }
            ldividend = ldividend - tDivisor;
        }


        while( ldividend >= ldivisor){
            ldividend = ldividend - ldivisor;
            result ++;
        }

        result = result + count;

        if (sign) return (-1) * result;
        return result;

    }

}
