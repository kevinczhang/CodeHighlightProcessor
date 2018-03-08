public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> string1ToIndex = new HashMap<>();
        Map<String, Integer> commonToSum = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        // Put list 1 into map
        for(int i = 0; i <list1.length; i++){
            string1ToIndex.put(list1[i], i);
        }
        // Get common interests and track min sum of indexes
        for(int i = 0; i <list2.length; i++){
            if(string1ToIndex.containsKey(list2[i])){
                int indexSum = string1ToIndex.get(list2[i]) + i;
                minSum = Math.min(minSum, indexSum);
                commonToSum.put(list2[i], indexSum);
            }
        }
        List<String> resList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : commonToSum.entrySet()){
            if(entry.getValue() == minSum)
                resList.add(entry.getKey());
        }
        String[] res = new String[resList.size()];
        for(int i = 0; i < resList.size(); i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}