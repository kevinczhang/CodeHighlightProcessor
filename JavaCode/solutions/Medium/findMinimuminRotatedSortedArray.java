public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        return getMinFrom(nums, 0, nums.length - 1);
    }

    int getMinFrom(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) return nums[start];
        if (start == end - 1)
            return (nums[start] < nums[end]) ? nums[start] : nums[end];

        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[start])
            return getMinFrom(nums, mid + 1, end);
        else
            return getMinFrom(nums, start, mid);
    }
}