package _75_questions;

public class _494_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {

        int min = -1000;
        int max = 1000;
        int[] targetsDp = new int[max-min+1+1];
        int[][] dp = new int[nums.length+1][max-min+1+1];

        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = 0; j < targetsDp.length - 1; j--) {
                if(nums[i] == targetsDp[j] || nums[i] == -1 * targetsDp[j]) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - targetsDp[i]] + dp[i][j + targetsDp[i]];
                }
            }
        }

        return dp[0][target-targetsDp[0]] + dp[0][target+targetsDp[0]];
    }
}