public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null || needle.length() > haystack.length())
            return -1;
        if (needle.length() == 0){
            return 0;
        }

        int[] overlay = getOverlay(needle);
        int i = 0;
        while (i <= haystack.length() - needle.length()){
            int j = 0;
            while(j < needle.length()){
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    i = j == 0 ? i+1 : i+j-overlay[j-1];
                    break;
                }
                j++;
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }

    // Generate the prefix function for pattern itself
    private int[] getOverlay(String pattern){
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