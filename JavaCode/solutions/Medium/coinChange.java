public class Solution {
    /****************
     * 
     * Let dp[v] to be the minimum number of coins required to get the amount v. 
     * dp[i+a_coin] = min(dp[i+a_coin], dp[i]+1) if dp[i] is reachable. 
     * dp[i+a_coin] = dp[i+a_coin] is dp[i] is not reachable. 
     * We initially set dp[i] to be MAX_VALUE.
     * 
     *************/
     
     public int coinChange(int[] coins, int amount) {
         if(amount==0) return 0;
 
        int[] dp = new int [amount+1];
        dp[0]=0; // do not need any coin to get 0 amount
        for(int i=1;i<=amount; i++)
            dp[i]= Integer.MAX_VALUE;
 
        for(int i=0; i<=amount; i++){
            for(int coin: coins){
            if(i+coin >= 0 && i+coin <=amount && dp[i]!=Integer.MAX_VALUE){
                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}