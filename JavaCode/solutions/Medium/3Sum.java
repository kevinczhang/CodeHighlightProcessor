public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        // i for first element
        for(int i = 0; i < nums.length - 2; i++){
            // Stop if first elem is positive
            if(nums[i] > 0) break;
            // Skip duplicate for first elem
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int secondElemInd = i + 1; // track second elem
            int thirdElemInd = nums.length - 1; // track third elem
            int sum = 0;
            while(secondElemInd < thirdElemInd){
                // secondElemInd > i + 1 to ensure not first element
                if(secondElemInd > i + 1 && nums[secondElemInd] == nums[secondElemInd - 1]){
                    secondElemInd++; // skip duplicate for second element
                    continue;
                }
                // Stop if sum of first two element greater than 0
                if(nums[secondElemInd] + nums[i] > 0) break;
                sum = nums[i] + nums[secondElemInd] + nums[thirdElemInd];
                if(sum == 0){
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[secondElemInd]);
                    li.add(nums[thirdElemInd]);
                    res.add(li);
                    thirdElemInd--;
                    secondElemInd++;
                } else if(sum > 0){
                    thirdElemInd--;
                } else {
                    secondElemInd++;
                }
            }
        }
        return res;
    }
}