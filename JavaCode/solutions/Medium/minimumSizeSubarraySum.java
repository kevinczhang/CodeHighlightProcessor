public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        if(nums[0] >= s) return 1;

        int index = 1, curSum = nums[0], startIndex = 0, minLen = 0;
        while(index < nums.length){
            if(nums[index] >= s) return 1;
            curSum += nums[index];
            if(curSum >= s){
                while(startIndex < index && curSum - nums[startIndex] >= s){
                    curSum -= nums[startIndex++];
                }
                if(minLen == 0 || index-startIndex < minLen)
                    minLen = index-startIndex+1;
            }
            index++;
        }
        return minLen;
    }
}