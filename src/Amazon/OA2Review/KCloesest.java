package Amazon.OA2Review;

import java.util.*;
public class KCloesest {

    public void run(){
        int count = 20;
        int i = 0;
        Point[] input = new Point[count];
        while( i < count) {
            double x = Math.random()* 10;
            double y = Math.random()* 10;
            input[i] = new Point(x, y);


            System.out.println("added distance of" + getDistance(input[i]));
            i++;
        }
        System.out.println("Sorting NOWWWWWWWWW\n\n\n\n\n\n\n");

        closestPoint(input, new Point(0,0), 5);
    }

    class Point
    {
        double  x;
        double y;
        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
    }

    class MComparator implements Comparator<Point>{
        private double getDistance(Point a) {
            double l2 = (a.x)*(a.x) + (a.y)*(a.y);
            return l2 ;
        }

        public int compare(Point a, Point b) {
            // ascending order ==> smallest at the beginning
            if( getDistance(a) >= getDistance(b))
                return 1;
            return -1;
            }
    }

    //PriorityQueue <Point> queue = new PriorityQueue<>(new MComparator());
     PriorityQueue <Point> queue = new PriorityQueue<>(new Comparator<Point>(){
         @Override
         public int compare(Point a, Point b){
           // some test for now... Just need to remeber the syntax
           return 0;
         }
     });


    public double getDistance(Point a) {
        double l2 = (a.x)*(a.x) + (a.y)*(a.y);
        return l2;
    }

    // assuming origin is 0, 0
    public Point[] closestPoint(Point[] array, final Point origin, int k)
    {
        Point[] result= new Point[k];

        Arrays.sort(array, new MComparator());
        for(int i = 0 ; i < k; i++) {
            result[i] = array[i];
            System.out.println( "i is "  + i + " " + getDistance(array[i]) );
        }

        return result;

    }
}
