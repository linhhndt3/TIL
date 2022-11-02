package twopointer;

public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        // TODO recall
        int max = Integer.MIN_VALUE, l = 0, r = height.length - 1;
        while(l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
