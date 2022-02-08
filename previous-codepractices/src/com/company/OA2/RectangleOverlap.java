package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class RectangleOverlap {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // if minimum of TOP is less than max of Bottom, that means they cannot overlap
        long oY = Math.max(0, ((long) Math.min(D,H) - Math.max(B,F)));
        long oX = Math.max(0, ((long)Math.min(C,G) - Math.max(A,E)));

        long overLap = (long) oY*oX;
        long sumArea = (C-A)*(D-B) + (G-E)*(H-F);

        long result = (long)(sumArea - overLap);
        return  (int) result;
    }

    /*
    *
    * // another using long,, max - min still or min - max ... can exceed int for sure!!!
// A,B bottom left   ***	C,D  top right  	||||||||    bottom left E,F  ***   top right G,H
public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	// if minimum of TOP is less than max of Bottom, that means they cannot overlap

	long oY = Math.min( 0, (long)Math.max(B,F) - Math.min(D,H));
	long oX = Math.min(0, (long)Math.max(A,E) - Math.min(C,G));


	long overLap = (long) oY*oX;
	long sumArea = (C-A)*(D-B) + (G-E)*(H-F);

	int result = (long)(sumArea - overLap);

}
    *
    * */
}
