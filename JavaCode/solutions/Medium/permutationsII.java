public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> cal = new ArrayList<Integer>();
        List<List<Integer>> re = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        int[] used = new int[nums.length];
        getpermute(nums, used, cal, re);
        return re;
    }

    void getpermute(int[] nums, int[] used, List<Integer> cal, List<List<Integer>> re){
        if(cal.size() == nums.length){
            List<Integer> temp = new ArrayList<Integer>(cal);
            re.add(temp);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            if(used[i] == 1){
                continue;
            }
            cal.add(nums[i]);
            used[i] = 1;
            getpermute(nums, used, cal, re);
            used[i] = 0;
            cal.remove(cal.size()-1);
            while(i < nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
    }
}