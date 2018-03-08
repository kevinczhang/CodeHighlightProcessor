public class Solution {
    // The idea is to use a mask to find the leftmost common digits of m and n.
    // Example: m=1110001, n=1110111, and you just need to find 1110000 and it will be the answer.
    public int rangeBitwiseAnd(int m, int n) {
        int r = Integer.MAX_VALUE;
        while((m & r) != (n & r))
            r = r << 1;
        return n & r;
    }
}