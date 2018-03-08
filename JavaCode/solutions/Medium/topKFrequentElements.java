public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // map to store element and its freqency
        Map<Integer, Integer> elemMap = new HashMap<>();
        for(int num : nums){
            elemMap.put(num, elemMap.getOrDefault(num, 0) + 1);
        }

        // MaxHeap to get most frequent element
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<Map.Entry<Integer, Integer>>(elemMap.size(), new Comparator<Map.Entry<Integer, Integer>>(){

                    @Override
                    public int compare(Map.Entry<Integer, Integer> elem1,
                                       Map.Entry<Integer, Integer> elem2) {
                        return elem2.getValue() - elem1.getValue();
                    }

                });

        pq.addAll(elemMap.entrySet());
        List<Integer> res = new ArrayList<Integer>();
        // Get elements
        while(!pq.isEmpty() && k > 0){
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }
}