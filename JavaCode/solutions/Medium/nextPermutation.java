public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int indexdisorder = nums.length - 1;
        while (indexdisorder > 0 && nums[indexdisorder] <= nums[indexdisorder - 1]) {
            indexdisorder--;
        }
        if (indexdisorder == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        indexdisorder--;

        int firstlarger = nums.length - 1;
        while (firstlarger > 0 && nums[firstlarger] <= nums[indexdisorder]) {
            firstlarger--;
        }

        swap(nums, indexdisorder, firstlarger);
        reverse(nums, indexdisorder + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int first, int last) {
        while (first < last) {
            swap(nums, first, last);
            first++;
            last--;
        }
    }

    private void swap(int[] nums, int first, int last) {
        nums[first] = nums[first] + nums[last];
        nums[last] = nums[first] - nums[last];
        nums[first] = nums[first] - nums[last];
    }
}