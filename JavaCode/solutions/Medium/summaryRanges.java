public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        if(nums.length == 1){
        	res.add(String.valueOf(nums[0]));
        	return res;
        }

        List<Integer> continueNums = new ArrayList<Integer>();
        continueNums.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]+1 == nums[i])
            	continueNums.add(nums[i]);
            else{
            	if(continueNums.size()==1)
            		res.add(continueNums.get(0).toString());
            	else{
            		res.add(continueNums.get(0) + "->" +
            		    continueNums.get(continueNums.size()-1));
            	}
            	continueNums = new ArrayList<Integer>();
        		continueNums.add(nums[i]);
            }
        }

        if(continueNums.size()==1)
    		res.add(continueNums.get(0).toString());
    	else{
    		res.add(continueNums.get(0) + "->" +
    		    continueNums.get(continueNums.size()-1));
    	}
        return res;
    }
}