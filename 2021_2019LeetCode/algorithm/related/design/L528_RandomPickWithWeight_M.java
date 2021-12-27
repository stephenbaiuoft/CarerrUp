package algorithm.related.design;

import java.util.Random;

public class L528_RandomPickWithWeight_M {
    public L528_RandomPickWithWeight_M() {
        int[] w = new int[] {
                3, 14, 1, 7
        };

        init(w);
        for (int i = 0; i < 10; i++) {
            System.out.println(pickIndex());
        }
    }

    public void init(int[] w) {
        // [0, all_added_sum]
        mapW = new int[w.length];
        // get the proportion and store to mapW
        for(int i = 0; i < w.length; i++) {
            mapW[i] = sum;
            sum += w[i];
        }
    }

    private Random randGen = new Random();
    private int[] mapW = null;
    private int sum = 0;

    /*
    * 解体思路
    *
    * bst的问题 零界点
    * 所以你会发现 left的index 代表的是2种情况
    *
    *
    * */
    public int pickIndex() {
        // a value between 0 and sum(exclusive)
        int val = randGen.nextInt(sum);

        // binary search with lower bound
        int left = 0;
        int right = mapW.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if (val > mapW[mid]) {
                left = mid+1;
            } else { // val <= mapW[mid]
                right = mid;
            }
        }

        //在这里的情况 考虑 val和mapW【left】对比 需要考虑3中情况 等于，小于， 和大于
        //因为while-loop出来了
        //1. mapW[left] <= val 那么就是left就对了 在mapW的分布中
        if (mapW[left] <= val) {
            return left;
        } else {
        //2. mapW[left] > val 那么就是left-1
            return left - 1;
        }
    }

// 另外一种bst的方法 但是因为 left ！= right-1 所以要check这个逻辑
    public int pickIndexSecondBST() {
        // a value between 0 and sum(exclusive)
        int val = randGen.nextInt(sum);

        // binary search with lower bound
        int left = 0;
        int right = mapW.length - 1;
        while(left < right && left != right - 1) {
            int mid = left + (right - left)/2;
            if (mapW[mid] <= val) {
                left = mid;
            } else { // mapW[mid] >= val
                right = mid - 1;
            }
        }

        if (mapW[right] <= val) {
            return right;
        }
        return left;
    }
}
