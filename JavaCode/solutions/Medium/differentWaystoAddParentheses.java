public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Vals = diffWaysToCompute(part1);
                List<Integer> part2Vals = diffWaysToCompute(part2);
                for(int j = 0; j < part1Vals.size(); j++){
                    for(int k = 0; k < part2Vals.size(); k++){
                        switch(input.charAt(i)){
                            case '-':
                                res.add(part1Vals.get(j) - part2Vals.get(k));
                                break;
                            case '+':
                                res.add(part1Vals.get(j) + part2Vals.get(k));
                                break;
                            case '*':
                                res.add(part1Vals.get(j) * part2Vals.get(k));
                                break;
                        }
                    }
                }
            } 
        }
        if(res.size() == 0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}