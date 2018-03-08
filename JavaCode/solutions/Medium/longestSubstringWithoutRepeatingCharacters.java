public class Solution {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Create a pointer to track the end of the substring
     * Create a pointer to track the start of the substring
     * Create a map for char to its latest index
     * Set both start and end pointer to the first char
     * while end is not the end of the s
     *  if(map have end char)
     *      update start pointer
     *  update max length
     *  put the index into the map for the char     *
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();
        int startInd = 0;
        int endInd = 0;
        int maxLen = 0;
        Map<Character, Integer> charToIndMap = new HashMap<>();

        while(endInd < s.length()){
            char c = s.charAt(endInd);
            if(charToIndMap.containsKey(c)){
                startInd = (charToIndMap.get(c) + 1) > startInd ?
                        (charToIndMap.get(c) + 1) : startInd;
            }
            maxLen = Math.max(maxLen, endInd - startInd + 1);
            charToIndMap.put(c, endInd++);
        }
        return maxLen;
    }
}