public class Solution {
    /**
     * 1. Find the median of the input array
     * 2. 3-way partition the array around median so that left contains greater than median, 
     *      middle contains equal to median, and right contains less than median.
     * 3. Take one from each partition in the order of middle --> left --> right 
     *      (as middle < left > right is wiggle order).  
    **/
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
         
        // Step 1: Find median of the array, return the index of the median
        // Step 2: 3-way sort, put median in the middle, 
        // numbers less than median on the left, 
        // numbers greater than median on the right
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int i = 0;
        int left = 0;
        int right = n - 1;
        
        /**
           DNF order: [9,8,7,6  5,  4,3,2,1]
           DNF Index: [0,1,2,3, 4,  5,6,7,8]
           Wiggle order: [5, 9, 4, 8, 3, 7, 2, 6, 1]
           Wiggle Index: [0, 1, 2, 3, 4, 5, 6, 7, 8]

            Index Mapping: 
            ---------------
            DNF --> Wiggle (value)
            -----------------------
            0 --> 1 (9)
            1 --> 3 (8)
            2 --> 5 (7)
            3 --> 7 (6)
            4 --> 0 (5)
            5 --> 2 (4)
            6 --> 4 (3)
            7 --> 6 (2)
            8 --> 8 (1) 

            that is DNF(i) = WIGGLE((1+2*i)%n)
        **/
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            } else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            } else {
                i++;
            }
        }
    }
    
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
     
    private int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}

	// quick select: kth smallest
	private int findKthLargest(int[] nums, int start, int end, int k) {
		if (start > end)
			return Integer.MAX_VALUE;

		int pivot = nums[end];// Take A[end] as the pivot,
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
				swap(nums, left++, i);
		}
		swap(nums, left, end);// Finally, swap A[end] with A[left]

		if (left == k)// Found kth smallest number
			return nums[left];
		else if (left < k)// Check right part
			return findKthLargest(nums, left + 1, end, k);
		else // Check left part
			return findKthLargest(nums, start, left - 1, k);
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}