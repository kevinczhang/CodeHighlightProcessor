public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> re = new ArrayList<String>();
        if(n == 0) return re;

        String str = "";
        getParenthesis(n, n, str, re);
        return re;
    }

    private void getParenthesis(int left, int right, String str, List<String>re){
        if(left == 0 && right == 0){
            re.add(str);
            return;
        }

        if(left>0){
            getParenthesis(left-1,right,str+"(",re);
        }

        if(right>left){
            getParenthesis(left,right-1,str+")",re);
        }
    }
}