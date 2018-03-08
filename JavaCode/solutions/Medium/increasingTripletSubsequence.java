public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
	    for (int i = 0; i < nums.length; i++) {
		    if (nums[i] <= smallest) {
			    smallest = nums[i];// update x to be a smaller value
		    } else if (nums[i] <= mid) {
			    mid = nums[i]; // update so that mid > smallest  
		    } else {
			    return true;
		    }
	    }
    	return false;
    }
}