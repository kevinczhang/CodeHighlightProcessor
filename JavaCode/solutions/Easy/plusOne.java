public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1; i >= 0; i--){
            if((digits[i] + carry) < 10){
                digits[i] = digits[i] + carry;
                return digits;
            }else{
                digits[i] = digits[i] + carry - 10;
                carry = 1;
            }
        }

        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}