public class Solution {
    /**
     * Put nonzero numbers ahead
     * Set rest to be zeros
     */
    public void moveZeroes(int[] nums) {
        int curInd = 0;
        int scanInd = 0;
        while(scanInd < nums.length){
            if(nums[scanInd] == 0){
                scanInd++;
            } else {
                nums[curInd++] = nums[scanInd++];
            }
        }

        while(curInd < nums.length){
            nums[curInd++] = 0;
        }
    }
}