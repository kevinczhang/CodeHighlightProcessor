public class Solution {
    public String shortestPalindrome(String s) {
        // Find out explaination on https://www.youtube.com/channel/UCMNkvKnD3mo3Jj9eTwJllWw
        String rev_s = new StringBuilder(s).reverse().toString();
        //use special character to avoid overlap
        String l = s + "#" + rev_s;

        int[] p = getOverlay(l);
        return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;
    }

    // Generate the prefix function for pattern itself
    int[] getOverlay(String pattern){
        int[] res = new int[pattern.length()];
        res[0] = 0;

        for(int i = 1; i < pattern.length(); i++){
            int index = res[i-1];
            while (index > 0 && pattern.charAt(index) != pattern.charAt(i))
                index = res[index-1];
            res[i] = (pattern.charAt(index) == pattern.charAt(i)) ? index + 1 : 0;
        }
        return res;
    }
}