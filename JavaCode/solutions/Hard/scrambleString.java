public class Solution {
    /*************
     * memo[i][j][k] means state: for s1.substring(i, i + k) and s2.substring(j, j + k), if they are scramble string
     * Two conditions we can regard as scramble, for range of word1(i -> i+k) or word2(j -> j+k):
     * i -> i + split = j -> j + split (len = split) and split + i -> i + k = split + i -> j + k (len = k - split)
     * i -> i + split = j + (k - split) -> j+k [len = split] and i + split -> i+k = j -> j + (k - split)(len = k - split)
     * Consider about the initialization:
     * for k == 1, we only check if word1[i] == word2[j]
     ***********/
    public boolean isScramble(String s1, String s2) {
        // check length
        if(s1 == null || s2 == null || s1.length() != s2.length()) return false;
        // check anagram
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2))  return false;
        if(s1.length() != s2.length()) return false;

        int len = s1.length();
        // state: for s1.substring(i, i + k) and s2.substring(j, j + k), if they are scramble string
        boolean[][][] memo = new boolean[len][len][len+1];

        // initial, only check if s1[i] == s2[j]
        for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++)
                memo[i][j][1] = s1.charAt(i) == s2.charAt(j);

        for(int k = 2; k <= len; k++) {
            for(int i = 0; i <= len - k; i++) {
                for(int j = 0; j <= len - k; j++) {
                    // split point should start from 1 to k - 1
                    for(int split = 1; split < k; split++) {
                        memo[i][j][k] = memo[i][j][k] ||
                                (memo[i][j][split] && memo[i + split][j + split][k - split]) ||
                                (memo[i][j + (k - split)][split] && memo[i + split][j][k - split]);
                    }
                }
            }
        }
        return memo[0][0][len];
    }
}