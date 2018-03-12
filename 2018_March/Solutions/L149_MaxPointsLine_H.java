package Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class L149_MaxPointsLine_H {
    public void arrayTest() {
        int[] s1 = new int[]{1,2};
        int[] s2 = new int[]{1,2};
        // eql: false
        boolean eql = s1.equals(s2);
        // eql2: true
        boolean eql2 = Arrays.equals(s1, s2);
        HashSet<int[]> set = new HashSet<>();
        set.add(s1);
        // b1 false
        boolean b1 = set.contains(s2);
        // b2 true
        boolean b2 = set.contains(s1);

        System.out.print(s1.toString() + s2.toString());
    }


    class Point {
       int x;
       int y;
       Point() { x = 0; y = 0; }
       Point(int a, int b) { x = a; y = b; }
    }

    public L149_MaxPointsLine_H() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1, 65536);
        Point p3 = new Point(65536,0);

        Point[] t = new Point[] {p1, p2, p3};
        maxPoints(t);
    }

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {return 0;}

        int maxNum = 1;
        // map is to keep track of slope count
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            //clear out map entries
            map.clear();
            // default points by itself
            int duplicateCount = 1;
            String curSlope = null;
            int curCount = 0;
            int lineMax = 0;
            for(int j = i+1; j < points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicateCount++;
                } else {
                    curSlope = getSlope(points[i], points[j]);
                    // the value of curSlope
                    if (map.containsKey(curSlope)) {
                        curCount = map.get(curSlope) + 1;
                        map.put(curSlope, curCount);
                    } else {
                        map.put(curSlope, 1);
                        curCount = 1;
                    }
                }
                lineMax = Math.max(lineMax, curCount );
            }

            maxNum = Math.max(maxNum, lineMax + duplicateCount);
        }

        return maxNum;
    }

    // get the slope between a & b(string representation)
    private String getSlope(Point p1, Point p2) {
        int dy = p1.y - p2.y;
        int dx = p1.x - p2.x;
        StringBuilder sb = new StringBuilder();

        // default cases
        if(dy == 0) {
            return sb.append(0).append("_").append(p1.x).toString();
        }
        if(dx == 0) {
            return sb.append(p1.y).append("_").append(0).toString();
        }

        int d = gcd(dx, dy);
        // store the points to preserve accuracy
        return sb.append(dy/d).append("_").append(dx/d).toString();

    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        else {
            // recursion
            return gcd(b, a%b);
        }
    }
}
