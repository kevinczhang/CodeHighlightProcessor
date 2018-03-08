public class Solution {
    public boolean isPowerOfFour(int num) {
        // first check only one bit is set:
        if ((num & (num -1)) != 0) return false;
        // next check if it's a bit in pos 1, 3, 5 ... 31
        if ((num & 0x55555555) != 0) return true;
        return false;
    }
}