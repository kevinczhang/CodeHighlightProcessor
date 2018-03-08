public class Solution {
    // Just find the size of the left upper corner
    // Time complexity : O(x)
    // Space complexity : O(1)
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}