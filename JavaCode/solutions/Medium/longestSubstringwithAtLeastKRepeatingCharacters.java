public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();

        int max = 0; // result
        // Try substrings with 1 to 26 unique chars
        for (int h = 1; h <= 26; h++) {
            int[] counts = new int[26];
            int i = 0; // slow pointer
            int j = 0; // fast pointer
            int unique = 0; // count of unique chars
            int noLessThanK = 0; // count of char more than K
            while (j < str.length) {
                // When uniqu chars count less than h
                // fast pointer advance
                if (unique <= h) {
                    int idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    int idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }

        return max;
    }
}