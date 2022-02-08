package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
// http://www.cnblogs.com/airwindow/p/4230045.html

public class L89_GreyCode_M {
    // normal way:

    // note next bit n is just reverse order + 2^(n-1)
    /**
     * 00, 01 | 11( = 01 + 10), 10 (= 00 + 10)
     * 000, 001, 011, 010 | 011 (=100+010), 111 (=100+011) and etc
     */

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n ==0){
            result.add(0);
            return result;
        }
        // hanlde n = 1 case
        result.add(0);
        result.add(1);

        for(int i = 2; i <=n; i ++){
            // getting last to first
            // starting at
            int add = 1 << (i-1);
            for(int j = (1 << (i - 1)) - 1; j > -1; j -- ){
                result.add (result.get(j) + add);
            }
        }

        return result;
    }



    // hacking or sth interesting to know:
    // grey code generation: g(i) = i ^(xor) i/2
/**
    public List<Integer> grayCode(int n) {
         List<Integer> result = new LinkedList<>();

         for(int i = 0; i < 1<<n; i++) {
         result.add( (i^ (i>>1)) );
         }
         return result;
         }
 */


}
