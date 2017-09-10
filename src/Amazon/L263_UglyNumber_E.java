package Amazon;
/**
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.
 *
 */

/**
 *  idea: a number is either (2^x)(3^y)(5^z) so keep dividing them if they can be divided
 *
 */


public class L263_UglyNumber_E {
    public boolean isUgly(int num) {
        if (num == 0) return false;
        for(int divisor = 2; divisor < 6 ; divisor ++){
            while( num % divisor == 0){
                num /= divisor;
            }
        }
        // if ugly number then yes, num has to be 1
        return num == 1;
    }
}
