public class Solution {
    /***
     * Match[i][j]  =   (s3.lastChar == s1.lastChar) && Match[i-1][j] || (s3.lastChar == s2.lastChar) && Match[i][j-1]
     * Initial Condition：
     *    i=0 && j=0，Match[0][0] = true;
     *    i=0， s3[j] = s2[j], Match[0][j] |= Match[0][j-1]
     *           s3[j] != s2[j], Match[0][j] = false;
     *
     *   j=0， s3[i] = s1[i], Match[i][0] |= Match[i-1][0]
     *          s3[i] != s1[i], Match[i][0] = false;
     *******************/
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) return false;
        int[][] dptable = new int[l2 + 1][l1 + 1];
        // Initial condition 1
        dptable[0][0] = 1;
        // Initial condition 2
        for (int i = 1; i <= l1; i++) {
            if (dptable[0][i - 1] == 1 && s3.charAt(l3 - i) == s1.charAt(l1 - i))
                dptable[0][i] = 1;
            else
                dptable[0][i] = 0;
        }
        // Initial condition 3
        for (int i = 1; i <= l2; i++) {
            if (dptable[i - 1][0] == 1 && s3.charAt(l3 - i) == s2.charAt(l2 - i))
                dptable[i][0] = 1;
            else
                dptable[i][0] = 0;
        }

        for (int i = 1; i <= l2; i++)
            for (int j = 1; j <= l1; j++) {
                if (dptable[i - 1][j] == 0 && dptable[i][j - 1] == 0)
                    dptable[i][j] = 0;
                else if (dptable[i - 1][j] == 1) {
                    if (s3.charAt(l3 - i - j) == s2.charAt(l2 - i)) {
                        dptable[i][j] = 1;
                        continue;
                    }
                } else if (dptable[i][j - 1] == 1) {
                    if (s3.charAt(l3 - i - j) == s1.charAt(l1 - j)) {
                        dptable[i][j] = 1;
                        continue;
                    }
                } else
                    dptable[i][j] = 0;
            }

        return dptable[l2][l1] == 1 ? true : false;
    }
}