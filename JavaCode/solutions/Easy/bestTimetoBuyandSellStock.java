public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        // Track min value so far
        int minSofar = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minSofar){
                minSofar = prices[i]; // update min so far
            } else {
                // update max profit
                maxProfit = Math.max(prices[i] - minSofar, maxProfit);
            }
        }
        return maxProfit;
    }
}