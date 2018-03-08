public class Solution {

    // Algorithm:
    // 1. put words into a stack
    // 2. pop out words
    public String reverseWords(String s) {
        if(s == null) return s;
        s = s.trim();
        int len = s.length();
        if(len == 0) return "";

        int startIndex = 0;
        int endIndex = len-1;

        String[] strs = s.split("\\s+");
        int strCount = strs.length;
        StringBuilder res = new StringBuilder();
        for(int i = strCount - 1; i >=0; i--){
            res.append(strs[i]);
            if(i > 0)
                res.append(" ");
        }
        return res.toString();
    }
}