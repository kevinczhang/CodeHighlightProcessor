public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null) return -1;
        if (nums.length == 1) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) return mid;
                else l = mid + 1;
            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) return mid;
                else r = mid - 1;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] <= nums[mid - 1]) {
                r = mid - 1;
            } else { // nums[mid]<=nums[mid+1]
                l = mid + 1;
            }
        }
        return -1;
    }
}