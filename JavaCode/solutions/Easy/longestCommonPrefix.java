public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            // Check each char of first string
            int strsInd = 0;
            while (strsInd < strs.length && i < strs[strsInd].length() &&
                    strs[strsInd].charAt(i) == strs[0].charAt(i))
                strsInd++;
            // If all strings have the char
            if (strsInd == strs.length) {
                res.append(strs[0].charAt(i));
            } else
                return res.toString();
        }
        return strs[0];
    }
}