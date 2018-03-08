public class Solution {
    /**
     * Time Complexity: C(n,1) + C(n,2) + ..C(n, n) = O(2^n)
     * where n is the size of candidates,
     * and k is the max repeated times for each candidates.
     * Space complexity: O(m) where m is the size of array for the solution
     *
     * @param candidates
     * @param target
     * @return
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        getList(candidates, target, new ArrayList<Integer>(), re, 0);
        return re;
    }

    private void getList(int[] candidates, int target, List<Integer> li, List<List<Integer>> re, int start) {
        if (target <= 0) {
            if (target == 0) {
                List<Integer> templi = new ArrayList<Integer>(li);
                re.add(templi);
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]){
                continue; // skip duplicates
            }
            li.add(candidates[i]);
            getList(candidates, target - candidates[i], li, re, i+1);
            li.remove(li.size() - 1);
        }
    }
}