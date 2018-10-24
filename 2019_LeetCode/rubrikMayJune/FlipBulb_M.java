package rubrikMayJune;

public class FlipBulb_M {
    /**
     Design a controller for an array of N lightbulbs

     o x o o x x ... o
     0 1 2 3 4 5     N-1

     o = off
     x = on

     All lights start off

     1. flip(low, high): flips the state of all lights with indices low to high, inclusive
     flip(2, 5)
     flip(1, 3)

     2. is_on(index): return true if the light at index is on, false otherwise
     is_on(3) -> false
     is_on(4) -> true

     use case 1:
     flip calls >> isOn calls
     flip ranges are random

     flip(4, 7)  ..... flip(4, 7)


     flip(4, 7) = flip(0, 7) + flip(0, 3)
     flip(5, 8) = flip(0, 8) + flip(0, 4)





     */

    class Controller {
        private boolean[] bulbSet = null;
        // n
        public Controller(int n) {
            bulbSet = new boolean[n];

        }

        // low: starting index
        // high: the ending index
        public void flip(int low, int high) {
            if(low < 0) low = 0;
            if(high >= bulbSet.length) high = bulbSet.length - 1;


            if ( low > 0) {
                bulbSet[low-1] = !bulbSet[low-1] ;
            }

            bulbSet[high]  = !bulbSet[high] ;

        }

        // this check whether index at bulbSet is on or off
        public boolean isOn(int index) {
            int count = 0;
            for (int i = index; i < bulbSet.length; i++) {
                if(bulbSet[i]){
                    count ++;
                }
            }
            // odd is on
            return count%2 == 1;
        }

    }
}
