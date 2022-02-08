package heap_minqueue;

/*
* There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.



Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.

思路：
有一个order 根据ratio 然后 + minQueue 保证正确

1。 你选k个work， 一定是会有一个最大大的 ratio，我们叫captain 而其它所有的worker的ratio肯定比他小 greedy的算法的话
2。 好， 那我们就按照 ratio 从小到大来做一个 排序
3。 然后 相对于每一个 captain ratio， 它之前的所有的worker 的ratio一定比这个ratio小
    3.1 这时候就变成了 选 quality sum最小的整数
    3.2 然后sum 就会是 captain ratio * sum(k in the first m workers sorted in the m order)

4. correctness
    4.1 最重要的是 => 因为minque的是按照quality的 大小排序的 而当前的ratio确保了 就是说你不可能选到ratio之上面的worker optimal solution
    4.2 因为 我把每一个worker的ratio 都做一遍的

* */

import java.util.*;

public class L857_MinCostKWorkers_H {
    public L857_MinCostKWorkers_H() {
        int[] q = new int[] {
                10, 20, 5
        };
        int[] w = new int[] {
                70, 50, 30
        };

        double c = mincostToHireWorkers(q, w, 2);
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {

        // ranked ratio
        List<int[]> workerList = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            workerList.add(new int[] {
                    wage[i],
                    quality[i]
            });
        }


        Comparator<int[]> c1 = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare( (double) o1[0]/o1[1], (double)o2[0]/o2[1]);

//                if ( (double) o1[0]/o1[1] > ((double) o2[0])/o2[1]) {
//                    return 1;
//                }
//                return -1;
            }
        };
        // sort the workerSet
        Collections.sort(workerList, c1);

        // q is a minQueue,
        // but we need the smallest K elements so --> -K
        PriorityQueue<Integer> q = new PriorityQueue<>();
        // total sum of Quality so far
        int sumQ = 0;
        double minCost = Double.MAX_VALUE;
        // iterate through workerList set
        for (int[] worker: workerList) {
            sumQ += worker[1];
            q.add(worker[1] * -1);
            if (q.size() > K) {
                sumQ += q.poll();
            }
            if (q.size() == K) {
                double maxRatio = (double) worker[0]/worker[1];
                minCost = Math.min(minCost, maxRatio * sumQ);
            }
        }

        return minCost;
    }


}
