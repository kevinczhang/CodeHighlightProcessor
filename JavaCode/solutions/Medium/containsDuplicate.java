public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1) return false;

        Set<Integer> numSet = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            if(numSet.contains(nums[i])) return true;
            numSet.add(nums[i]);
        }
        return false;
    }
}