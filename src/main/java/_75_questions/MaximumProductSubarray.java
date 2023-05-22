package _75_questions;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length+1];
        int max = Integer.MIN_VALUE;
        dp[nums.length] = 1;
        for(int index = nums.length-1;index >= 0; index--) {
            int currentValue = nums[index];
            int lastMaxProduct = dp[index+1];
            if((currentValue > 0 && lastMaxProduct > 0) || (currentValue < 0 && lastMaxProduct < 0)) {
                dp[index] = currentValue * lastMaxProduct;
                max = max > dp[index] ? max : dp[index];
            } else if( (currentValue < 0 && lastMaxProduct > 0) || (currentValue > 0 &&  lastMaxProduct < 0)) {
                dp[index] = currentValue;
                max = max > dp[index] ? max : dp[index];
            } else if(currentValue == 0) {
                dp[index] = currentValue;
                max = max > dp[index] ? max : dp[index];
            } else if(lastMaxProduct == 0) {
                if(currentValue >= 0) {
                    dp[index] = currentValue;
                    max = max > dp[index] ? max : dp[index];
                } else {
                    dp[index] = 0;
                    max = max > dp[index] ? max : dp[index];
                }
            }
        }

        return max;
    }
}