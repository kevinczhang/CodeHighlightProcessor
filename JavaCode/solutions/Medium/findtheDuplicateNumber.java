public class Solution {
    // https://segmentfault.com/a/1190000003817671
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // Find where the slow pointer meet fast pointer
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        
        // Use a new pointer to start from begining until
        // it meet with the slow pointer
        int find = 0;
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}