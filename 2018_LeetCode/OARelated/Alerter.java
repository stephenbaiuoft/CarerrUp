package OARelated;

import java.util.ArrayDeque;

public class Alerter {
    public Alerter() {
        // 0, 1, 1
        int[] in1 = new int[]{
                100,100,100,100,100,100,100,100
        };
        boolean alert = monitor(in1, 2, 1.5);
        System.out.println("should alert? " + alert);

        in1 = new int[]{
                1, 1,1,1,200,200,1,1,1
        };
        alert = monitor(in1, 2, 1.5);
        System.out.println("should alert? " + alert);

        in1 = new int[]{
                1,2,100,2,2
        };

        alert = monitor(in1, 3, 1.5);
        System.out.println("should alert? " + alert);



    }

    ArrayDeque<Double> q = new ArrayDeque<>();
    // alert true if condition is met
    public boolean monitor(int[] input, int n, double threshold) {
        long sum = 0;
        double prev = 0;
        double cur = 0;

        for(int i = 0; i <= n - 1; i++) {
            sum += input[i];
            pushToQueue(input[i]);
        }

        prev = sum / n;
        if (prev * threshold < getWindowMax()) return true;

        for(int i = n; i < input.length; i++) {
            // update sum
            sum -= input[i-n];
            sum += input[i];

            // update queue
            updateQueue( (double) input[i-n]);
            pushToQueue( (double) input[i]);

            cur = sum / n;
            if (prev * threshold < cur || cur * threshold < getWindowMax()) {
                return true;
            }
            prev = cur;
        }

        return false;
    }

    // push to queue
    private void pushToQueue(double val) {
        while(!q.isEmpty() && q.peekLast() < val) {
            q.pollLast();
        }

        q.offerLast(val);
    }

    // remove from queue if necessary
    private void updateQueue(double val) {
        if (!q.isEmpty() && q.peekFirst() == val) {
            q.pollFirst();
        }
    }

    private double getWindowMax() {
        return q.peekFirst();
    }


}
