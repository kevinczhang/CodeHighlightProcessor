public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;

        Arrays.sort(nums);
        if(nums.length <= 3){
            for(int i = 0; i < n; i++){
                sum += nums[i];
            }
            return sum;
        }

        ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return sum;
                }
                if(Math.abs(target - ans) > Math.abs(target - sum)){
                    ans = sum;
                }
                if(sum > target){
                    k--;
                } else{
                    j++;
                }
            }
        }
        return ans;
    }
}