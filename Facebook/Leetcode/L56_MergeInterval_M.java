package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class L56_MergeInterval_M {
    public class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }
    public List<Interval> merge(List<Interval> intervals) {
        // quick sort list with classes
        intervals.sort((i1, i2) -> i1.start - i2.start);
        //intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List <Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval i: intervals) {
            // update end only
            if (i.start <= end) {
                end = Math.max(end, i.end);
            }
            // separate interval
            else {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }
}
