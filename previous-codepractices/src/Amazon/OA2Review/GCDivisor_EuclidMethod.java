package Amazon.OA2Review;

public class GCDivisor_EuclidMethod {

    public int compute(int a , int b){

        int result = gcd(Integer.max(a,b), Integer.min(a,b)) ;
        return result;
    }

    // euclid's algorithm
    // a > b assumed
    private int gcd( int a, int b ) {
        if( b == 0 ) {
            return a;
        }


        return gcd(b, a%b);
    }
}
