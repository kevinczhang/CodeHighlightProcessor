public class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");
        for(int i = 0; i < strs.length; i++){
            StringBuilder sb = new StringBuilder(strs[i]);
            res.append(sb.reverse());
            if(i != strs.length-1){
                res.append(" ");
            }
        }
        return res.toString();
    }
}