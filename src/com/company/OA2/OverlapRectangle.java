package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-17.
 */
public class OverlapRectangle {
    public OverlapRectangle(){

       System.out.println( computeArea(-2,
                       -2,
               2,
               2,
               1,
               -3,
               3,
               -1));
    }

    // strictly no overlap
    // cases when definitely no overlap
    public static boolean check(Node topLeftA, Node topLeftB,
                                Node bottomRightA, Node bottomRightB) {
        // x is apart in worst case
        if( bottomRightA.x < topLeftB.x || bottomRightB.x < topLeftA.x){
            return false;
        }
        // y is off in worst case... furthest down vs further top
        else if( bottomRightA.y > topLeftB.y || bottomRightB.y > topLeftA.y){
            return false;
        }

        return true;
    }

    public static class Node {
        double x;
        double y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    //Bottom Left(A,B), Top Right(C,D)
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // A to G's right or E to C's right to avoid X
        // Similarly B(bottom!!!) >= H or F>= D
        if ( (A >= G ) ||(E >= C) ||( B>=H ) ||(F >= D) ){
            return (C-A)*(D-B) + (G-E)*(H-F);
        }else{
            //prevents points
            if ((A==C)||(B==D)||(E==G)||(F==H)){
                return (A-C)*(B-D) + (E-G)*(F-H) ;
            }
            // prevents inner within a larger rectangle

            int maxLx = A - E > 0 ? A: E;
            int maxLy = Math.max(B, F);
            int minLx = Math.min(C,G);
            int minLy = Math.min(D, H);

            // check if inner rectangle
            if ( ((E-A) >=0 && (C-G)>=0) && ((F-B)>=0) && ((D-H) >=0)||
                    ( ((A-E)>=0)&& ((G-C)>=0 )&& ((B-F)>=0)&&((H-D)>=0)   )
                    ){

                return (C-A)*(D-B) - (G-E)*(H-F) >=0 ? (C-A)*(D-B):  (G-E)*(H-F);
            }
            int delta =(maxLx - minLx)*(maxLy - minLy);

            return (C-A)*(D-B) + (G-E)*(H-F) - delta;
        }

    }
}
