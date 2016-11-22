package com.company.november;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class kthNearestPoint {
    public kthNearestPoint(){
        // size of 10
        Point[] array = new Point[10];
        Point origin = new Point(0,0);
        int k = 3;

        for (int i =0; i< 10; i++){
            array[i] = new Point(i,i);
        }

        Solution(array, origin, k);
    }

    public void Solution(Point[] array, Point origin, int k) {
        Point[] rvalue = new Point[k];
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return (int) (getDistance(b, origin) - getDistance(a, origin));
            }
        });

        PriorityQueue<Point> pq2 = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return (int) (getDistance(b, origin) - getDistance(a, origin));
            }
        });



        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            pq2.offer(array[i]);

            if (pq.size() > k)
                pq.poll();
        }


        while (!pq.isEmpty()) {
            rvalue[index++] = pq.poll();
        }
        int i = 0;
        while (i <rvalue.length){
            System.out.print(rvalue[i].x +"\t");
            i++;
        }
        //System.out.println(Arrays.toString(rvalue));

    }

        public double getDistance(Point a, Point b){

            return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        }
    }


 class Point {
        double x;
        double y;
        public Point(double a, double b) {
            x = a;
            y = b;
        }
 }
