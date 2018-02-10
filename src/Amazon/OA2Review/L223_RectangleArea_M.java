package Amazon.OA2Review;

/**
 * First Rectangle
 * (A,B) lower left
 * (C,D) top right
 *
 * Second Rectangle
 * (D,F) lower left
 * (G,H) top right
 */

public class L223_RectangleArea_M {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        /**
         *  A   B  C  D
         * -2, -2, 2, 2
         *
         *  E   F  G  H
         * -2, -2, 2, 2
         */

        int rect1 = (A - C) * (B - D);
        int rect2 = (E - G) * (F - H);

        int overlap = 0;

        int left = Math.max(A, E);
        int bot = Math.max(B, F);
        int right = Math.min(C,G);
        int top = Math.min(D, H);

        // over-lap
        if(top > bot && right > left) {
            overlap = (top - bot) *(right - left);
        }

        return rect1 + rect2 - overlap;

    }
}
