public class Solution {
    /***
     * for each element in input
     *      put count and char into map
     * for each element in input
     *      if count == 1
     *          add to res
     *
     * @param input
     * @return
     */
    public String remove(String input) {
        Map<Character, Integer> charToCount = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(charToCount.containsKey(c)){
                charToCount.put(c, charToCount.get(c) + 1);
            } else {
                charToCount.put(c, 1);
            }
        }

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(charToCount.get(c) == 1)
                res.append(c);
        }
        return res.toString();
    }
}