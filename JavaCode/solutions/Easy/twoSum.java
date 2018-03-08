public class Solution {
    /***
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Build a map between num and it's target
     * for each num in nums
     *  if num's target is in map
     *      return the indexes of this num and the index of the target in the map
     *  put index and target value in map
     *
     * return [-1, -1]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // If the diff from target is in the map
            if(targetToIndex.containsKey(nums[i]))
                return new int[]{targetToIndex.get(nums[i]), i};
            // Otherwise put diff and index to the map
            targetToIndex.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }
}