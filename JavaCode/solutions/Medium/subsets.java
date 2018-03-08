public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();

        for (int level = 0; level <= S.length; level++) {
            getSubsets(S, level, 0, subset, res);
            subset = new ArrayList<Integer>();
        }
        return res;
    }

    private void getSubsets(int[] S, int level, int start, List<Integer> subset, List<List<Integer>> res) {
        if (start == level) {
            ArrayList<Integer> temp = new ArrayList<Integer>(subset);
            res.add(temp);
            return;
        }

        for (int s : S) {
            if (subset.size() == 0 || subset.get(subset.size() - 1) < s) {
                subset.add(s);
                getSubsets(S, level, start + 1, subset, res);
                subset.remove(subset.size() - 1);
            }
        }
    }
}