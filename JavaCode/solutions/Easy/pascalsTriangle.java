public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;

        List<Integer> curRow = new ArrayList<Integer>();
        curRow.add(1);
        res.add(curRow);
        if (numRows == 1)
            return res;

        List<Integer> preRow = curRow;
        for (int i = 2; i < numRows + 1; i++) {
            curRow = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    curRow.add(preRow.get(0));
                } else if (j == i - 1) {
                    curRow.add(preRow.get(j - 1));
                } else {
                    curRow.add(preRow.get(j) + preRow.get(j - 1));
                }
            }
            res.add(curRow);
            preRow = curRow;
        }

        return res;
    }
}