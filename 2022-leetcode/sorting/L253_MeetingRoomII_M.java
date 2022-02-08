package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class L253_MeetingRoomII_M {
    class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

    class Solution {
        public int minMeetingRooms(Interval[] intervals) {
            Arrays.sort(intervals, ((Interval a, Interval b) -> a.start == b.start? a.end - b.end: a.start - b.start));

            Queue<Integer> q = new PriorityQueue<>();
            for (Interval interval: intervals) {
                if (q.isEmpty()) {
                    // add the ending time
                    q.add(interval.end);
                } else {
                    // startTime is less than q's haed (smallest value)
                    // must create a new one
                    if (interval.start < q.peek()) {
                        q.add(interval.end);
                    } else {
                        q.poll();
                        q.add(interval.end); // use the latest one
                    }
                }
            }

            return q.size();
        }
    }
}
