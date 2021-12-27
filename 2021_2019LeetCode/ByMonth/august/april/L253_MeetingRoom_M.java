package ByMonth.august.april;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L253_MeetingRoom_M {

    public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
     }

    public int minMeetingRooms(Interval[] intervals) {

        Comparator<Interval> c = new Comparator<Interval>() {
            @Override
            public int compare(Interval e1, Interval e2) {
                // in ascending order
                return e1.start - e2.start;
            }
        };

        // sort the given interval in this specific order
        Arrays.sort(intervals, c);

        // priorityqueue storing the end time only
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Interval i: intervals) {
            if (queue.isEmpty()) {
                queue.add(i.end);
            }
            else if (queue.peek() <= i.start) {
                // get rid of the first and update i.end to the queue
                queue.poll();
                queue.add(i.end);
            } else {
                // case to add a new session
                queue.add(i.end);
            }
        }

        // return priority size
        return queue.size();

    }
}
