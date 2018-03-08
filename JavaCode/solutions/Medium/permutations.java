public class Solution {
    public List<List<Integer>> permute(int[] num) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curPer = new ArrayList<Integer>();

        int len = num.length;
        int[] used = new int[len];

        getPermutations(num, used, len, curPer, res);

        return res;

    }

    private void getPermutations(int[] num, int[] used, int len,
                                 List<Integer> curPer, List<List<Integer>> res) {

        if(curPer.size() == len){
            ArrayList<Integer> temp = new ArrayList<Integer>(curPer);
            res.add(temp);
            return;
        }

        for(int i=0; i<len; i++){
            if(used[i] != 1){
                used[i] = 1;
                curPer.add(num[i]);
                getPermutations(num, used, len, curPer, res);
                used[i] = 0;
                curPer.remove(curPer.size()-1);
            }
        }
    }
}