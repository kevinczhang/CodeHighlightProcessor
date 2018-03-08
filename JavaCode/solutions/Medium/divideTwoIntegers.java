public class Solution {
    // The time complexity is O(logn).
    // This problem can be solved based on the fact that any number
    // can be converted to the format of the following:
    // num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
    public int divide(int dividend, int divisor) {
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        int sign = 1;
        if (dividend < 0) {
            sign *= -1;
        }
        if (divisor < 0) {
            sign *= -1;
        }
        long a = dividend;
        long b = divisor;
        // must cast to long here for dealing with the Integer.MIN_VALUE
        // because Math.abs(-2147483648) > Integer.MAX_VALUE
        a = Math.abs(a);
        b = Math.abs(b);
        int count = 0;
        while (a >= b) {
            long temp = b;
            int multi = 1;
            while (a >= temp) {
                count += multi;
                a -= temp;
                temp += temp;
                multi += multi;
            }
        }
        return count * sign;
    }
}