package _75_questions;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // TODO proof it - why we choose the next pointer base on whetber height of l and r
        int maxArea = -1;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxArea = maxArea > Math.min(height[l],height[r]) * (r-l) ? maxArea : Math.min(height[l],height[r]) * (r-l);
            if(height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}