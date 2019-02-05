package custom_data_structure;

import java.util.Map;
import java.util.TreeMap;

/*
Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.

Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end),
 the range of real numbers x such that start <= x < end.

A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true
Explanation:
The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
*
* */

// 思路： 当你存一个continuous array的时候
//
public class MyCalendarTwo {
    // (startTime, count)
    // (endTime, count)

    // use +1 and -1 to indicate whether you may have any > 1 occurences when you
    // iterate through the set
    private TreeMap<Integer, Integer> delta = null;

    public MyCalendarTwo() {
        delta = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        // 2 intervals can't be triple booked
        if (delta.size() < 3) return true;
        int overLapCount = 0;
        for (Map.Entry<Integer, Integer> entry: delta.entrySet()) {
            overLapCount += entry.getValue();
            if (overLapCount >= 3) {
                // restore back start and end points to their last state
                // could be 0, which won't affect anything
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                return false;
            }
        }

        return true;
    }


    public void MyCalendarTwoTry() {

        compareHelper(42,50);
        compareHelper(33,41);
        compareHelper(38,43);
        compareHelper(49,50);
        compareHelper(35,42);
        compareHelper(46,50);
        compareHelper(39,44);
        compareHelper(41,49);

    }

    private void compareHelper(int start, int end) {
        start -= 33;
        end -= 33;

        boolean correct = book(start, end);
        boolean t = bookTest(start,end);
        System.out.println("correct is:" + correct + "\tt is:" + t +
        "\tstart is: " + start + ", end is: " + end);

    }

    // key-value pair is -> (endTime, startTime)
    TreeMap<Integer, Integer> b1 = new TreeMap<>();
    TreeMap<Integer, Integer> b2 = new TreeMap<>();

    // 不工作 有bug 不确定为啥
    public boolean bookTest(int start, int end) {
        if (!canInsert(b2, start, end)) {
            return false;
        }
        // insert it of course
        insert(b1, b2, start, end);

        return true;
    }

    // insert start, end into the map, provided of course b2 currently does not has
    private void insert(TreeMap<Integer, Integer> b1,
                           TreeMap<Integer, Integer> b2,
                           int start, int end) {

        // strictly endTime > start, cannot be equal!!!!
        Map.Entry<Integer, Integer> endGreaterThanStart = b1.higherEntry(start);

        // there is a conflict and put to b2, and b2 doesn't have this interval because of our check
        if (endGreaterThanStart!= null &&
                endGreaterThanStart.getValue() < end) {
             int sNew = Math.max(endGreaterThanStart.getValue(), start);
             int eNew = Math.min(endGreaterThanStart.getKey(), end);
             //
             b2.put(eNew, sNew);
        }

        // update b1 of course
        b1.put(end, start);
    }

    private boolean canInsert(TreeMap<Integer, Integer> b,
                           int start, int end) {
        // strictly endTime > start, cannot be equal!!!!
        Map.Entry<Integer, Integer> endGreaterThanStart = b.higherEntry(start);

        // there is a conflict now
        if (endGreaterThanStart!= null &&
                endGreaterThanStart.getValue() <= end) {
            return false;
        }
        // you can insert start && end
        return true;
    }
}

