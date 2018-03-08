public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(num);
        for (int level = 0; level <= num.length; level++) {
            List<Integer> subset = new ArrayList<Integer>();
            getSubsets(num, level, 0, subset, res);
        }
        return res;
    }

    private void getSubsets(int[] num, int level, int start,
                            List<Integer> subset, List<List<Integer>> res) {
        if (subset.size() == level) {
            List<Integer> temp = new ArrayList<Integer>(subset);
            res.add(temp);
            return;
        }

        for (int i = start; i < num.length; i++) {
            subset.add(num[i]);
            getSubsets(num, level, i + 1, subset, res);
            subset.remove(subset.size() - 1);
            while (i < num.length - 1 && num[i + 1] == num[i])
                i++;
        }
    }
}