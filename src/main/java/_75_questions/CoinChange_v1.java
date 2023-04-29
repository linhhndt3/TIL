package _75_questions;

import java.util.HashSet;
import java.util.Set;

public class CoinChange_v1 {

    public static void main(String[] args) {
        new CoinChange_v1().coinChange(new int[]{1,2,5},11);
    }

    public int coinChange(int[] coins, int amount) {
        int[] rs = new int[amount+1];
        for(int i = 0; i < coins.length; i++) {
            rs[coins[i]] = 1;
        }

        rs[0] = 0;
        for(int a=1; a <= amount;a++) {
            if(rs[a] != 0) {
                rs[a] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int c = 0; c < coins.length;c ++) {
                int tempAmount = a - coins[c];
                if(tempAmount <= 0) {
                    continue;
                } else {
                    min = min >=  1 + rs[tempAmount] ? 1 + rs[tempAmount] : min;
                }
            }
            rs[a] = min;
        }
        return rs[amount];
    }
}