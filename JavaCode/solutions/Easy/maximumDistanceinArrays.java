public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = 0;
        for(int i = 1; i < arrays.size(); i++){
            int len = arrays.get(i).size();
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(len - 1);
            res = Math.max(res, curMax - min);
            res = Math.max(res, max - curMin);
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
        }
        return res;
    }
}