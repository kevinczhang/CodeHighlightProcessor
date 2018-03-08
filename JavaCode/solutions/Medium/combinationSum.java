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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        getList(candidates, target, li, re, 0);
        return re;
    }

    private void getList(int[] candidates, int target, List<Integer> li,
                         List<List<Integer>> re, int start) {
        if(target==0){
            List<Integer> templi = new ArrayList<>(li);
            if(!re.contains(templi)){
                re.add(templi);
            }
            return;
        }

        for(int i=start; i<candidates.length; i++){
            if(target-candidates[i]>=0){
                li.add(candidates[i]);
                getList(candidates, target-candidates[i], li, re, i);
                li.remove(li.size()-1);
            }
        }
    }
}