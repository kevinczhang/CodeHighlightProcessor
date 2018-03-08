public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1)
            return s;
        // string builders for each row
        StringBuilder[] sbs = new StringBuilder[numRows];
        // Have to initialize each element this way
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }
        int rowFlag = 1; // flag to incr or decr
        int rowInd = 0; // index for rows
        for(int i = 0; i < s.length(); i++){
            sbs[rowInd].append(s.charAt(i));
            if(rowInd == numRows - 1)
                rowFlag = -1;
            if(rowInd == 0)
                rowFlag = 1;
            rowInd += rowFlag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : sbs){
            res.append(sb);
        }
        return res.toString();
    }
}