public class Solution {
    public int reverse(int x) {
        if(x < 10 && x > -10) return x;

        int absX = x > 0 ? x : -x;
        long longRes = 0;
        while(absX > 0){
            longRes = longRes*10 + absX % 10;
            if(longRes > Integer.MAX_VALUE || -longRes < Integer.MIN_VALUE)
                return 0;
            absX /= 10;
        }

        return x > 0 ? (int)longRes : -1*(int)longRes;
    }
}