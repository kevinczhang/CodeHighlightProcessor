public class Solution {
    /***
     * 1. Use first two elements to judge is up or down
     * 2. if it is up:
     * 		Assume A[x] is peak, we have
     * 		A[x] - A[i] = x - i and A[x] - A[j] = j - x
     * 		so x = (A[j] - A[i] + i + j)/2
     * 2. if it is down
     * 		Assume A[x] is vally, we have
     * 		A[x] - A[i] = i - x and A[x] - A[j] = x - j
     * 		x = (A[i] - A[j] + i + j)/2
     */
    public int findPeak(int[] A) {
        boolean isUp = (A[1] > A[0]) ? true : false;
        if (isUp) {
            return (A[A.length - 1] - A[0] + A.length - 1) / 2;
        } else {
            return (A[0] - A[A.length - 1] + A.length - 1) / 2;
        }
    }
}