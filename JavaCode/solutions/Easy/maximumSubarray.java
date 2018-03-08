public class Solution {
    // DP solution
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum < 0) ? nums[i] : (sum + nums[i]);
            if (sum > max)
                max = sum;
        }
        return max;
    }

    // Divide and Conquer
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    int divide(int nums[], int low, int high) {
        if (low == high){
            return nums[low];
        }
        if (low == high - 1)
            return Math.max(nums[low] + nums[high], Math.max(nums[low], nums[high]));
        int mid = low + (high - low) / 2;
        int lmax = divide(nums, low, mid - 1);
        int rmax = divide(nums, mid + 1, high);
        int mmax = nums[mid];
        int tmp = mmax;
        for (int i = mid - 1; i >= low; i--) {
            tmp += nums[i];
            if (tmp > mmax){
                mmax = tmp;
            }
        }
        tmp = mmax;
        for (int i = mid + 1; i <= high; i++) {
            tmp += nums[i];
            if (tmp > mmax){
                mmax = tmp;
            }
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
}