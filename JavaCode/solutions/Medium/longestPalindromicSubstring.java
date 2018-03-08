public class Solution {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     *
     * 1. Palindrome with center in the middle
     *  for each element scan both side until they are different
     * 2. Palindrome with center of two elements in the middle
     *  for every two elements scan both side until they are different
     *
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) { return s;}

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}