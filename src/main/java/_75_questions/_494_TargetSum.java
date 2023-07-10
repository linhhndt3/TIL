package _75_questions;

import java.util.*;

public class _494_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        min = Math.min(target-nums[0], nums[0]+target);
        max = Math.max(target-nums[0], nums[0]+target);
        queue.add(target-nums[0]);
        queue.add(nums[0]+target);
        for(int i = 1; i < nums.length; i++) {
            Queue<Integer> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int newTarget = queue.poll();
                min = Math.min(min,Math.min(newTarget-nums[i], nums[i]+newTarget));
                max = Math.max(max,Math.max(newTarget-nums[i], nums[i]+newTarget));

                tempQueue.add(newTarget-nums[i]);
                tempQueue.add(nums[i]+newTarget);
            }
            queue = tempQueue;
        }

        int[] targetsDp = new int[max-min+1];

        for(int i = 0 ; i < targetsDp.length; i++) {
            targetsDp[i] = min++;
        }

        int[][] dp = new int[nums.length][targetsDp.length];

        for(int i = 0; i < dp[0].length; i++) {
            if(nums[nums.length - 1] == targetsDp[i] || nums[nums.length - 1] == -1*targetsDp[i]) {
                dp[nums.length-1][i] = 1;
            } else {
                dp[nums.length-1][i] = 0;
            }
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = 0; j < targetsDp.length; j++) {
                if(targetsDp[j]-nums[i] >= 0 && targetsDp[j]-nums[i] < dp[0].length) {
                    dp[i][j] += dp[i+1][targetsDp[j]-nums[i]];
                }
                if(targetsDp[j]+nums[i] >= 0 && targetsDp[j]+nums[i] < dp[0].length) {
                    dp[i][j] += dp[i+1][targetsDp[j]+nums[i]];
                }
            }
        }

        return dp[1][target-nums[0]] + dp[1][target+nums[0]];

    }

    public static void main(String[] args) {
        System.out.println(new _494_TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}