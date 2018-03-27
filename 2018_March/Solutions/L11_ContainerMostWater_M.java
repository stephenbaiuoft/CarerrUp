package Solutions;

public class L11_ContainerMostWater_M {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;

        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            // always go with the smaller height
            // also we maximized the total width of the bucket!!!
            // note: this ensures that even in between left and right
            // there are smaller or higher heights, they will not
            // affect the size of this set
            int area = Math.min(height[left], height[right])* (right - left);
            maxWater = Math.max(maxWater, area);

            // now change index (always change the smaller height)
            // as --> smaller is the limiting factor
            if(height[left] < height[right]){
                left ++;
            } else {
                right --;
            }

        }

        return maxWater;
    }
}
