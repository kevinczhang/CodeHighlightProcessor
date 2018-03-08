public class Solution {
    /**
     * 1.   If nums[i] > nums[i-1], that means it wiggles up.
     * The element before it must be a down position.
     *  So up[i] = down[i-1] + 1 and down[i] = down[i-1].
     * 2.   If nums[i] < nums[i-1], that means it wiggles down.
     * The element before it must be a up position.
     *  So down[i] = up[i-1] + 1, up[i] = up[i-1].
     * 3.   If nums[i] == nums[i-1], that means it will not
     *  change anything becaue it didn't wiggle at all.
     *  So both down[i] = down[i-1] and up[i] = up[i−1].
     *
     * At the end, we can find the larger out of up[length-1]up[length−1] and down[length-1]down[length−1] to find the max. wiggle subsequence length, where lengthlength refers to the number of elements in the given array.
     *
    **/
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}