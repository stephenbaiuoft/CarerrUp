package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class GreyCode {

    public static int grayCheck(byte term1, byte term2) {
        byte result =(byte) (term1 ^ term2);
        for (int i=0; i<8;i++){
            byte bitCheck =(byte) (1 <<i ) ;{
                // here is converted to result
                // check every bit position
                if (bitCheck == result)
                    return 1;
            }
        }
        return 0;
    }
}
