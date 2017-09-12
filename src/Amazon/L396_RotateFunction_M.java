package Amazon;

/**
 * Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise,
 we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */

/**
 * Idea: calculate the difference between each right shift is:
 * given a, b, c ,d  ==> d, a, b, c, d
 * difference is: a + b + c - 3*d =  a + b + c +d - 4*d = a + b + c +d - (size-1)*d every time!!
 *
 *
 * So
 *
   Each shift difference:
 a + b + c + d - size*(some value of a,b,c,d)

 So Result:
 previous += each shift difference


                Test
 L396_RotateFunction_M program = new L396_RotateFunction_M();
 int[] A = {
 4,3,2,6
 };
 program.maxRotateFunction(A);
 */
public class L396_RotateFunction_M {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0) return 0;

        int maxValue = 0;
        int initialF = 0;
        int rotationF = 0;
        int rotationAdd = 0;

        for (int i = 0; i < A.length; i++) {
            initialF += i* A[i];
            rotationAdd += A[i];
        }
        maxValue = initialF;
        rotationF = initialF;


        for(int i = A.length - 1; i >=0; i--) {
            rotationF += rotationAdd;
            rotationF -= A.length * A[i];
            maxValue = Math.max(maxValue, rotationF);
        }

        return maxValue;

    }
}
