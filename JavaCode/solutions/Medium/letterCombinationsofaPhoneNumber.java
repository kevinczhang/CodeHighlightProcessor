public class Solution {
    /**
     * Time Complexity ~ O(3^n), Space Compelxity - O(n);
     *
     * backtracking，same as permutation
     * backtracking for the letters for each number
     *
     */
    public List<String> letterCombinations(String digits) {
        List<String> re = new ArrayList<>();
        if(digits.length() == 0){
            return re;
        }
        char[][] pad = {
                {'0'},
                {'1'},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'},
        };

        getletters(digits, pad, re, "", 0);
        return re;
    }

    private void getletters(String digits, char[][] pad,
                            List<String> re, String str, int start){
        if(str.length() == digits.length()){
            re.add(str);
            return;
        }

        int temp = digits.charAt(start)-'0';
        for(int j = 0; j < pad[temp].length; j++){
            getletters(digits, pad, re, str + pad[temp][j], start+1);
        }
    }
}