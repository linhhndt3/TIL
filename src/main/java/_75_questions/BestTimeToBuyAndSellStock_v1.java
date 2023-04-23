package _75_questions;

public class BestTimeToBuyAndSellStock_v1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(prices[i]<=minPrice){
                minPrice=prices[i];
            } else {
                maxProfit = (prices[i]-minPrice) > maxProfit ? (prices[i]-minPrice) : maxProfit;
            }
        }
        return maxProfit;
    }
}