public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> preRow = row;
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                int val = ((j > 0) ? preRow.get(j - 1) : 0)
                        + ((j < preRow.size()) ? preRow.get(j) : 0);
                row.add(val);
            }
        }
        return row;
    }
}