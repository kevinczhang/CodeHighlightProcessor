public class Solution {
    public int singleNumber(int[] A) {
        if (A.length <= 3) return A[0];

        int bitSum = 0, res = 0;
        for (int i = 0; i < 32; i++) {
            bitSum = 0;
            for (int a : A) {
                if ((a & (1 << i)) != 0) bitSum++;
            }
            if (bitSum % 3 != 0) res |= (1 << i);
        }
        return res;
    }
}