public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        for(int i = 0; i <=31; i++){
            int offset = (1 << i);
            if((z & offset) > 0)
                res++;
        }
        return res;
    }
}