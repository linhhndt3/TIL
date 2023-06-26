package _recall_75_questions;

public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = 0;

        for(int index = nums.length - 2; index >= 0; index--) {
            for(int pointer = index + 1; pointer < nums.length;pointer++) {
                if(nums[index] < nums[pointer]) {
                    dp[index] = dp[index] > (1 + dp[pointer]) ? dp[index] : (1 + dp[pointer]);
                    max = Math.max(max,dp[index]);
                }
            }
        }

        return max;
    }
}