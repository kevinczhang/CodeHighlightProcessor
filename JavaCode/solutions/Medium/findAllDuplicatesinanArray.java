public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // creating a new List
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // Taking the absolute value to find index
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] = -nums[index - 1];
            } else {
                // If it is not greater than 0 (i.e)
                // negative then the number is a duplicate
                newList.add(Math.abs(nums[i]));
            }
        }
        return newList;
    }
}