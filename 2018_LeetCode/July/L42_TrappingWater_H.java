package July;

public class L42_TrappingWater_H {
    public int trap(int[] height) {
        if(height == null || height.length < 1) return 0;
        int sum = 0;
        int left = 0, right = height.length - 1, lMax = 0, rMax = 0;

        while(left < right) {
            if (height[left] <= height[right]) {
                lMax = Math.max(height[left], lMax);
                sum += lMax - height[left];
                left++;
            } else {
                rMax = Math.max(height[right], rMax);
                sum += rMax - height[right];
                right --;
            }
        }

        return sum;
    }
}
