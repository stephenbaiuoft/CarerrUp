package Leetcode;

public class L461_H_E {
    public L461_H_E(){
        hammingDistance(1,4);
    }

    public int hD_v2(int x, int y) {
        int rez = x ^ y;
        return Integer.bitCount( rez);
    }

    public int hammingDistance(int x, int y) {
        int rez = x ^ y;
        int count = 0;
        for(int i = 0; i < 31; i ++) {
            int tmp = 1 << i;
            if ((rez & tmp) > 0){
                count+=1;
            }
        }
        return count;
    }
}
