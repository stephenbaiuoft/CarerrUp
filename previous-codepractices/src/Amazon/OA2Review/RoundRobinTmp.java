package Amazon.OA2Review;

import java.util.*;

public class RoundRobinTmp {

    public void test() {
        int[] A = {
                0, 1, 3, 9
        };
        int[] D = {
                2, 1, 7 ,5
        };

        double wait = roundRobin(A, D, 2);
        System.out.println("wait time is: " + wait);
    }

    class Task {
        public int startTime;
        public int duration;
        public Task(int a, int b) {
            startTime = a;
            duration = b;
        }
    }

    public double roundRobin(int[] arriveTime, int[] runTime, int p)
    {
        if (arriveTime == null || runTime == null  || p == 0){
            return 0;
        }

        Queue<Task> queue = new LinkedList<>();
        int index = 0;
        double waitTime = 0;
        int curTime = 0;

        while( index < arriveTime.length || !queue.isEmpty()) {
            if(!queue.isEmpty()) {
                Task cur = queue.poll();
                waitTime += curTime - cur.startTime;
                curTime += Math.min(p, cur.duration);
                // skim through and add the tasks that have arrived during
                for(; index < arriveTime.length; index++) {
                    if(arriveTime[index] <= curTime) {
                        queue.add(new Task(arriveTime[index], runTime[index]));
                    } else {
                        // stop otherwise
                        break;
                    }
                }
                // this task is not complete yet
                if(cur.duration > p) {
                    // re-create this class
                    queue.add(new Task(curTime, cur.duration - p));
                }

            }
            // put into the queue
            else {

                queue.add(new Task(arriveTime[index], runTime[index]));
                curTime = arriveTime[index];
                // advance index
                index ++;
            }
        }
        return ( waitTime );
    }
}
