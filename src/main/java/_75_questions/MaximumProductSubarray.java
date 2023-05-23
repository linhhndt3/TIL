package _75_questions;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndHere = nums[0];
        int minEndHere = nums[0];


        for(int i = 1; i < nums.length;i++) {
            int tempMax = maxEndHere;
            int tempMin = minEndHere;

            maxEndHere = findMax(tempMax * nums[i], tempMin * nums[i], nums[i]);
            minEndHere = findMin(tempMax * nums[i], tempMin * nums[i], nums[i]);

            maxSoFar = Math.max(maxSoFar,maxEndHere);
        }

        return maxSoFar;
    }

    int findMax(int a, int b, int c) {
        int maxOfab = Math.max(a, b);
        return Math.max(maxOfab, c);
    }

    int findMin(int a, int b, int c) {
        int minOfab = Math.min(a, b);
        return Math.min(minOfab, c);
    }
}