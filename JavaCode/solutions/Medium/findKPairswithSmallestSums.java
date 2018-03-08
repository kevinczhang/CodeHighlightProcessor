public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<int[]>(k, pairComparator);
        
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                minHeap.add(new int[]{nums1[i], nums2[j]});
            }
        }
        
        List<int[]> res = new ArrayList<int[]>();
        while(!minHeap.isEmpty() && res.size() < k){
            res.add(minHeap.poll());
        }
        return res;
    }
    
    Comparator<int[]> pairComparator = new Comparator<int[]>(){
        public int compare(int[] pair1, int[] pair2){
            return pair1[0] + pair1[1] - pair2[0] - pair2[1];
        }
    };
}

