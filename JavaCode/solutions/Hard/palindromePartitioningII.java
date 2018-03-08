public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int cut[] = new int[n];

        for (int j = 0; j < n; j++) {
            cut[j] = j; //set maximum # of cut
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(j) || (j - i > 1 && !dp[i + 1][j - 1]))
                    continue;
                dp[i][j] = true;
                // if [0...j] is palindrome, no need to cut
                // else need to cut, add 1 to the previous cut[i-1]
                cut[j] = (i == 0) ? 0 : Math.min(cut[j], cut[i - 1] + 1);
            }
        }
        return cut[n - 1];
    }
}