package _recall_75_questions;

public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = amount+1;
        }

        for(int a = 1; a <= amount; a++) {
            for(int indexOfCoin = 0; indexOfCoin < coins.length; indexOfCoin++) {
                if(coins[indexOfCoin] == a) {
                    dp[a] = 1;
                    break;
                }
                if(a - coins[indexOfCoin] > 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coins[indexOfCoin]]);
                }
            }
        }
        if(dp[amount] >= amount+1) {
            return -1;
        }
        return dp[amount];
    }
}