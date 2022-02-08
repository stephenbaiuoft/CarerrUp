package Leetcode;
/*
* The key is build a failTable based on the given pattern
* */
public class KMPAlgorithm {

    public KMPAlgorithm(){

    }

    public boolean findString(String s, String pattern) {

        return true;
    }


    public int[] buildTable(String pattern) {
        // failTable[i] records largest prefix/suffix length at index i of the pattern p.
        int[] failTable = new int[pattern.length()];

        // x is the PREVIOUS length of the largest prefix, also a suffix so far
        int x = 0;
        for(int p = 1; p < pattern.length(); p++) {
            // when x > 0, meaning x has been incremented, so pattern.charAt(x) is the next character
            // AND for-loop, i is incremented already
            // so if charAt(i) != charAt(x)
            // longest prefix, also a suffix is
            while( x > 0 && pattern.charAt(p) != pattern.charAt(x)) {
                // update the x's length to be failTable[x-1]
                /*
                * 原因
                * pattern:
                *           [A, B, A, D, ... A,  B,  A,  B]
                * p indices: 0, 1, 2, 3, ... 9, 10, 11, 12
                * failTable: 0, 0, 1, 0, ... 1,  2, 3, now compute value @ index of 12
                *
                * 首先 x = 3, so x >0 && charAt(x) != charAt(p) // p = 12, x = 3
                * 为什么update x = failTable[x-1]????
                *
                *
                * 因为 x 是prefix， suffix的最大的值 考虑 在x >= 1  的情况 (当p=12的时候, x = 3)
                *
                *  1. p[x-1]的 character 一定等于 pattern[index - 1]的character 因为x= 3， 所以在不加index = 12的char之前
                *     最大的prefix 并且是 suffix的string的length 是3， string是"ABA...ABA" // pattern[0,2] 和 pattern[9,11]
                 *
                *  2. let x_update = x - 1 = 2; 那么 在failTable里面 如果 failTable[x_update] > 0, 在这里是 failTable【x-1】 = 1
                 *    那么 意味着  在 pattern[0,2]的substring中 最大的prefix和suffix的length = 1！！！
                 *    IMPORTANT!!!!!!!! ---> pattern[0,2] == pattern [9,11] （第一步的逻辑）
                 *                           所以 pattern[9,11] 最大的prefix和suffix也必须等于1
                 *
                *  3. 那么记住   x_update代表的含义为 能map的定义
                *                   - 在pattern[0,2]最大的prefix suffix 的length
                *                   - 给了pattern p 所需要对比的下一个字节！！！！！！！！！！
                *                       因为 x_update个character 已经相同了 （1 个字节相同）
                *                       但是 第 x_update 个character （1st character of pattern p!!!） 还不知道
                *                   - 所以 pattern【x_update】 应该与现在的 pattern[p] 对比
                *
                *   4. 如果不同， 再回第一步！！一直到x_update = 0 就会从while-loop出来
                *   5. 相同： 就会进去 if statement
                * */
                x = failTable[x-1];
            }

            // when x > 0, meaning x has been incremented, so pattern.charAt(x) is the next character
            // AND for-loop, i is incremented already
            if (pattern.charAt(p) == pattern.charAt(x)) {
                x++;
            }

            //把这个值存入failTable
            failTable[p] = x;
        }

        return failTable;

    }
}
