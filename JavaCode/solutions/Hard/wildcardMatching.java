public class Solution {
    // DP solution
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length()+1];
        dp[0][0] = true;

        int j = 1;
        while(j <= p.length() && p.charAt(j-1)=='*')
            dp[0][j++] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1)!='*') {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?');
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    // Two pointer solution
    public boolean isMatch(String s, String p) {
        public boolean isMatch(String str, String pattern) {
            int s = 0, p = 0, match = 0, starIdx = -1;
            while (s < str.length()){
                // advancing both pointers
                if (p < pattern.length()  &&
                        (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                    s++;
                    p++;
                } else if (p < pattern.length() && pattern.charAt(p) == '*'){
                    // * found, only advancing pattern pointer
                    starIdx = p;
                    match = s;
                    p++;
                } else if (starIdx != -1){
                    // set pattern pointer to after * and advance string pointer
                    p = starIdx + 1;
                    match++;
                    s = match;
                } else {
                    return false;
                }
            }

            //check for remaining characters in pattern
            while (p < pattern.length() && pattern.charAt(p) == '*')
                p++;

            return p == pattern.length();
        }
    }
}