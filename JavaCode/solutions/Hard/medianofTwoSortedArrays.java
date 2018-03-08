public class Solution {
    /***
     * Time Complexity: O(log(n+m))
     * Space Complexity: O(1)
     *
     * if total count is odd then find the one in the middle
     * else find the another one on the left and get average
     *
     * the method of find middle can be converted to find the kth
     * element recursively
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalCount = nums1.length + nums2.length;
        int right = getKthElement(totalCount/2 + 1, nums1, nums2, 0, 0);
        if(totalCount %2 != 0){
            return 1.0*right;
        }
        int left = getKthElement(totalCount/2, nums1, nums2, 0, 0);
        return (left + right)/2.0;
    }

    private int getKthElement(int k, int[] nums1, int[] nums2, int start1, int start2){
        if(start1 >= nums1.length){
            return nums2[start2 + k - 1];
        }
        if(start2 >= nums2.length){
            return nums1[start1 + k - 1];
        }

        if(k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        int mid1 = (start1 + k/2 - 1 < nums1.length) ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int mid2 = (start2 + k/2 - 1 < nums2.length) ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;

        // Key is to use k - k/2 not k/2
        if(mid1 < mid2)
            return getKthElement(k - k/2, nums1, nums2, start1 + k/2, start2);
        return getKthElement(k - k/2, nums1, nums2, start1, start2 + k/2);
    }
}