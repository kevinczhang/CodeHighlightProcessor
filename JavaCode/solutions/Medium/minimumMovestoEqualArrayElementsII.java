public class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0;
        int median = quickselect(nums, nums.length / 2 + 1, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++)
            sum += Math.abs(nums[i] - median);
        return sum;
    }

    private int quickselect(int[] A, int k, int start, int end) {
        int l = start, r = end, pivot = A[(l + r) / 2];
        while (l <= r) {
            while (A[l] < pivot) l++;
            while (A[r] > pivot) r--;
            if (l >= r) break;
            swap(A, l++, r--);
        }
        if (l - start + 1 > k)
            return quickselect(A, k, start, l - 1);
        if (l - start + 1 == k && l == r)
            return A[l];
        return quickselect(A, k - r + start - 1, r + 1, end);
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}