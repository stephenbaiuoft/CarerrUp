import java.util.*;

public class TestSpace {
    // testing Java signatures and etc.
    public void test() {
        double[][] r = new double[1][2];
        r[0] = new double[] {0.0, 90.0};
        double rez = run(r, 600);
        System.out.println(rez);
    }

    public double run(double[][] readings, long endTime) {
        // Type your solution here
        Arrays.sort(readings);

        double curTime = 0.0;
        double dis = 0;
        int index = 1;

        double timeMark = 0.0;
        double prevSpeed = readings[0][1];
        while (curTime < endTime && index < readings.length ) {
            timeMark = readings[index][0];

            if (curTime <= timeMark) {
                prevSpeed = readings[index-1][1];

                dis = dis + prevSpeed * (timeMark - curTime);
                curTime = timeMark;
                // update index value to find the next timeMark
                index ++;
            }
        }

        if (curTime < endTime) { // index updated until out of boundary
            prevSpeed = readings[readings.length-1][1];
            dis = dis + prevSpeed * (endTime - curTime);
        } else { // curTime > endTime,  compensate for the extra added dist
            dis = dis - prevSpeed * (curTime - endTime);
        }

        return dis;
    }

    // hour to seconds


}
