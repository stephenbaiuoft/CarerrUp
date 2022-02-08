package Amazon;
/**
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.


 */

public class L29_IntegerDivision_M {

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : 0 - dividend;
        }

        // ++/ -- ==> sign: false --> stay unchanged
        // +-/-+ ==> sign: true  --> times * - 1
        boolean sign = (dividend > 0) ^ (divisor > 0) ;

        long divid =  Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);
        int res = 0;

        while (divid >= divis) {
            long tmpDivis = divis;
            int count = 1;
            while (divid >= (tmpDivis << 1) ) {
                count <<= 1;
                tmpDivis <<= 1;
            }

            // or meaning add
            res |= count;
            divid -= tmpDivis;
        }

        return sign ?0 - res: res;
    }

}
