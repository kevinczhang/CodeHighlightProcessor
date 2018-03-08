public class Solution {
    /***
     *  Use a map to store ranges
     *  Get lower bound with smaller value
     *  Get upper bound with larger value
     *  Update max length with new bound
     *  Put all possible ranges into map
     *  1. num, num
     *  2. low, upp
     *  3. upp, low
     *
     */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> rangeMap = new HashMap<>();
        int maxLen = 0;
        for(int num : nums){
            // Ignore duplicates
            if(rangeMap.containsKey(num)) continue;
            int low = num;
            int upp = num;
            if(rangeMap.containsKey(num - 1))
                low = rangeMap.get(num - 1);
            if(rangeMap.containsKey(num + 1))
                upp = rangeMap.get(num + 1);
            maxLen = Math.max(maxLen, upp - low + 1);
            // All possible ranges
            rangeMap.put(num, num);
            rangeMap.put(low, upp);
            rangeMap.put(upp, low);
        }
        return maxLen;
    }
}