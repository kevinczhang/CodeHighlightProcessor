public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subComb = new ArrayList<>();
        findComb(1, k, n, subComb, res);

        return res;
    }

    private void findComb(int start, int k, int curSum,
                          List<Integer> subComb, List<List<Integer>> res){
        if(subComb.size() == k && curSum == 0){
            List<Integer> temp = new ArrayList<>(subComb);
            res.add(temp);
        }

        for(int i=start; i<=9; i++){
            if(curSum - i < 0) return;
            subComb.add(i);
            findComb(i+1, k, curSum-i, subComb, res);
            subComb.remove(subComb.size()-1);
        }
    }
}