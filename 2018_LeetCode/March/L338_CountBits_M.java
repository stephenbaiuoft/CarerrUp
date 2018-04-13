package March;

public class L338_CountBits_M {

    public int[] countBits(int num) {
        int[] rez = new int[num+1];

        for(int i =1; i < num+1; i++) {
            // idea
            // 之前是 后面的bits 加起来的
            // 一个数字 n1 = 2^3 + 2^2 + 2^1 (3 bits)
            //         n2 = 2^(3+1) + 2^(2+1) + 2^(1+1) + last_bit offset

            //         n2 / 2 = n1 ---> map 到 dp[n1] # of bits
            //         last bit of n2 --> n2%2 == 1? whether and this means 1 bit
            rez[i] = rez[i/2] + i % 2;
        }

        return rez;
    }
}
