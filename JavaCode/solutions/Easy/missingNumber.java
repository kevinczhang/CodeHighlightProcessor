public class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0], max = nums[0];
        for(int num : nums){
            min = min < num ? min : num;
            max = max > num ? max : num;
        }
        if (min > 0) return 0;
        if (max == (nums.length - 1)) return nums.length;
        int total = max*(max+1)/2;
        for(int num : nums){
            total -= num;
        }
        return total;
    }
}