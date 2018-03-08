public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        boolean gotOne = false;
        for(int i=0; i<32; i++){
            int bit = n & (1 << i);
            if(bit != 0 && gotOne) return false;
            if(bit != 0)
                gotOne = true;
        }
        return true;
    }
}