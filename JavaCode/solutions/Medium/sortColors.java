public class Solution {
    public void sortColors(int[] A) {
        int oneIndex = 0, twoIndex = A.length - 1, cur = 0;

        while (cur <= twoIndex) {
            switch (A[cur]) {
                case 0:
                    A[cur] = A[oneIndex];
                    A[oneIndex] = 0;
                    cur++;
                    oneIndex++;
                    break;
                case 1:
                    cur++;
                    break;
                case 2:
                    A[cur] = A[twoIndex];
                    A[twoIndex] = 2;
                    twoIndex--;
                    break;
            }
        }
    }
}