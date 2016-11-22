package com.company.OA2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class KClostPoint {
    public KClostPoint(){
        Point[] p = new Point[10];
        for(int i =0; i<10;i++){
            p[i] = new Point(10-i, 10-i);
        }

        Point Origin = new Point(0,0);
        findKClosest( p, Origin, 3);
    }

    public Point[] findKClosest(Point[] p, Point Origin, int k) {
        if (p.length==0) return p;
        // construct a array of size k
        Point[] result = new Point[k];
        // sort the array and return?
        PriorityQueue<Point> mQueue = new PriorityQueue<Point>( new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // ascending order is o1 - o2, so smallest on first items
                // so Now IT IS Descending!!!!!!! with Max on Top
                 return (int ) (getDistance(o2, Origin) - getDistance(o1, Origin));
            }
        });

        for (int i = 0; i < p.length; i++){
            mQueue.offer(p[i]);
            if (i >= k){
                mQueue.poll();
            }
        }

        for(int i = 0; i< k; i++){
            result[i] = mQueue.poll();
            System.out.println(result[i].x);
        }
        //System.out.println(Arrays.toString(result));
        //result = (Point[]) mQueue.toArray();
        return result;
    }

    public double getDistance(Point input, Point Origin){
        return Math.sqrt (  ( ( input.x - Origin.x )*(input.x-Origin.x)
                            + (input.y - Origin.y)*(input.y - Origin.y))) ;
    }

    public class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
