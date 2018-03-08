public class Solution {
    public int search(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == target)
                return m;
            if (A[l] <= A[m]) {
                if (target >= A[l] && target <= A[m])
                    r = m;
                else
                    l = m + 1;
            } else {
                if (target <= A[r] && target >= A[m])
                    l = m;
                else
                    r = m - 1;
            }
        }
        return -1;
    }
}