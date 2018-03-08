public class Solution {
    // Solution 1: sort first 
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public void wiggleSort(int[] nums) {
        // Sort first
        Arrays.sort(nums);
        // Swap in pair
        for(int i = 2; i < nums.length; i+=2){
            int tmp = nums[i-1];
            nums[i-1] = nums[i];
            nums[i] = tmp;
        }
    }

    // Solution 2: Swap if any of following conditions are true:
    // 1. Odd index and nums[i] < nums[i - 1]
    // 2. Even index and nums[i] > nums[i - 1]
    // Time: O(N); Space: O(1)
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if((i % 2 == 1 && nums[i] < nums[i-1]) || 
                (i % 2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
