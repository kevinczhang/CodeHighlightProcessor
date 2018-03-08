public class Solution {
    
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(num, target, "", 0, 0, res);
        return res;
    }
    
    private void helper(String num, int target, String tmp, long currRes, long prevNum, List<String> res){
        // If result = target and all numbers are used, then it is a valid result
        if(currRes == target && num.length() == 0){
            String exp = new String(tmp);
            res.add(exp);
            return;
        }
        // Search for all possible divided situations
        for(int i = 1; i <= num.length(); i++){
            String currStr = num.substring(0, i);
            // If starts with 0 then not valid
            if(currStr.length() > 1 && currStr.charAt(0) == '0'){
                return;
            }
            // Get current number
            long currNum = Long.parseLong(currStr);
            // Get rid of the current number and what to search in next round
            String next = num.substring(i);
            // If it isn't first char, then operations else it is a number
            if(tmp.length() != 0){
                // multiply
                helper(next, target, tmp+"*"+currNum, (currRes - prevNum) + prevNum * currNum, prevNum * currNum, res);
                // plus
                helper(next, target, tmp+"+"+currNum, currRes + currNum, currNum, res);
                // minus
                helper(next, target, tmp+"-"+currNum, currRes - currNum, -currNum, res); 
            } else {
                // first number
                helper(next, target, currStr, currNum, currNum, res);
            }
        }
    }
}