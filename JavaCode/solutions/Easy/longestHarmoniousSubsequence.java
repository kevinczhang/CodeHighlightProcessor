public class Solution {
    public int findLHS(int[] nums) {
        if(nums.length <= 1) return 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        int res = 0;
        int cur = 0;

        for(int num : nums){
            numsMap.putIfAbsent(num, 0);
            numsMap.put(num, numsMap.get(num) + 1);
        }

        for(int num : nums){
            if(numsMap.containsKey(num + 1)){
                cur = numsMap.get(num) + numsMap.get(num + 1);
            }
            res = cur > res ? cur : res;
        }
        return res;
    }
}