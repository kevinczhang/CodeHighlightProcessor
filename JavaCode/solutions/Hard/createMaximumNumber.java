public class Solution {
    // http://blog.csdn.net/u010025211/article/details/50527279
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for(int i = Math.max(0, k-nums2.length); i <= k && i <= nums1.length; ++i){
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
            if(greater(candidate, 0, ans, 0))
                ans = candidate;
        }
        return ans;
    }
    // Given one array of length n, create the maximum number of length k
    public int[] maxArray(int[] nums,int k){
        int[] ans = new int[k];
        int j = 0;
        for(int i = 0; i < nums.length; ++i){
            while(nums.length-i+j > k && j > 0 && ans[j-1] < nums[i]) j--;
            if(j < k)
                ans[j++] = nums[i];
        }
        return ans;
    }
    //Given two array of length m and n, create maximum number of length k = m + n.
    private int[] merge(int[] nums1, int[] nums2, int k){
        int[] ans = new int[k];
        int i = 0, j = 0, r = 0;
        while(r < k)
            ans[r++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }
    // Compare nums1 with nums2 from index i and j
    boolean greater(int[] nums1, int i, int[] nums2, int j){
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}