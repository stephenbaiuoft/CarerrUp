package Amazon;
//http://www.geeksforgeeks.org/trapping-rain-water/


// Idea: Per Index!!!! u care about the lower limit from the left and from the right
//  so height[left] <= height[right]: meaning if right has higher, then the lower limit must come from indices to the left as compared to right index!!!!
/**
 *
 *
 *
 TrappingRainWater_42_H program = new TrappingRainWater_42_H();
 int[] height = {
 0,1,0,2,1,0,1,3,2,1,2,1
 };

 System.out.println(program.trap(height));
 *
 */

public class TrappingRainWater_42_H {

    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        int trappedSum = 0;

        while(left < right){
            if (height[left] <= height[right] ){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }
                else{
                    trappedSum += leftMax - height[left];
                }
                left ++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else{
                    trappedSum += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedSum;
    }


}

/*
* // Solution TOOOOOO SLOW!!!
*     public int trap(int[] height) {
        int maxHeight = 0;
        int previousIndex = -1;
        int trappedSum = 0;

        for (int i = 0; i < height.length; i++){
            // get maxHeight
            maxHeight = Integer.max(maxHeight, height[i]);
            // first initial case
            if(height[i] > 0 ) {
                if (previousIndex == -1 ) {
                    previousIndex = i;
                } else {
                    //if(  previousIndex > -1 ) {
                        trappedSum += i - previousIndex - 1;
                        previousIndex = i;
                    //}
                }
            }

        }

        for(int level = 1; level < maxHeight; level ++){
            int previousIndexTmp = -1;
            trappedSum += getTrappedLevel(level, height, previousIndexTmp);
        }

        return trappedSum;
    }

    // level: >0 until > maxHeight - 1 ==> maxHeight # of levels
    // get trapped water at each level
    private int getTrappedLevel(int level, int[] height, int previousIndex) {
        int trappedSum = 0;
        for(int i = 0; i < height.length; i ++) {
            if(height[i] > level ) {
                if (previousIndex == -1 ) {
                    previousIndex = i;
                } else {
                    //if(  previousIndex > -1 ) {
                        trappedSum += i - previousIndex - 1;
                        previousIndex = i;
                    //}
                }
            }
        }
        return trappedSum;
    }
*
*
*
* */