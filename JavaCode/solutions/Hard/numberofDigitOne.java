public class Solution {
    /*********************
     *   There are three cases according to number in digit:
     *    1. cur > 1: i.e. n = 1223. cur at tens-digit
     *      (nums[:cur] + 1)*pow(10, digit) '1' at cur:
     *          130 '1' at tens-digit. (10...19, 110...119,......,1210...1219)
     *    2. cur == 1:  i.e. n = 1213. cur at tens-digit
     *      (nums[:cur])*pow(10, digit) '1' at cur:
     *          120 '1' at tens-digit. (10...19, 110...119,......,1110...1119)
     *      (nums[cur+1:] + 1) '1' at cur:
     *          Four '1' at tens-digit. (1210...1213)
     *    3. cur < 1:  i.e. n = 1203. cur at tens-digit
     *      (nums[:cur])*pow(10, digit) '1' at cur.
     *          120 '1' at tens-digit. (10...19, 110...119,......,1110...1119)
     *************/
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        int totalDigits = String.valueOf(n).length();
        int digit = 0, res = 0;
        while(digit < totalDigits){
            int cur = (int)((n / Math.pow(10, digit)) % 10);
            // Case 3
            res += (int)(n / Math.pow(10, digit+1))*Math.pow(10, digit);
            // Case 1 additional to Case 3
            res += (cur > 1) ? Math.pow(10, digit) : 0;
            // Case 2 additonal
            res += (cur == 1) ? (int)(n % Math.pow(10, digit)) + 1 : 0;
            digit++;
        }
        return res;
    }
}