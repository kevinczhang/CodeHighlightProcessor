public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        if(s.length() == 1)
            return 1;

        int[] dp = new int[s.length()];
        dp[0] = 1;
        if(Integer.parseInt(s.substring(0,2)) > 26){
            dp[1] = s.charAt(1) != '0' ? 1 : 0;
        } else {
            dp[1] = s.charAt(1) != '0' ? 2 : 1;
        }

        for(int i = 2; i < s.length(); i++){
            if(s.charAt(i) != '0'){
                dp[i] += dp[i-1]; // way to decode without last digit
            }

            int val = Integer.parseInt(s.substring(i-1, i+1)); // the val form by last two digits
            if(val <= 26 && val >= 10){
                dp[i] += dp[i-2]; // way to decode without last two digits
            }
        }
        return dp[s.length()-1];
    }
}