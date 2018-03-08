public class Solution {
    // Let dp[i] to be the max production value for breaking the number i.
    // Since dp[i+j] can be i*j, 
    //  dp[i+j] = max(max(dp[i], i) * max(dp[j], j)), dp[i+j]).
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < i+1; j++){
                if(i + j > n)
                    continue;
                dp[i+j] = Math.max(Math.max(dp[i],i) * 
                                Math.max(dp[j],j), dp[i+j]);
            }
        }
        return dp[n];
    }
}