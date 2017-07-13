package com.company.OA2;

/**
 * Created by stephen on 1/7/17.
 */
public class GCDivisor {


    public GCDivisor(int a , int b){

        System.out.print ( gcd(Integer.max(a,b), Integer.min(a,b)) );
    }

    public int gcd ( int p, int q){
        if ( q == 0 )
            return p;

        return gcd( q, p % q );
    }
}
