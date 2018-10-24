package ByMonth.august.april;

import java.util.LinkedList;
import java.util.List;

public class L57_InsertInterval_H {
/*
* 重点还是 分段  记得第二个while loop 之后的要素还是很重要的
* */
    public L57_InsertInterval_H() {
        LinkedList<Interval> l = new LinkedList<>();
        Interval a = new Interval(1,3);
        Interval b = new Interval(6,9 );
        Interval c = new Interval(2,5);
        l.add(a);
        l.add(b);

        List<Interval> result = insert(l, c);

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        // create an linkedlist to store those intervals first
        LinkedList<Interval> list = new LinkedList<>();
        int iStart = newInterval.start;
        int iEnd = newInterval.end;

        // to loop through intervals
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < iStart) {
            list.add(intervals.get(i));
            i++;
        }

        // here i'th index, intervals.get(i).end >= iStart
        // so the merging of the intervals
        while(i < intervals.size() && intervals.get(i).start <= iEnd) {
            iStart = Math.min(intervals.get(i).start, iStart);
            iEnd = Math.max(intervals.get(i).end, iEnd);
            i++;
        }
        // add the merged interval
        list.add(new Interval(iStart, iEnd));

        while(i < intervals.size()) {
        }
        return list;

    }

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}
