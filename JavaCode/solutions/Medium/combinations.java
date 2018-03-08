public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();

        getCombinations(n, k, 1, combination, res);
        return res;
    }

    private void getCombinations(int n, int k, int start,
                                 List<Integer> combination, List<List<Integer>> res) {
        if (combination.size() == k) {
            List<Integer> temp = new ArrayList<Integer>(combination);
            res.add(temp);
            return;
        }

        for (int i = start; i < n + 1; i++) {
            combination.add(i);
            getCombinations(n, k, i + 1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}