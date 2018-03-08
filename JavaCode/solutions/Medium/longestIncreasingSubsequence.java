public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            // if(list.size() == 0 or num > last element in list)
            if(list.size() == 0 || num > list.get(list.size()-1)){
                list.add(num);
                continue;
            }
            // replace element which is the smallest but bigger than num
            int i = 0, j = list.size() - 1;
            while(i < j){
                int mid = i + (j - i)/2;
                if(list.get(mid) < num){
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            list.set(j, num);
        }
        return list.size();
    }
}