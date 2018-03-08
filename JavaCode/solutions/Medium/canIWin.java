public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;

        Map<Integer, Boolean> map = new HashMap();
        boolean[] used = new boolean[maxChoosableInteger+1];
        return helper(desiredTotal, used, map);
    }

    private boolean helper(int desiredTotal, boolean[] used, Map<Integer, Boolean> map){
        if(desiredTotal <= 0) return false;
        int key = format(used);
        if(!map.containsKey(key)){
            // try every unchosen number as next step
            for(int i = 1; i < used.length; i++){
                if(used[i]) continue;
                used[i] = true;
                // check whether this lead to a win (i.e. the other player lose)
                if(!helper(desiredTotal - i, used, map)){
                    map.put(key, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    // transfer boolean[] to an Integer
    private int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}