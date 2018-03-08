public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;
        k = k % nums.length;

        reverseArray(nums, 0, nums.length - 1 - k);
        reverseArray(nums, nums.length - k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] += nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            start++;
            end--;
        }
    }
}