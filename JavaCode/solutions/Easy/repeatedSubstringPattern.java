public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //This is the kmp issue
        int[] prefix = getOverlay(s);
        int len = prefix[s.length() - 1];
        int n = s.length();
        return (len > 0 && n % (n - len) == 0);
    }

    // Generate the prefix function for pattern itself
    int[] getOverlay(String pattern) {
        int[] res = new int[pattern.length()];
        res[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            int index = res[i - 1];
            while (index > 0 && pattern.charAt(index) != pattern.charAt(i))
                index = res[index - 1];
            res[i] = (pattern.charAt(index) == pattern.charAt(i)) ? index + 1 : 0;
        }
        return res;
    }

}