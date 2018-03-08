public class Solution {
    public int[] singleNumber(int[] nums) {
        int A = 0;
        int B = 0;
        int AXORB = 0;
        for(int i = 0; i<nums.length; i++){
            AXORB ^= nums[i];
        }
        
        // AXORB = (AXORB & (AXORB - 1)) ^ AXORB; //find the different bit
        int lowBit = AXORB & -AXORB;
        for(int i = 0; i<nums.length; i++){
            if((lowBit & nums[i]) == 0)
                A ^= nums[i];
            else
                B ^= nums[i];
        }
        return new int[]{A, B};
    }
}