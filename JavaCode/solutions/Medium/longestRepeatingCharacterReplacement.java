public class Solution {
    /**

     The problem says that we can make at most k changes to the string
     (any character can be replaced with any other character).
     So, let's say there were no constraints like the k.
     Given a string convert it to a string with all same characters with
     minimal changes. The answer to this is

     length of the entire string - number of times of the maximum occurring character in the string
     Given this, we can apply the at most k changes constraint and maintain a sliding window such that

     (length of substring - number of times of the maximum occurring character in the substring) <= k

     **/
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}