package _75_questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange_v1 {

    public static void main(String[] args) {
        new CoinChange_v1().coinChange(new int[]{1,2,5},11);
//        new CoinChange_v1().coinChange(new int[]{2},3);
//        new CoinChange_v1().coinChange(new int[]{1},0);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }
        int[] rs = new int[amount+1];
        Arrays.fill(rs, amount+1); // TODO why we fill it with amount + 1
        rs[0] = 0;
        for(int a=1; a <= amount;a++) {
            for(int i = 0; i < coins.length; i++) {
                if(a-coins[i] >= 0) {
                    rs[a] = Math.min(rs[a],1 + rs[a-coins[i]]);
                }
            }


        }
        return rs[amount] == (amount + 1) ? -1 : rs[amount];
    }
}