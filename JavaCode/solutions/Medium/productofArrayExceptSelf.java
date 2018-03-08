public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        result[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            result[i] = result[i-1]*nums[i];
        
        for(int i=nums.length-2; i>-1; i--)
            nums[i] = nums[i+1]*nums[i];
        
        result[nums.length-1] = result[nums.length-2];
        for(int i=nums.length-2; i>0; i--){
            result[i] = result[i-1]*nums[i+1];
        }
        result[0] = nums[1];
        return result;
    }
}