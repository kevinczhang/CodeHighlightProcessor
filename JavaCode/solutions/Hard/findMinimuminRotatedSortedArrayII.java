public class Solution {
    public int findMin(int[] num) {
        if (num.length == 0) return 0;
        int l = 0;
        int r = num.length - 1;
        int min = num[0];
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (num[l] < num[mid]) {
                min = Math.min(min, num[l]);
                l = mid + 1;
            } else if (num[l] > num[mid]) {
                min = Math.min(min, num[mid]);
                r = mid - 1;
            } else {
                l++;
            }
        }
        return Math.min(Math.min(min, num[l]), num[r]);
    }
}