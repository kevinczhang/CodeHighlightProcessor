public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            List<Integer> indexes = map.containsKey(nums[i]) ?
                map.get(nums[i]) : new ArrayList<Integer>();
            for(int ind=0; ind < indexes.size(); ind++){
                if(Math.abs(i - indexes.get(ind)) <= k) return true;
            }
            indexes.add(i);
            map.put(nums[i], indexes);
        }
        return false;
    }
}