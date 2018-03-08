public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums == null || nums.length == 0)
            return res;
        res[0] = searchLeft(nums, target);
        if(res[0] != -1)
            res[1] = searchRight(nums, target);
        return res;
    }

    private int searchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        while(left < right - 1){
            if(nums[mid] < target)
                left = mid + 1;
            else {
                right = nums[mid] > target ? mid - 1 : mid;
            }
            mid = left + (right - left)/2;
        }
        // Check left first
        return nums[left] == target ? left :
                nums[right] == target ? right : -1;
    }

    private int searchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        while(left < right - 1){
            if(nums[mid] > target)
                right = mid - 1;
            else {
                left = nums[mid] < target ? mid + 1 : mid;
            }
            mid = left + (right - left)/2;
        }
        // Check right first
        return nums[right] == target ? right :
                nums[left] == target ? left : -1;
    }
}