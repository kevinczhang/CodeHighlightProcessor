public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) return 0;
        int n = A.length, res = Integer.MIN_VALUE;
        for(int start = 0; start < n; start++){
            int cur = 0, curStart = start, newStart = 0;
            for(int i = 0; i < n; i++){
                if(curStart < n){
                    cur += curStart*A[i];
                    curStart++;
                } else {
                    cur += newStart*A[i];
                    newStart++;
                }
            }
            res = Math.max(cur, res);
        }
        return res;
    }
}